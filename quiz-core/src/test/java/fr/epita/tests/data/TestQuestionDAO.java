package fr.epita.tests.data;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionDAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DefaultDataTestContextConfiguration.class)
public class TestQuestionDAO {

    @Inject
    @Named("main-ds")
    DataSource dataSource;


    @BeforeEach
    public void setup() throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql =
                "CREATE TABLE IF NOT EXISTS QUESTION(" +
                "id INTEGER auto_increment," +
                "title VARCHAR(500)" +
                ")";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

    }

    @Test
    public void testDAOCreate() throws SQLException {
        //given
        Question question = new Question("what is dependency injection?");
        QuestionDAO dao = new QuestionDAO(dataSource);

        //when
        dao.create(question);

        //then
        ResultSet resultSet = dataSource.getConnection().prepareStatement("SELECT * FROM QUESTION WHERE title='what is dependency injection?'").executeQuery();
        Assertions.assertTrue(resultSet.next());
        Assertions.assertEquals(resultSet.getInt("id"), question.getId());

    }

    @Test
    public void testDAO_Update() throws SQLException {
        //given
        QuestionDAO dao = new QuestionDAO(dataSource);
        Question test = new Question("test");
        dao.create(test);

        //when
        String newTitle = "new title";
        test.setTitle(newTitle);
        dao.update(test);


        //then
        PreparedStatement verificationStatement = dataSource.getConnection().prepareStatement("SELECT * FROM QUESTION WHERE id=?");
        verificationStatement.setInt(1, test.getId());
        ResultSet resultSet = verificationStatement.executeQuery();
        Assertions.assertTrue(resultSet.next());
        Assertions.assertEquals(resultSet.getString("title"), newTitle);

    }




}

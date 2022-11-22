package fr.epita.tests.orm;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionJPADAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ORMTestContextConfiguration.class)
public class TestJPADAO {

    @Inject
    QuestionJPADAO jpadao;

    @Inject
    DataSource ds;

    @Test
    public void testJPADAO() throws SQLException {
        //given
        Question question1 = new Question("test");
        Question question2 = new Question("test2");

        //when
        jpadao.create(question1);
        jpadao.create(question2);

        //then
        ResultSet resultSet = ds.getConnection().prepareStatement("SELECT count(1) as cnt FROM QUESTIONS WHERE Q_TITLE IN ('test', 'test2')").executeQuery();
        resultSet.next();
        int cnt = resultSet.getInt("cnt");
        Assertions.assertEquals(2, cnt);
    }

    @Test
    public void testJPADAOSearch() throws SQLException {
        //given
        ds.getConnection().prepareStatement("INSERT INTO QUESTIONS(q_id, q_title) VALUES (999,'ça va?')").execute();
        Question criteria = new Question("ça va?");

        //when
        List<Question> results = jpadao.search(criteria);

        //then
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(criteria.getTitle(), results.get(0).getTitle());
    }

}

package fr.epita.services.data;

import fr.epita.datamodel.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class QuestionDAO {


    private static final String INSERT = "INSERT INTO QUESTION(title) VALUES(?)";
    private static final Logger LOGGER = LogManager.getLogger(QuestionDAO.class);

    DataSource dataSource;

    public QuestionDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void create(Question question) {


        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, question.getTitle());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt("id");
            question.setId(id);
        } catch (SQLException sqle) {
            LOGGER.error("error while doing the insertion",sqle);
        }
    }

    public void update(Question question){

    }

    public void delete(Question question){

    }

    public List<Question> search(Question question){
        return null;
    }
}

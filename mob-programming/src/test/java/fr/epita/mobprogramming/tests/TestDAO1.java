package fr.epita.mobprogramming.tests;


import fr.epita.mobprogramming.datamodel.Competitor;
import fr.epita.mobprogramming.services.CompetitorJDBCDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestContext.class)
public class TestDAO1 {

    @Inject
    CompetitorJDBCDAO dao;

    @Inject
    DataSource ds;

    @Test
    public void testCreate() throws SQLException {
        //given
        Competitor competitor = new Competitor(/**/);
        competitor.setFamilyName("test");

        //when
        dao.create(competitor);

        //then
        PreparedStatement preparedStatement = ds.getConnection().prepareStatement("SELECT FAMILY_NAME FROM COMPETITORS WHERE FAMILY_NAME=?");
        preparedStatement.setString(1, "test");
        preparedStatement.executeQuery();

        //check the resultSet...


    }


}

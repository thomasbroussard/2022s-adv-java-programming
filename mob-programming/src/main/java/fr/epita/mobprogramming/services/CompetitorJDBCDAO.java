package fr.epita.mobprogramming.services;

import fr.epita.mobprogramming.datamodel.Competitor;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompetitorJDBCDAO {

    private final DataSource dataSource;

    public CompetitorJDBCDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void create(Competitor competitor){

    }

    public List<Competitor> search(Competitor criteria) throws SQLException {
        String query ="SELECT country, age, family_name, given_name, weight FROM COMPETITORS " +
                "WHERE ? is null or country = ?" +
                "AND ? is null or age = ? ";

        PreparedStatement preparedStatement = this.dataSource.getConnection().prepareStatement(query);
        preparedStatement.setString(1, criteria.getCountry());
        preparedStatement.setString(2, criteria.getCountry());

        preparedStatement.setString(3, criteria.getAgeCategory());
        preparedStatement.setString(4, criteria.getAgeCategory());

        ResultSet resultSet = preparedStatement.executeQuery();


    }
}

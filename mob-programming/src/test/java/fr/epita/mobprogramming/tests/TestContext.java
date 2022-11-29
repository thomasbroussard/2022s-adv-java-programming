package fr.epita.mobprogramming.tests;

import fr.epita.mobprogramming.services.CompetitorJDBCDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TestContext {

    @Bean("firstBean")
    public String test(){
       return  "Hello from Spring, Thomas";
    }

    @Bean(name = "main-ds")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setPassword("test");
        dataSource.setUsername("test");
        return dataSource;
    }

    @Bean("competitor-dao")
    public CompetitorJDBCDAO dao(@Qualifier("main-ds") DataSource ds){
        return new CompetitorJDBCDAO(ds);
    }
}

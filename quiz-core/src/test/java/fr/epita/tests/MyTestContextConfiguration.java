package fr.epita.tests;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyTestContextConfiguration {

    @Bean
    public String getTestString(){
        return "hello from spring";
    }


    @Bean(name="main-test-string")
    public String getTestString2(){
        return "hello from spring 2";
    }

    @Bean(name = "main-ds")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setPassword("test");
        dataSource.setUsername("test");
        return dataSource;
    }
}

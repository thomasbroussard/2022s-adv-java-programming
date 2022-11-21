package fr.epita.tests.orm;


import fr.epita.datamodel.Question;
import fr.epita.services.QuestionJPADAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ORMTestContextConfiguration {

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
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
       // dataSource.setUrl("jdbc:h2:tcp://localhost/./test");
        dataSource.setPassword("test");
        dataSource.setUsername("sa");
        return dataSource;
    }

    @Bean(name ="sessionFactory")
    public LocalSessionFactoryBean factory(@Qualifier("main-ds") DataSource ds){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        // 1. connection => h2
        sessionFactoryBean.setDataSource(ds);

        // 2. packages containing the data model to be bound to the database => packages containing annotated classes
        String packages = "fr.epita.datamodel";
        sessionFactoryBean.setPackagesToScan(packages);

        // 3. dialect and other properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean(name ="questionJPADAO")
    public QuestionJPADAO getQuestionJPADAO(@Qualifier("sessionFactory") SessionFactory factory){
        return new QuestionJPADAO(factory);
    }
}

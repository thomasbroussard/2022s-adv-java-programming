package fr.epita.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MyTestContextConfiguration.class)
public class TestJdbcConnect {


    private static final Logger LOGGER = LogManager.getLogger(TestJdbcConnect.class);

    @Inject
    @Named("main-ds")
    private DataSource ds;

    @Inject
    @Named("main-test-string")
    private String test;


//    public void test(){
//        Configuration configuration = new Configuration();
//        String url = configuration.getValue("jdbc.url");
//        String user = configuration.getValue("jdbc.user");
//        String password = configuration.getValue("jdbc.pwd");
//        Connection connection = DriverManager.getConnection(url, user, password);
//    }

    @Test
    public void testWithDI(){
        Assertions.assertNotNull(test);
        LOGGER.info(test);
    }


    @Test
    public void testDataSource() throws SQLException {
        Assertions.assertNotNull(ds);
        Connection connection = ds.getConnection();
        String schema = connection.getSchema();

        LOGGER.info("got this schema {}", schema);

        Assertions.assertEquals("PUBLIC", schema);
        connection.close();
    }

}

package fr.epita.mobprogramming.tests;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestContext.class)
public class TestSPR4 {

    @Inject
    DataSource ds;

    @Test
    public void test() throws SQLException {
        Assertions.assertThat(ds.getConnection().getSchema()).isEqualTo("PUBLIC");
    }


}

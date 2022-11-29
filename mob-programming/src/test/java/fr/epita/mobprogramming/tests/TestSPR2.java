package fr.epita.mobprogramming.tests;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestContext.class)
public class TestSPR2 {

    @Inject
    @Named("firstBean")
    String helloWorld;

    @Test
    public void test(){
        Assertions.assertThat(helloWorld).isEqualTo("Hello from Spring, Thomas");
    }


}

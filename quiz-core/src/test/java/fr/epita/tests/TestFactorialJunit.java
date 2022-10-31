package fr.epita.tests;

import fr.epita.maths.Factorial;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFactorialJunit {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test(){
        //given
        int number = 5;

        //when
        int result = new Factorial().factorial(number);

        //then
        assertThat(result).isEqualTo(120);
        System.out.println("firstTest");
    }

    @Test
    public void test2(){
        System.out.println("another test");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

}

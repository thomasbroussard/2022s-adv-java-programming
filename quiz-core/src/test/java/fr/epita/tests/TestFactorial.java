package fr.epita.tests;

import fr.epita.maths.Factorial;

public class TestFactorial {

    public static void main(String[] args) {
        //given
        int number = 5;

        //when
        int result = new Factorial().factorial(number);

        //then
        if (result != 120){
            throw new AssertionError("expected 120, but got " + result);
        }
    }

}

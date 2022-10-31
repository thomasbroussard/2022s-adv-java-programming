package fr.epita.maths;

public class Factorial {

    public int factorial(int n){
        int result = n;
        for (int i = n-1; i > 0; i--){
            result *= i;
        }
        return result;
    }

}

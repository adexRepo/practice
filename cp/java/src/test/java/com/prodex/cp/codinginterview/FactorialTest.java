package com.prodex.cp.codinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    /*
     * NOTE
     * buat function factorial
     */

    /* --------------------------------- Method --------------------------------- */

    public int factorialFirstWay(int value) {
        if (value <= 0)
            return 1;

        int result = 1;
        for (int i = value; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public int factorialRecursive(int value){
        if(value <= 0) {
            return 1;
        }else{
            return value * factorialRecursive(value-1);
        }

        // 5 * factorial(4)
        // 5 * 4 * factorial(3)
        // 5 * 4 * 3 * factorial(2)
        // 5 * 4 * 3 * 2 * factorial(1)
        // 5 * 4 * 3 * 2 * 1 * factorial(0)
        // 5 * 4 * 3 * 2 * 1 * 1 = 120
        // factorial(5) * factorial(4) * factorial(3) * factorial(2) * factorial(1) * factorial(0)
        // factorial 5 nunggu factorial 4 nunggu factorial 3 dst
        // agar ga nunggu pakai tail recursive;
    }

    public int factorialTailRecurcive(int value , int totalSum){
        // tail recursive biasanya lebih dari 1;

        if(value <= 0) {
            return totalSum;
        }else{
            return factorialTailRecurcive(value-1,value * totalSum);
        }

        // factorialTailRecurcive(5,1)
        // factorialTailRecurcive(4,5)
        // factorialTailRecurcive(3,20)
        // factorialTailRecurcive(2,60)
        // factorialTailRecurcive(1,120)
        // factorialTailRecurcive(0,120)
        // return 120
    }

    /* ---------------------------------- Test ---------------------------------- */

    @Test
    void test() {
        // var result = factorialTailRecurcive(1,1);
        // System.out.println("result: " + result);
        // var result = factorialFirstWay(6);
        // System.out.println("result: " + result);
    }

    @Test
    void testFactorialFirstWay() {
        Assertions.assertEquals(1, factorialFirstWay(0));
        Assertions.assertEquals(1, factorialFirstWay(1));
        Assertions.assertEquals(6, factorialFirstWay(3));
        Assertions.assertEquals(24, factorialFirstWay(4));
        Assertions.assertEquals(720, factorialFirstWay(6));
    }

    @Test
    void testFactorialRecursive() {
        Assertions.assertEquals(1,   factorialRecursive(0));
        Assertions.assertEquals(1,   factorialRecursive(1));
        Assertions.assertEquals(6,   factorialRecursive(3));
        Assertions.assertEquals(24,  factorialRecursive(4));
        Assertions.assertEquals(720, factorialRecursive(6));
    }

    @Test
    void testFactorialTailRecursive() {
        Assertions.assertEquals(1,   factorialTailRecurcive(0,1));
        Assertions.assertEquals(1,   factorialTailRecurcive(1,1));
        Assertions.assertEquals(6,   factorialTailRecurcive(3,1));
        Assertions.assertEquals(24,  factorialTailRecurcive(4,1));
        Assertions.assertEquals(720, factorialTailRecurcive(6,1));
    }

}

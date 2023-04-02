package com.prodex.cp.codinginterview;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    /* 
     * NOTE :
     * Tampilkan Fizz jika habis dibagi 3
     * Tampilkan Buzz jika habis dibagi 5
     * Tampilkan FizzBuzz jika habis dibagi 3 dan 5
     * dan tampilkan angka jika tidak sesuai kondisi diatas.
     */

    public final static String FIZZ_BUZZ = "FizzBuzz";
    public final static String FIZZ = "Fizz";
    public final static String BUZZ = "Buzz";

    /* --------------------------------- Method --------------------------------- */
    public void fizzBuzz(int numbers) {
        for (int i = 1; i < numbers; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " - " + FIZZ_BUZZ);
            } else if (i % 3 == 0) {
                System.out.println(i + " - " + FIZZ);
            } else if (i % 5 == 0) {
                System.out.println(i + " - " + BUZZ);
            } else {
                System.out.println(i);
            }
        }
        // big o notation : O(N)
    }

    /* ---------------------------------- Test ---------------------------------- */
    @Test
    void testFizzBuzz() {
        fizzBuzz(50);
    }
}

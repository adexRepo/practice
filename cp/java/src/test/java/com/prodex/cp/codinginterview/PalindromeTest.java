package com.prodex.cp.codinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    /*
     * NOTE :
     * Palindrome adalah sebuah kata, frasa, angka maupun susunan lainnya yang
     * dapat dibaca dengan sama baik dari depan maupun belakang.
     * Tugas anda buat function apakah suatu kata, frasa, angka atau susunan
     * lainnya dari suatu string adalah palindrome.
     * 
     * kodok => palindrome
     * apa => palindrome
     * abs => not palindrome
     * joni => palindrome
     */

    /* --------------------------------- Method --------------------------------- */

    public boolean isPalindromeFirstWay(String value) {

        StringBuilder sb = new StringBuilder(); // thread unsafe
        // StringBuffer sb2 = new StringBuffer(); // thread safe

        for (int i = value.length() - 1; i >= 0; i--) {
            sb.append(value.charAt(i));
        }

        return sb.toString().equals(value);

        // 1. loop dari belakang ke depan value nya
        // 2. masukkin ke Stringbuilder
        // 3. compare
    }

    public boolean isPalindromeSecondWay(String value) {

        for (int i = 0; i < value.length() / 2; i++) {
            int iFirst = i;
            int iLast = value.length() - i - 1;

            if (!(value.charAt(iFirst) == value.charAt(iLast))) {
                return false;
            }
        }
        return true;

        // 1. looping string dibagi 2
        // 1a. dibagi 2 karena palindrome awal dan akhir sama. jadi gaperlu di looping
        // sampai akhir
        // 1b. kalo kodok = k,o nya aja yg dilooping, gaperlu k,o,d,o,k
        // 2. compare huruf pertama dan huruf terakhir setengahnya saja.
        // 3. sekali aja false maka return bukan palindrome
    }

    public boolean isPalindromeThirdWay(String value, int index) {
        // recursive way

        var currentIdxChar = value.charAt(index);
        var lastIdxChar = value.charAt(value.length() - 1 - index);
        var isSameChar = currentIdxChar == lastIdxChar;

        if(!isSameChar) return false;

        if (index < value.length() / 2 - 1) { // loop setengahnya aja
            index++;
            return isPalindromeThirdWay(value, index);
        } else {
            return true;
        }
        // big o notation : O(N)
    }

    public boolean isPalindromeThirdWayHub(String value){
        return isPalindromeThirdWay(value,0);
    }   

    /* ---------------------------------- Test ---------------------------------- */

    @Test
    void test() {
        // var isPalin = isPalindromeThirdWay("joni", 0);
        // var isPalin = isPalindromeSecondWay("kodok");
        // System.out.println("isPalin: " + isPalin);
    }

    @Test
    void testPalindromeFirstWay() {
        Assertions.assertTrue(isPalindromeFirstWay("ada"));
        Assertions.assertTrue(isPalindromeFirstWay("kodok"));
        Assertions.assertTrue(isPalindromeFirstWay("12321"));
        Assertions.assertTrue(isPalindromeFirstWay("!@#@!"));
        Assertions.assertTrue(isPalindromeFirstWay("apapa"));

        Assertions.assertFalse(isPalindromeFirstWay("adex"));
        Assertions.assertFalse(isPalindromeFirstWay("kadek"));
        Assertions.assertFalse(isPalindromeFirstWay("123421"));
        Assertions.assertFalse(isPalindromeFirstWay("!@#%$#@!"));
    }

    @Test
    void testPalindromeSecondWay() {
        Assertions.assertTrue(isPalindromeSecondWay("ada"));
        Assertions.assertTrue(isPalindromeSecondWay("kodok"));
        Assertions.assertTrue(isPalindromeSecondWay("12321"));
        Assertions.assertTrue(isPalindromeSecondWay("!@#@!"));
        Assertions.assertTrue(isPalindromeSecondWay("apapa"));

        Assertions.assertFalse(isPalindromeSecondWay("adex"));
        Assertions.assertFalse(isPalindromeSecondWay("kadek"));
        Assertions.assertFalse(isPalindromeSecondWay("123421"));
        Assertions.assertFalse(isPalindromeSecondWay("!@#%$#@!"));
    }

    @Test
    void testPalindromeThirdWay() {
        Assertions.assertTrue(isPalindromeThirdWay("ada",0));
        Assertions.assertTrue(isPalindromeThirdWay("kodok",0));
        Assertions.assertTrue(isPalindromeThirdWay("12321",0));
        Assertions.assertTrue(isPalindromeThirdWay("!@#@!",0));
        Assertions.assertTrue(isPalindromeThirdWay("apapa",0));

        Assertions.assertFalse(isPalindromeThirdWay("adex",0));
        Assertions.assertFalse(isPalindromeThirdWay("kadek",0));
        Assertions.assertFalse(isPalindromeThirdWay("123421",0));
        Assertions.assertFalse(isPalindromeThirdWay("!@#%$#@!",0));
    }
    @Test
    void testPalindromeThirdWayHub() {
        Assertions.assertTrue(isPalindromeThirdWayHub("ada"));
        Assertions.assertTrue(isPalindromeThirdWayHub("kodok"));
        Assertions.assertTrue(isPalindromeThirdWayHub("12321"));
        Assertions.assertTrue(isPalindromeThirdWayHub("!@#@!"));
        Assertions.assertTrue(isPalindromeThirdWayHub("apapa"));
        
        Assertions.assertFalse(isPalindromeThirdWayHub("adex"));
        Assertions.assertFalse(isPalindromeThirdWayHub("kadek"));
        Assertions.assertFalse(isPalindromeThirdWayHub("123421"));
        Assertions.assertFalse(isPalindromeThirdWayHub("!@#%$#@!"));
    }

}

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.font.TrueTypeFont;

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Created by s1338673 on 19/03/16.
 */
public class Task2Tests {


    // Normal case, input greater than pattern
    //categories: input: non empty with one atomic region
    //pattern: multiple character. present only in atomic region
    //replace: multiple chars
    //delimeter: special char
    @Test
    public void testitf1() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS TEST# CASE";
        String pattern = "TE";
        String replace = "BE";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #IS BEST# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }


    //categories: input: non empty with multiple atomic region
    //pattern single char, present in every region
    //replace: multiple
    //delimeter: special char
    @Test
    public void testitf4() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS# TEST #IS# CASE";
        String pattern = "I";
        String replace = "XYZ";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #XYZS# TEST #XYZS# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //categories: input: non empty, 2 regions
    //pattern: single char, only in one region
    //replace: multiple
    //delimeter: special char
    //pattern and input are same

    @Test
    public void testitf6() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS# TEST #THE# CASE";
        String pattern = "I";
        String replace = "XYZ";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #XYZS# TEST #THE# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //categories: input: non empty
    //pattern: same as input
    //replace: multiple
    //delimeter: special char
    //pattern and input are same
    @Test
    public void testitf7() {
        StringUtils stringutils = new StringUtils();
        String input = "#TEST#";
        String pattern = "TEST";
        String replace = "Asdf";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "#Asdf#";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //categories: input: non empty
    //pattern: multiple chars, present in input
    //replace: empty
    //delimeter: special char
    //Replace is empty string
    @Test
    public void testitf8() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #TEST# CASE";
        String pattern = "TE";
        String replace = "";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #ST# CASE";
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //categories: input: non empty
    //pattern: multiple chars, present in input
    //replace: multiple
    //delimeter: escape char
    //Backslash is the delimiter, search and replace within atomic region. SPEC 5
    @Test
    public void testitf9() {
        StringUtils stringutils = new StringUtils();
        String input = "\\#THIS #TEST# CASE\\#";
        String pattern = "TE";
        String replace = "BA";
        char delimiter = '\\';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "\\#THIS #BAST# CASE\\#";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //categories: input: non empty
    //pattern: single chars, present in input multiple times is one region
    //replace: multiple
    //delimeter: special char
    //Multiple replaces within the same region
    @Test
    public void testitf10() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS IN #TEST CASE";
        String pattern = "I";
        String replace = "ABC";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #ABCS ABCN #TEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //categories: input: non empty
    //pattern: multiple chars, present in input multiple times is multiple region
    //replace: multiple
    //delimeter: special char
    //Multiple replaces within Multiple region
    @Test
    public void testitf11() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS IN# TEST #IS IM# CASE";
        String pattern = "I";
        String replace = "ABC";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #ABCS ABCN# TEST #ABCS ABCM# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //categories: input: non empty
    //pattern: multiple chars
    //replace: multiple
    //delimeter: alphabet

    @Test
    public void testitf14() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS aIS THEa TEST CASE";
        String pattern = "IS";
        String replace = "ABC";
        char delimiter = 'a';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS aABC THEa TEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //categories: input: non empty
    //pattern: multiple chars
    //replace: multiple
    //delimeter: number

    @Test
    public void testitf15() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS 1IS THE1 TEST CASE";
        String pattern = "IS";
        String replace = "ABC";
        char delimiter = '1';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS 1ABC THE1 TEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    @Test
    public void testitf16() {
        StringUtils stringutils = new StringUtils();
        String input = "QUICK asd BROWN asd FOX asd JUMPED asd OVER THE YELLOW DOG";
        String pattern = "asd";
        String replace = "qwe";
        char delimiter = '1';
        boolean inside = false;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "QUICK qwe BROWN qwe FOX qwe JUMPED qwe OVER THE YELLOW DOG";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }


    //categories: input: 3 atomic regions
    //pattern: single chars
    //replace: multiple
    //delimeter: special char

    @Test
    public void testitf17() {
        StringUtils stringutils = new StringUtils();
        String input = "THE #QUICK# BR#OWN FOX IS CL#E#VER I#N FORREST";
        String pattern = "I";
        String replace = "ABC";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THE #QUABCCK# BR#OWN FOX ABCS CL#E#VER ABC#N FORREST";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    @Test
    public void testitf18() {
        StringUtils stringutils = new StringUtils();
        String input = "#THIS IS TEST# #IS # TEST CASE#";
        String pattern = "TE";
        String replace = "BE";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "#THIS IS BEST# #IS # TEST CASE#";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //inside set to false, pattern found outside atomic region
    @Test
    public void testitf19() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS IS TEST# IS # TEST CASE";
        String pattern = "TE";
        String replace = "BE";
        char delimiter = '#';
        boolean inside = false;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS IS BEST# IS # BEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //inside set to false, one pattern found outside atomic region one inside
    @Test
    public void testitf20() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS IS TEST# IS # #TEST# CASE";
        String pattern = "TE";
        String replace = "BE";
        char delimiter = '#';
        boolean inside = false;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS IS BEST# IS # #TEST# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);

    }

    //pattern bigger than input
    @Test
    public void testitf13() {
        StringUtils stringutils = new StringUtils();
        String input = "#TEST#";
        String pattern = "TESTIS";
        String replace = "ABC";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "#TEST#";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }


    //Multiple occurence of pattern in input string. pattern in no regions
    @Test
    public void testitf5() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #THE# TEST #THE# CASE";
        String pattern = "I";
        String replace = "XYZ";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #THE# TEST #THE# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans , true);

    }
    //categories: input: non empty with multiple atomic region
    //pattern single char, present in one region
    //replace: multiple
    //delimeter: special char
    //Multiple occurence of pattern in input string. pattern in one regions


    //pattern only found outside atomic area
    @Test
    public void testitf12() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS# TEST CASE";
        String pattern = "ST";
        String replace = "ABC";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #IS# TEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //empty pattern
    @Test
    public void testitf21() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #IS# TEST CASE";
        String pattern = "";
        String replace = "ABC";
        char delimiter = ' ';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #IS# TEST CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

    //empty input text and pattern
    @Test
    public void testitf22() {
        StringUtils stringutils = new StringUtils();
        String input = "";
        String pattern = "";
        String replace = null;
        char delimiter = ' ';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans, true);
    }

//    @Test
//    public void testitf23() {
//        StringUtils stringutils = new StringUtils();
//        String input = "Thi\\s is t\\\\he pattern strin\\\\\\g";
//        String pattern = "This is t\\he pattern strin\\g";
//        String replace = null;
//        char delimiter = '\\';
//        boolean inside = true;
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        String expected = "This is t\\he pattern strin\\g";
//        //System.out.print(output);
//        boolean ans = output.equals(expected);
//        assertEquals(ans, true);
//    }





}

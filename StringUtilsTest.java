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
public class StringUtilsTest {


    // Normal case, input greater than pattern
    //categories: input: non empty with one atomic region
    //pattern: multiple character. present only in atomic region
    //replace: multiple chars
    //delimeter: special char
    @Test
    public void testitf1()
    {
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
        assertEquals(ans , true);

    }



    //categories: input: non empty with multiple atomic region
    //pattern single char, present in every region
    //replace: multiple
    //delimeter: special char
    @Test
    public void testitf2() {
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
        assertEquals(ans , true);

    }

    //categories: input: non empty, 2 regions
    //pattern: single char, only in one region
    //replace: multiple
    //delimeter: special char
    //pattern and input are same

    @Test
    public void testitf3() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #ISI# TEST #THE# CASE";
        String pattern = "I";
        String replace = "XYZ";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #XYZSXYZ# TEST #THE# CASE";
        //System.out.print(output);
        boolean ans = output.equals(expected);
        assertEquals(ans , true);

    }
    //categories: input: non empty
    //pattern: same as input
    //replace: multiple
    //delimeter: special char
    //pattern and input are same
    @Test
    public void testitf4() {
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
        assertEquals(ans , true);

    }

    //categories: input: non empty
    //pattern: multiple chars, present in input
    //replace: empty
    //delimeter: special char
    //Replace is empty string
    @Test
    public void testitf5() {
        StringUtils stringutils = new StringUtils();
        String input = "THIS #TEST# CASE";
        String pattern = "TE";
        String replace = "";
        char delimiter = '#';
        boolean inside = true;
        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
        String expected = "THIS #ST# CASE";
        boolean ans = output.equals(expected);
        assertEquals(ans , true);

    }

    //categories: input: non empty
    //pattern: multiple chars, present in input
    //replace: multiple
    //delimeter: escape char
    //Backslash is the delimiter, search and replace within atomic region. SPEC 5
    @Test
    public void testitf6() {
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
    public void testitf7() {
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
    public void testitf8() {
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
    public void testitf9() {
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
    public void testitf10() {
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


    //categories: input: 3 atomic regions
    //pattern: single chars
    //replace: multiple
    //delimeter: special char

   /* @Test
    public void testitf16() {
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
*/



























    /*//TODO: REMOVE
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
    }*/

    //        boolean inside = false;
//        char delimiter = '#';
//        String replace = "BE";
//        String pattern = "TE";
//        String input = "TEST CASE";
//        StringUtils stringutils = new StringUtils();
//    public void testitf1() {
//    }
//
//        assertEquals(ans , true);
//        boolean ans = output.equals(expected);
//        String expected = "BEST CASE";
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        boolean inside = false;
//        char delimiter = '#';
//        String replace = "BE";
//        String pattern = "TE";
//        String input = "TEST CASE";
//        StringUtils stringutils = new StringUtils();
//    public void testitf1() {
//    }
//
//        assertEquals(ans , true);
//        boolean ans = output.equals(expected);
//        String expected = "BEST CASE";
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        boolean inside = false;
//        char delimiter = '#';
//        String replace = "BE";
//        String pattern = "TE";
//        String input = "TEST CASE";
//        StringUtils stringutils = new StringUtils();
//    }
//
//        assertEquals(ans , true);
//        boolean ans = output.equals(expected);
//        //System.out.print(output);
//        String expected = "THIS #IS TEST# CASE";
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        boolean inside = true;
//        char delimiter = '#';
//        String replace = "BE";
//        String pattern = "XYZ";
//        String input = "THIS #IS TEST# CASE";
//        StringUtils stringutils = new StringUtils();
//    public void testitf3() {
//    @Test
//    //patter does not exist in input
//    //TODO: REMOVE
//    }
//
//        assertEquals(ans , true);
//        boolean ans = output.equals(expected);
//        String expected = "THIS #IS TEST# CASE";
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        boolean inside = true;
//        char delimiter = '#';
//        String replace = "BE";
//        String pattern = "";
//        String input = "THIS #IS TEST# CASE";
//        StringUtils stringutils = new StringUtils();
//    public void testitf2() {
//    @Test
//    //delimeter: special char
//    //replace: multiple
//    //pattern empty
//    //categories: input: non empty with one atomic region
//categories: input: non empty, one atomic region
//pattern: multiple chars,present
//replace: multiple
//delimeter: alphabet
//Multiple replaces within the same region
//Multiple replaces within Multiple region

    //    //TODO: REMOVE
//    //Multiple occurence of pattern in input string. pattern in no regions
//    @Test
//    public void testitf5() {
//        StringUtils stringutils = new StringUtils();
//        String input = "THIS #THE# TEST #THE# CASE";
//        String pattern = "I";
//        String replace = "XYZ";
//        char delimiter = '#';
//        boolean inside = true;
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        String expected = "THIS #THE# TEST #THE# CASE";
//        //System.out.print(output);
//        boolean ans = output.equals(expected);
//        assertEquals(ans , true);
//
//    }
    //categories: input: non empty with multiple atomic region
    //pattern single char, present in one region
    //replace: multiple
    //delimeter: special char
    //Multiple occurence of pattern in input string. pattern in one regions



    /*//TODO:REMOVE
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
    }*/

    //    //TODO: REMOVE



    //    public void testitf1() {
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        String expected = "BEST CASE";
//        boolean ans = output.equals(expected);
//        assertEquals(ans , true);
//
//    }
//    public void testitf1() {
//        StringUtils stringutils = new StringUtils();
//        String input = "TEST CASE";
//        String pattern = "TE";
//        String replace = "BE";
//        char delimiter = '#';
//        boolean inside = false;
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        String expected = "BEST CASE";
//        boolean ans = output.equals(expected);
//        assertEquals(ans , true);
//
//    }
//    public void testitf1() {
//        StringUtils stringutils = new StringUtils();
//        String input = "TEST CASE";
//        String pattern = "TE";
//        String replace = "BE";
//        char delimiter = '#';
//        boolean inside = false;
//        String output = stringutils.replaceString(input, pattern, replace, delimiter, inside);
//        String expected = "BEST CASE";
//        boolean ans = output.equals(expected);
//        assertEquals(ans , true);
//
//    }





    /*EmpBusinessLogic empBusinessLogic =new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    //test to check appraisal
    @Test
    public void testCalculateAppriasal() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double appraisal= empBusinessLogic.calculateAppraisal(employee);
        assertEquals(500, appraisal, 0.0);
    }

    // test to check yearly salary
    @Test
    public void testCalculateYearlySalary() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary= empBusinessLogic.calculateYearlySalary(employee);
        assertEquals(96000, salary, 0.0);

        String input = "Chris James Campbell";
        String pattern = "Campbe";
        String replace = "Dod";
        char delimiter = ' ';
        boolean inside = false;


        */

}


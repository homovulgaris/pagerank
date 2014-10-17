package unitTests;

import org.junit.Assert;
import org.junit.Test;
import parser.ExOutFileReader;
import parser.PagesModel;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jozef on 17.10.2014.
 * this is class for testing sample pages tump
 */
public class PagesTest {

    @Test
    public void testForEqualOutputPages(String inputFile, List<PagesModel> list){

        ExOutFileReader ex = new ExOutFileReader();
        List<String> inputExFile = ex.readFileToStringList(inputFile); //open file which represents the output we want to have
        String[] expectedArray = new String[inputExFile.size()]; // into this string array we fill the sample of expected output
        String[] resultArray = new String[inputExFile.size()]; // into this array we store strings obtained by parsing the enwiki latest page sample.

        int i = 0;
        System.out.println("\n\nTESTING LATEST PAGE FOR EQUAL OUTPUT");
        for(PagesModel p : list){
            String stringFromPages = p.getPageId() + "," + p.getPageNameSpace() + "," + p.getPageTitle() + "," + p.getPageIsRedirect();
            expectedArray[i] = stringFromPages;
            i++;
        }
        int c = 0;
        for(String s : inputExFile){
            resultArray[c] = s;
            c++;
        }

        assertArrayEquals(expectedArray, resultArray); //test these two arrays for similarity
        System.out.println("TEST WAS SUCCESSFUL AND NO ERRORS FOUNDED \n\n");


    }
}

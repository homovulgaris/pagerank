package unitTests;

import parser.ExOutFileReader;
import parser.PageLinksModel;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Jozef on 17.10.2014.
 */
public class PageLinksTest extends  PagesTest {


    public void testForEqualOutputPagelinks(String inputFile, List<PageLinksModel> list){

        ExOutFileReader ex = new ExOutFileReader();
        List<String> inputExFile = ex.readFileToStringList(inputFile);
        String[] expectedArray = new String[inputExFile.size()];
        String[] resultArray = new String[inputExFile.size()];
        int i = 0;
        System.out.println("\n\nTESTING LATEST PAGE FOR EQUAL OUTPUT");
        for(PageLinksModel p : list){
            String stringFromPages = p.getPlFrom() + "," + p.getPlNamespace() + "," + p.getPlTitle();
            expectedArray[i] = stringFromPages;
            i++;
        }
        int c = 0;
        for(String s : inputExFile){
            resultArray[c] = s;
            c++;
        }

        assertArrayEquals(expectedArray, resultArray);
        System.out.println("TEST WAS SUCCESSFUL AND NO ERRORS FOUNDED \n\n");


    }


}

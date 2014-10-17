package parser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozef on 17.10.2014.
 */
public class ExOutFileReader {

    public List<String> readFileToStringList(String inputFile){
        InputStream fis = null;
        BufferedReader br = null;
        String line = "";
        List<String> inputList = new ArrayList<String>();
        boolean pass = false;
        try {
            fis = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UnicodeLittle")));
        try {
            while ((line = br.readLine()) != null) {
                inputList.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

// Done with the file
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = null;
        fis = null;

       // inputList.remove(0);
        return inputList;
    }

}

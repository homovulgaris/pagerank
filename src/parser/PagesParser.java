package parser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jozef on 16.10.2014.
 */
public class PagesParser {

    public List<String> readFile(String input, String ignoreTill) {

        InputStream fis = null;
        BufferedReader br = null;
        String line = "";
        List<String> inputList = new ArrayList<String>();
        boolean pass = false;
        try {
            fis = new FileInputStream(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UnicodeLittle")));
        try {
            while ((line = br.readLine()) != null) {
                while (!pass) {
                    //System.out.println(line);
                    if (line.contains(ignoreTill)) {
                        pass = true;
                    } else {
                        break;
                    }
                }
                if (pass) {
                    inputList.add(line);
                }
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

        inputList.remove(0);
        return inputList; // return list of strings which each of them contain single line - entity
    } // function to read from specified file

    public void printInput(List<String> list) {
        for (String element : list) {
            String s = element;
            System.out.println(s);

        }
    }

    public static void controlForVoidLine(List<String> list) { // control for dummy space in lists
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty()) {
                list.remove(i);
            }
        }
    }

    public List<String> createSingleLineFromEntities(List<String> input) { //creating single line based on regex
        List<String> list = new ArrayList<String>();
        controlForVoidLine(input);
        for (String l : input) {
            Pattern p = Pattern.compile("\\((.*)\\)");
            Matcher m = p.matcher(l);
            String a = new String();


            while (m.find()) {

                // System.out.println(m.group());
                a = m.group();
            }
            StringBuilder sb = new StringBuilder(a);
            // System.out.println("xxxx  " + sb.toString());
            sb.deleteCharAt(0);
            int index = a.length();
            sb.deleteCharAt(index - 2);
            a = sb.toString();
            list.add(a);
        }

        return list; //returning list which contains strings which represents one entity without parenthesis
    }

    public void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    public void printListPages(List<PagesModel> list) {
        System.out.println("Printing parsed pages>>");
        for (PagesModel element : list) {
            System.out.println(element.getPageId() + " " + element.getPageNameSpace() + " " + element.getPageTitle() + " " + element.getPageIsRedirect());
        }
    }

    public List<PagesModel> createPagesModel(List<String> list) { // create data model for pages - each object is one entity build by necessary attributes

        List<PagesModel> listP = new ArrayList<PagesModel>();
        //1,2,3,6
        for (String el : list) {
            String[] split = el.split(",");
            PagesModel p = new PagesModel();
            p.setPageId(Integer.parseInt(split[0]));
            p.setPageNameSpace(Long.parseLong(split[1]));
            p.setPageTitle(split[2]);
            p.setPageIsRedirect(Integer.parseInt(split[5]));
            listP.add(p);
        }

        return listP;
    }
}

package parser;

import java.io.*;
import java.util.List;

/**
 * Created by Jozef on 17.10.2014.
 */
public class FileWriter {

    public boolean writePagesOutputToFile(String path, List<PagesModel> pages){
        File fout = new File(path);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        int linecounter = 0;
        for(PagesModel pm : pages) {
            String line = pm.getPageId() + "," + pm.getPageNameSpace() + "," + pm.getPageTitle().toString() + "," + pm.getPageIsRedirect();
            try {
                bw.write(line);
                linecounter++;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(pages.size() == linecounter){
                }else {
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean writePageLinksOutputToFile(String path, List<PageLinksModel> pagelinks){
        File fout = new File(path);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        int linecounter = 0;
        for(PageLinksModel pm : pagelinks) {
            String line = pm.getPlFrom() + "," + pm.getPlNamespace() + "," + pm.getPlTitle().toString();
            try {
                bw.write(line);
                linecounter++;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(pagelinks.size() == linecounter){
                }else {
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return true;
    }

}

package parser;

import unitTests.PageLinksTest;
import unitTests.PagesTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozef on 16.10.2014.
 */
public class RunParsingAndTesting {

    public static void main(String[] args) {

        //parse pages
        PagesParser pages = new PagesParser();
        List<String> inputList = new ArrayList<String>();
        //first we need to create list of strings from the input file
        inputList = pages.readFile("./data/sample-input-enwiki-latest-page.txt", "40000 ALTER TABLE `page` DISABLE");

        //pages.printInput(inputList);
        List<String> singleLine = pages.createSingleLineFromEntities(inputList);  //next we parse entities into single lines by regex

        // pages.printInput(singleLine);
        List<PagesModel> listPage = pages.createPagesModel(singleLine); // in this step we create data model class for storing the entity as an object with attributes

       // pages.printListPages(listPage);

        //parse pagelinks
        //same procedure here...
        PageLinksParser pagelinks = new PageLinksParser();
        List<String> inputListPagelinks = pagelinks.readFile("./data/sample_input_enwiki_latest_pagelink.txt", "40000 ALTER TABLE `pagelinks` DISABLE");
        List<String> singleLinePagelinks = pagelinks.createSingleLineFromEntities(inputListPagelinks);
        List<PageLinksModel> listPageLinks = pagelinks.createPageLinksModel(singleLinePagelinks);
       // pagelinks.printListPageLinks(listPageLinks);



        //write files

        FileWriter fw = new FileWriter(); //in case we want to write parsed files on disk
        //fw.writePagesOutputToFile("./data/test-pages-output.txt",listPage);
        //fw.writePageLinksOutputToFile("./data/test-pagelinks-output.txt",listPageLinks);

        //ExOutFileReader fr = new ExOutFileReader();
        //List<String> exOutputPagesfr = fr.readFileToStringList("./data/sample-output-enwiki-latest-page.txt");

        //testing for expected output
        PagesTest pageT = new PagesTest(); // create test class
        pageT.testForEqualOutputPages("./data/sample-output-enwiki-latest-page.txt", listPage); //test pages
        PageLinksTest pageLinkT = new PageLinksTest();
        pageLinkT.testForEqualOutputPagelinks("./data/sample-output-latest-pagelinks.txt",listPageLinks); //test pagelinks

    }


}
package parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozef on 16.10.2014.
 */
public class Main {

    public static void main(String[] args) {

        //parse pages
        PagesParser pages = new PagesParser();
        List<String> inputList = new ArrayList<String>();
        inputList = pages.readFile("./data/sample-input-enwiki-latest-page.txt", "40000 ALTER TABLE `page` DISABLE");

        //pages.printInput(inputList);
        List<String> singleLine = pages.createSingleLineFromEntities(inputList);
        // pages.printInput(singleLine);
        List<PagesModel> listPage = pages.createPagesModel(singleLine);
        pages.printListPages(listPage);

        //parse pagelinks
        PagelinksParser pagelinks = new PagelinksParser();
        List<String> inputListPagelinks = pagelinks.readFile("./data/sample_input_enwiki_latest_pagelink.txt", "40000 ALTER TABLE `pagelinks` DISABLE");
        List<String> singleLinePagelinks = pagelinks.createSingleLineFromEntities(inputListPagelinks);
        List<PagelinksModel> listPageLinks = pagelinks.createPageLinksModel(singleLinePagelinks);
        pagelinks.printListPageLinks(listPageLinks);
    }


}
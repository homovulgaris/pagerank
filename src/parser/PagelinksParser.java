package parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozef on 16.10.2014.
 */
public class PageLinksParser extends PagesParser {

    public List<PageLinksModel> createPageLinksModel(List<String> list) {

        List<PageLinksModel> listP = new ArrayList<PageLinksModel>();
        //1,2,3,6
        for (String el : list) {
            String[] split = el.split(",");
            PageLinksModel p = new PageLinksModel();
            p.setPlFrom(Integer.parseInt(split[0]));
            p.setPlNamespace(Long.parseLong(split[1]));
            p.setPlTitle(split[2]);
            listP.add(p);
        }

        return listP;
    }

    public void printListPageLinks(List<PageLinksModel> list) {
        System.out.println("Printing parsed pagelinks>>");
        for (PageLinksModel element : list) {
            System.out.println(element.getPlFrom() + "," + element.getPlNamespace() + "," + element.getPlTitle());
        }
    }

}

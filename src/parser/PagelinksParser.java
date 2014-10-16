package parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jozef on 16.10.2014.
 */
public class PagelinksParser extends PagesParser {

    public List<PagelinksModel> createPageLinksModel(List<String> list) {

        List<PagelinksModel> listP = new ArrayList<PagelinksModel>();
        //1,2,3,6
        for (String el : list) {
            String[] split = el.split(",");
            PagelinksModel p = new PagelinksModel();
            p.setPlFrom(Integer.parseInt(split[0]));
            p.setPlNamespace(Long.parseLong(split[1]));
            p.setPlTitle(split[2]);
            listP.add(p);
        }

        return listP;
    }

    public void printListPageLinks(List<PagelinksModel> list) {
        System.out.println("Printing parsed pagelinks>>");
        for (PagelinksModel element : list) {
            System.out.println(element.getPlFrom() + "," + element.getPlNamespace() + "," + element.getPlTitle());
        }
    }

}

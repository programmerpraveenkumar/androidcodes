package addresspager.com.explistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pravaeen kumar new on 07-07-15.
 */
public class createData {
    public static HashMap getData() {
        HashMap expandableListDetail = new HashMap();

        List technology = new ArrayList();
        technology.add("Beats sued for noise-cancelling tech");
        technology.add("Wikipedia blocks US Congress edits");
        technology.add("Google quizzed over deleted links");
        technology.add("Nasa seeks aid with Earth-Mars links");
        technology.add("The Good, the Bad and the Ugly");

        List entertainment = new ArrayList();
        entertainment.add("Goldfinch novel set for big screen");
        entertainment.add("Anderson stellar in Streetcar");
        entertainment.add("Ronstadt receives White House honour");
        entertainment.add("Toronto to open with The Judge");
        entertainment.add("British dancer return from Russia");

        List science = new ArrayList();
        science.add("Eggshell may act like sunblock");
        science.add("Brain hub predicts negative events");
        science.add("California hit by raging wildfires");
        science.add("Rosetta's comet seen in close-up");
        science.add("Secret of sandstone shapes revealed");

        expandableListDetail.put("TECHNOLOGY NEWS", technology);
        expandableListDetail.put("ENTERTAINMENT NEWS", entertainment);
        expandableListDetail.put("SCIENCE & ENVIRONMENT NEWS", science);
        return expandableListDetail;
    }
}

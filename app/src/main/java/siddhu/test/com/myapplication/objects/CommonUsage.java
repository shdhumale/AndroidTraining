package siddhu.test.com.myapplication.objects;

import java.util.List;

/**
 * Created by admin on 8/5/2016.
 */

public class CommonUsage {

    private static List<Article>  allNewArticle;

    public static List<Article> getAllNewArticle() {
        return allNewArticle;
    }

    public static void setAllNewArticle(List<Article> allNewArticle) {
        CommonUsage.allNewArticle = allNewArticle;
    }
}

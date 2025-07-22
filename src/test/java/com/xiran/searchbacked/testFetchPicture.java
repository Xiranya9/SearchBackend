package com.xiran.searchbacked;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class testFetchPicture {

    @Test
    public void GetPicture() throws IOException{

        int current = 1;
        String url = "https://cn.bing.com/images/search?q=%e5%9b%be%e7%89%87%e5%b0%8f%e9%bb%91%e6%89%8b&form=HDRSC2&first=" + current;
        Document doc = Jsoup.connect(url).get();
//        Elements imgs = doc.select("img");
        System.out.println(doc);
    }
}

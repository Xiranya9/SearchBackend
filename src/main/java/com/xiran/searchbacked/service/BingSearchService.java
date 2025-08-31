package com.xiran.searchbacked.service;

import com.xiran.searchbacked.entity.SearchHistory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BingSearchService {
    private static final Logger log = LoggerFactory.getLogger(BingSearchService.class);
//    @Autowired
//    private SearchHistoryRepository searchHistoryRepository;

    public List<String> searchBing(String keyword) {
        List<String> results = new ArrayList<>();
        String url = "https://cn.bing.com/search?q=" + keyword;

        // 设置请求头
        Document document = null;
        try {
             document = Jsoup.connect(url)
                    .get();

            // 打印实际获取的HTML内容
            log.info("实际获取的HTML内容: {}", document.text());

            Elements elements = document.select("li.b_algo");
            for (Element element : elements) {
                String title = element.select("h2").text();
                String link = element.select("h2 a").attr("href");
                String description = element.select("div.b_caption p").text();

                results.add("标题：" + title + "\n链接：" + link + "\n描述：" + description + "\n");
            }

            // 记录搜索历史
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setKeyword(keyword);
            searchHistory.setSearchTime(LocalDateTime.now());
//            searchHistoryRepository.save(searchHistory);
            log.info(searchHistory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
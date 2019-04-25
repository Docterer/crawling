package com.movie.crawling.controller;

import com.movie.crawling.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlerController {

    @Autowired
    CrawlerService crawlerService;

    @RequestMapping("/go/{NUM}")
    public String crawler(@PathVariable(value = "NUM") int NUM) {
        crawlerService = new CrawlerService();
        for (int i = 0; i < NUM; i++) {
            String url = "https://prod-api.ishuhui.com/comics/detail?id=";
            url = url + String.valueOf(6775 + i);
            crawlerService.downLoadImage(crawlerService, url);
        }
        return "共抓取 "+String.valueOf(NUM) +" 话";
    }

}

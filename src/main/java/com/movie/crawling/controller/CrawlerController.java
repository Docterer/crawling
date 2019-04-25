package com.movie.crawling.controller;

import com.movie.crawling.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlerController {

    @Autowired
    CrawlerService crawlerService;

    @RequestMapping("/go")
    public String crawler(){
        crawlerService = new CrawlerService();
        String url = "https://prod-api.ishuhui.com/comics/detail?id=6775";
        crawlerService.downLoadImage(crawlerService,url);
        return "成功啦";
    }
}

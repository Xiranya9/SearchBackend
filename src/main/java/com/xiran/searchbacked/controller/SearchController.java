package com.xiran.searchbacked.controller;

import com.xiran.searchbacked.service.BingSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    @Autowired
    private BingSearchService bingSearchService;

    @PostMapping("/search")
    @CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
    public List<String> search(@RequestBody String keyword) {
        return bingSearchService.searchBing(keyword);
    }
}




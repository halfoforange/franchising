package com.s0rInb.controller;

import com.s0rInb.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/admin/")
public class AdminController extends BaseController {


    @GetMapping(value = "news/{id}")
    public News getNews(@PathVariable Long id) {
        return null;
    }

    @PostMapping(value = {"news", "news/{id}"})
    public News saveNews(@RequestBody News news, @PathVariable Long id) {
        if (id!=null) {
            return null;
        } else {
            return null;
        }
    }
    @DeleteMapping(value = "news")
    public News deleteNews(@RequestBody News news) {
            return null;
    }
    @GetMapping(value = "news/page/{pageNum}")
    public Page<News> getNewsPage(@PathVariable Long pageNum) {
        return null;
    }


}

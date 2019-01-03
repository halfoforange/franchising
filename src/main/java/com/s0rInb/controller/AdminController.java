package com.s0rInb.controller;

import com.s0rInb.entity.News;
import com.s0rInb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/admin/")
public class AdminController extends BaseController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "news/{id}")
    public News getNews(@PathVariable Long id) {
        return null;
    }

    @PostMapping(value = {"news", "news/{id}"})
    public News saveNews(@RequestBody News news, @PathVariable Optional<Long> id) {
        if (id.isPresent()) {
            return null;
        } else {
            return adminService.addNews(news);
        }
    }

    @DeleteMapping(value = "news")
    public News deleteNews(@RequestBody News news) {
        return null;
    }

    @GetMapping(value = "page/news/{pageNum}")
    public Page<News> getNewsPage(@PathVariable int pageNum) {
        Pageable pageable = PageRequest.of(pageNum-1, 20,new Sort(Sort.Direction.DESC, "id"));
        return adminService.getNewsPage(pageable);
    }
}

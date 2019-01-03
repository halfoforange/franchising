package com.s0rInb.service;

import com.s0rInb.entity.News;
import com.s0rInb.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    NewsRepository newsRepository;

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public Page<News> getNewsPage(Pageable pageable){
        return newsRepository.findAll(pageable);
    }
}

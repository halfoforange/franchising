package com.s0rInb.controller;

import com.s0rInb.entity.dictionary.Dictionary;
import com.s0rInb.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(value = "{name}/{id}")
    public Dictionary getDictionary(@PathVariable String name, @PathVariable Long id) {
        return dictionaryService.findById(name, id);
    }

    @GetMapping(value = "{name}")
    public List<Dictionary> getDictionaryList(@PathVariable String name) {
        return dictionaryService.search(name, "");
    }
}

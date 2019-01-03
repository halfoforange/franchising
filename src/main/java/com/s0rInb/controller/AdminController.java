package com.s0rInb.controller;

import com.s0rInb.entity.Instruction;
import com.s0rInb.entity.News;
import com.s0rInb.entity.dictionary.Category;
import com.s0rInb.entity.dictionary.Dictionary;
import com.s0rInb.service.AdminService;
import com.s0rInb.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/admin/")
public class AdminController extends BaseController {

    @Autowired
    AdminService adminService;

    @Autowired
    DictionaryService dictionaryService;

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
        Pageable pageable = PageRequest.of(pageNum - 1, 20, new Sort(Sort.Direction.DESC, "id"));
        return adminService.getNewsPage(pageable);
    }

    @GetMapping(value = "instruction/{id}")
    public Instruction getInstruction(@PathVariable Long id) {
        return null;
    }
    @GetMapping(value = "page/instruction")
    public Map<Category, List<Instruction>> getInstructionHashMap() {
        return adminService.getInstructions();
    }
    @PostMapping(value = {"instruction", "instruction/{id}"})
    public Instruction saveInstruction(@RequestBody Instruction instruction, @PathVariable Optional<Long> id) {
        if (id.isPresent()) {
            return null;
        } else {
            return adminService.addInstruction(instruction);
        }
    }


    @PostMapping(value = "dictionary/{entityName}")
    public void addNewDictionary(@RequestBody Dictionary dictionary, @PathVariable String entityName) {
        adminService.addNew(entityName, dictionary);
    }
}

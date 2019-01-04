package com.s0rInb.controller;

import com.s0rInb.entity.dictionary.Dictionary;
import com.s0rInb.service.DictionaryService;
import com.s0rInb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private FileService fileService;
    @GetMapping(value = "file")
    public void getFile(@RequestParam("filename") String filename, HttpServletResponse response) {
        try {
            Resource resource = fileService.loadFile(filename);
            response.addHeader("Content-Disposition", "attachment; filename="+resource.getFilename());
            Files.copy(resource.getFile().toPath(), response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception ignored) {

        }
    }
    @GetMapping(value = "{name}/{id}")
    public Dictionary getDictionary(@PathVariable String name, @PathVariable Long id) {
        return dictionaryService.findById(name, id);
    }

    @GetMapping(value = "{name}")
    public List<Dictionary> getDictionaryList(@PathVariable String name) {
        return dictionaryService.search(name, "");
    }
}

package com.s0rInb.service;

import com.s0rInb.entity.File;
import com.s0rInb.entity.Instruction;
import com.s0rInb.entity.News;
import com.s0rInb.entity.dictionary.Category;
import com.s0rInb.entity.dictionary.Dictionary;
import com.s0rInb.repository.FileRepository;
import com.s0rInb.repository.InstructionRepository;
import com.s0rInb.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    NewsRepository newsRepository;
    @Autowired
    InstructionRepository instructionRepository;

    @Autowired
    FileRepository fileRepository;
    @PersistenceContext
    private EntityManager em;

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public Page<News> getNewsPage(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    public Instruction addInstruction(Instruction instruction) {
        List<File> files = new ArrayList<>();
        instruction = instructionRepository.saveAndFlush(instruction);
        for (File file : instruction.getFiles()) {
            file.setInstruction(instruction);
            files.add(fileRepository.saveAndFlush(file));
        }
        instruction.setFiles(files);
        return instruction;
    }

    public Map<Category, List<Instruction>> getInstructions() {
        return instructionRepository.findAll().stream().collect(
                Collectors.groupingBy(Instruction::getCategory)
        );
    }


    @Transactional
    public void addNew(String dictionaryEntity, Dictionary dictionary) {
        Query query = em.createNativeQuery("INSERT INTO " + dictionaryEntity + " (name) values ( \'" + dictionary.getName() + "\')");
        query.executeUpdate();
    }
}

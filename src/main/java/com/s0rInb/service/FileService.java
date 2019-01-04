package com.s0rInb.service;

import com.s0rInb.entity.File;
import com.s0rInb.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;
    private final static Path rootLocation = Paths.get("upload-dir");

    static {
        init();
    }

    public File store(MultipartFile multipartFile, File file) {
        try {
            String dir = LocalDateTime.now().toString().replaceAll(":","");
            Path directory = Files.createDirectory(Paths.get(rootLocation.toString(), dir));
            Files.copy(multipartFile.getInputStream(), directory.resolve(multipartFile.getOriginalFilename()));
            file.setUrl(dir+"/"+multipartFile.getOriginalFilename());
            return fileRepository.save(file);
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;

            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    private static void init() {
        try {
            java.io.File file = rootLocation.toFile();
            if (!file.exists()) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}

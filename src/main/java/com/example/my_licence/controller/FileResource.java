

package com.example.my_licence.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileResource {

//    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";
public static final String DIRECTORY = "D:/NOTES/";


    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles) {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String fileName = file.getOriginalFilename();
            try {
                Path fileStorage = Path.of(DIRECTORY).resolve(fileName).toAbsolutePath().normalize();
                Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
                filenames.add(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
        Path filePath = Path.of(DIRECTORY).resolve(filename).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            // Handle file not found exception
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders)
                .body(resource);
    }
}


package com.example.demo.controller;


import org.springframework.core.io.ClassPathResource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {
    public static String UPLOAD_DIRECTORY = "C:\\Users\\Omistaja\\springBootProjects\\demo\\src\\main\\resources\\uploads";
    public String fileName;
    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());


        fileName = file.getOriginalFilename();
        System.out.println(fileName);
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return fileName;
    }



        @RequestMapping(value = "/showImage", method = RequestMethod.GET,
                produces = MediaType.IMAGE_JPEG_VALUE)
        public ResponseEntity<byte[]> getImage(String fileName) throws IOException {

            var imgFile = new ClassPathResource("uploads/" + fileName);
            byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        }
    }




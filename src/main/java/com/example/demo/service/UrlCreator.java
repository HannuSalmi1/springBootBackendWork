package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class UrlCreator {

    private User user;

/*not inserting String name to this. because i used getter in adding the user
    name to the end of url. */
    public String creatingFolder(User user) throws IOException {

        Path path = Paths.get(
                "C:\\Users\\Omistaja\\springBootProjects\\demo\\src\\main\\resources\\uploads\\"
                        + user.getName());

        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "added a folder to user at ....";

    }

    public UrlCreator() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
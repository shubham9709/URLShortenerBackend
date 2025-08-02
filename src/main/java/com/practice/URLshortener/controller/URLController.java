package com.practice.URLshortener.controller;

import com.practice.URLshortener.URLService.URLService;
import com.practice.URLshortener.beans.URLBean;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@CrossOrigin(origins = "*")
@RestController
public class URLController {

    @Autowired
    private URLService urlService;
    @PostMapping("/submitUrl")
    public String submitURL(@RequestBody URLBean urlBean){
        int generatedId = urlService.saveURL(urlBean);
        return "http://localhost:8080/shortenedUrl/" + generatedId;

    }

    @GetMapping("/shortenedUrl/{id}")
    public ResponseEntity<Void> shortenedURL(@PathVariable int id){
        String shortenedURl=urlService.getShortenedURL(id);
        if(shortenedURl!=null){
            if(!shortenedURl.startsWith("http://") && !shortenedURl.startsWith("https://")){
                shortenedURl="http://"+shortenedURl;
            }
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(shortenedURl)).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

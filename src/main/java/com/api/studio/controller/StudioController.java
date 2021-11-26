package com.api.studio.controller;

import com.api.studio.entity.Studio;
import com.api.studio.service.StudioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/api/studio")
public class StudioController {

    StudioService service;

    @GetMapping("/")
    public ResponseEntity<List<Studio>> getAll() {
        return new ResponseEntity<>(service.getAll(), OK);
    }
}

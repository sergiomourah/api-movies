package com.api.studio.service;

import com.api.studio.entity.Studio;
import com.api.studio.repository.StudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudioService {

    StudioRepository studioRepository;

    public List<Studio> getAll(){
        return this.studioRepository.findAll();
    }
}

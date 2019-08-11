package com.example.pruebatalent.service;

import com.example.pruebatalent.dao.ComicColeecionRepository;
import com.example.pruebatalent.modelo.CollecionComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollecionComicServiceImpl implements CollecionComicService{

    @Autowired
    protected ComicColeecionRepository coleecionRepository;

    @Override
    public CollecionComic save(CollecionComic collecionComic) {
        return this.coleecionRepository.save(collecionComic);
    }

    @Override
    public List<CollecionComic> findAll() {
        return this.coleecionRepository.findAll();
    }

    @Override
    public void deleteComic(int comic_id) {
        this.coleecionRepository.deleteById((long) comic_id);
    }

    @Override
    public void findById(int comic_id) {
        this.coleecionRepository.findById((long) comic_id);
    }
}

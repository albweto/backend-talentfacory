package com.example.pruebatalent.service;

import com.example.pruebatalent.modelo.CollecionComic;

import java.util.List;

public interface CollecionComicService {
    CollecionComic save(CollecionComic collecionComic);

    List<CollecionComic> findAll();

    void deleteComic(int comic_id);

    void findById(int comic_id);
}

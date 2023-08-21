package com.guitars.guitars.guitar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    GuitarRepository guitarRepository;

    //addGuitar
    public void addGuitar(Guitar guitar) {
        guitarRepository.createGuitar(jdbcTemplate, guitar);
    }
    public List<Guitar> searchGuitars(GuitarSpec guitarSpec) {
        return guitarRepository.readGuitarsWithSpec(jdbcTemplate, guitarSpec);
    }
}

package com.guitars.guitars.guitar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {
    @Autowired
    GuitarRepository guitarRepository;

    //addGuitar
    public void addGuitar(Guitar guitar) {
        guitarRepository.createGuitar(guitar);
    }
    public List<Guitar> searchGuitars(GuitarSpec guitarSpec) {
        return guitarRepository.readGuitarsWithSpec(guitarSpec);
    }
    public List<Guitar> getAllGuitars() {
        return guitarRepository.readAll();
    }
    public int updateGuitar(GuitarSpec guitarSpec, int id) {
        return guitarRepository.updateGuitar(guitarSpec, id);
    }
    public int deleteGuitar(int id) {
        return guitarRepository.deleteGuitar(id);
    }
}

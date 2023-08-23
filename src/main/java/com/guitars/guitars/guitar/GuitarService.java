package com.guitars.guitars.guitar;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void updateGuitar(GuitarSpec guitarSpec, int id) {
        guitarRepository.updateGuitar(guitarSpec, id);
    }
    public void deleteGuitar(int id) {
        guitarRepository.deleteGuitar(id);
    }
}

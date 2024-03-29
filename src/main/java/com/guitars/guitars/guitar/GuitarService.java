package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {
    @Autowired
    GuitarRepository guitarRepository;

    public List<Instrument> searchGuitars(GuitarSpec guitarSpec) {
        return guitarRepository.readGuitarsWithSpec(guitarSpec);
    }
    public List<Instrument> getAllGuitars() {
        return guitarRepository.readAll();
    }
    public void updateGuitar(GuitarSpec guitarSpec, int id) {
        guitarRepository.updateGuitar(guitarSpec, id);
    }
    public void deleteGuitar(int id) {
        guitarRepository.deleteGuitar(id);
    }
}

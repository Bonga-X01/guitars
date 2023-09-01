package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.InstrumentRepository;

import java.util.List;

public interface GuitarRepository {

    public void createGuitar(Guitar guitar);
    public List<Guitar> readGuitarsWithSpec(GuitarSpec guitarSpec);
    public List<Guitar> readAll();
    public void updateGuitar(GuitarSpec guitarSpec, int id);
    public void deleteGuitar(int id);
}

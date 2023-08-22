package com.guitars.guitars.guitar;

import java.util.List;

public interface GuitarRepository {

    public void createGuitar(Guitar guitar);
    public List<Guitar> readGuitarsWithSpec(GuitarSpec guitarSpec);
    public List<Guitar> readAll();
    public int updateGuitar(GuitarSpec guitarSpec, int id);
    public int deleteGuitar(int id);
}

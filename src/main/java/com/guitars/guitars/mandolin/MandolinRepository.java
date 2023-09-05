package com.guitars.guitars.mandolin;

import com.guitars.guitars.guitar.Guitar;

import java.util.List;

public interface MandolinRepository {
    public void createMandolin(Mandolin mandolin);
    public List<Mandolin> readMandolinWithSpec(MandolinSpec spec);
}

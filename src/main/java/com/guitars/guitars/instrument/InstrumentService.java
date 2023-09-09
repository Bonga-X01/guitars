package com.guitars.guitars.instrument;

import com.guitars.guitars.guitar.Guitar;
import com.guitars.guitars.guitar.GuitarRepository;
import com.guitars.guitars.guitar.GuitarSpec;
import com.guitars.guitars.mandolin.Mandolin;
import com.guitars.guitars.mandolin.MandolinRepository;
import com.guitars.guitars.mandolin.MandolinSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentService {
    @Autowired
    GuitarRepository guitarRepository;
    @Autowired
    MandolinRepository mandolinRepository;
    public void addInstrument(Instrument instrument) {
        if(instrument instanceof Guitar guitar) {
            guitarRepository.createGuitar(guitar);
        } else if (instrument instanceof Mandolin mandolin) {
            mandolinRepository.createMandolin(mandolin);
        }
    }
    public List<Instrument> readMatching(InstrumentSpec instrumentSpec) {
        List<Instrument> list = new ArrayList<>();
        if(instrumentSpec instanceof GuitarSpec spec) {
            list = new ArrayList<>(guitarRepository.readGuitarsWithSpec(spec));
        } else if (instrumentSpec instanceof MandolinSpec spec) {
            list = new ArrayList<>(mandolinRepository.readMandolinWithSpec(spec));
        }
        return list;
    }
    public List<Instrument> readAll() {
        List<Instrument> list = new ArrayList<>();
            list.addAll(mandolinRepository.readAll());
            list.addAll(guitarRepository.readAll());
        return list;
    }
    public List<Instrument> readAll(String instrument) {
        List<Instrument> list = new ArrayList<>();
        if(instrument.equals("Mandolin")) {
            list.addAll(mandolinRepository.readAll());
        } else if (instrument.equals("Guitar")) {
            list.addAll(guitarRepository.readAll());
        }
        return list;
    }
}

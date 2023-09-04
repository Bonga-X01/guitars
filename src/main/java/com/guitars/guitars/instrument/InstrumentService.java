package com.guitars.guitars.instrument;

import com.guitars.guitars.guitar.Guitar;
import com.guitars.guitars.guitar.GuitarRepository;
import com.guitars.guitars.mandolin.Mandolin;
import com.guitars.guitars.mandolin.MandolinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

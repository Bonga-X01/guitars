package com.guitars.guitars.instrument;

import com.guitars.guitars.guitar.Guitar;
import com.guitars.guitars.guitar.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {
    @Autowired
    InstrumentRepository instrumentRepository;
    @Autowired
    GuitarRepository guitarRepository;
    public void addInstrument(Instrument instrument) {
        if(instrument instanceof Guitar guitar) {
            guitarRepository.createGuitar(guitar);
        }
    }
}

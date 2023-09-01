package com.guitars.guitars.instrument;

import com.guitars.guitars.guitar.Guitar;
import com.guitars.guitars.guitar.GuitarRepositoryImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstrumentRepositoryImpl implements InstrumentRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(GuitarRepositoryImp.class);
    @Override
    public void createInstrument(Instrument instrument) {
        if(instrument instanceof Guitar guitar) {
            log.info("Inserting guitar");
            jdbcTemplate.update(
                    "INSERT INTO inventory" +
                            "(id, serial_number, price, builder, model, type, back_wood, top_wood, num_strings)" +
                            "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)",
                    guitar.getSerialNumber(),
                    guitar.getPrice(),
                    guitar.getSpec().getBuilder(),
                    guitar.getSpec().getModel(),
                    guitar.getSpec().getType(),
                    guitar.getSpec().getBackWood(),
                    guitar.getSpec().getTopWood(),
                    guitar.getSpec().getNumStrings()

            );
            log.info("Completed insert \n" + guitar);
        }
    }
}

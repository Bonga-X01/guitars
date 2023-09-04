package com.guitars.guitars.mandolin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MandolinRepositoryImp implements MandolinRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(MandolinRepositoryImp.class);
    @Override
    public void createMandolin(Mandolin mandolin) {
        log.info("Inserting mandolin");
        jdbcTemplate.update(
                "INSERT INTO inventory" +
                        "(id, serial_number, price, builder, model, type, back_wood, top_wood, style, instrument)" +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                mandolin.getSerialNumber(),
                mandolin.getPrice(),
                mandolin.getSpec().getBuilder(),
                mandolin.getSpec().getModel(),
                mandolin.getSpec().getType(),
                mandolin.getSpec().getBackWood(),
                mandolin.getSpec().getTopWood(),
                mandolin.getSpec().getStyle(),
                "Mandolin"
        );
        log.info("Completed insert \n" + mandolin);
    }
}

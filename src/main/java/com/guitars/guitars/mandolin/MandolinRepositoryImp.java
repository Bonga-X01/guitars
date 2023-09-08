package com.guitars.guitars.mandolin;

import com.guitars.guitars.guitar.Guitar;
import com.guitars.guitars.guitar.GuitarSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<Mandolin> readMandolinWithSpec(MandolinSpec spec) {
        List<Mandolin> matchingMandolins = new ArrayList<>();
        log.info("querying for matching mandolin");
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE (builder = ? OR model = ? OR type = ? OR back_wood = ? OR top_wood = ? OR style = ?) AND (instrument = 'Mandolin')",
                new Object[] { spec.getBuilder(), spec.getModel(), spec.getType(), spec.getBackWood(), spec.getTopWood(), spec.getStyle() },
                (rs, rowNum) -> new Mandolin(rs.getInt("id"),
                        rs.getString("serial_number"),
                        rs.getString("price"),
                        new MandolinSpec(rs.getString("builder"),
                                rs.getString("model"),
                                rs.getString("type"),
                                rs.getString("back_wood"),
                                rs.getString("top_wood"),
                                rs.getString("style")))
        ).forEach(mandolin -> {
            log.info("found: "+ mandolin);
            matchingMandolins.add(mandolin);
        });
        return matchingMandolins;
    }
}

package com.guitars.guitars.guitar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuitarRepositoryImp implements GuitarRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(GuitarRepositoryImp.class);
    @Override
    public void createGuitar(Guitar guitar) {
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

    @Override
    public List<Guitar> readGuitarsWithSpec(GuitarSpec guitarSpec) {
        List<Guitar> matchingGuitars = new ArrayList<>();
        log.info("Querying for matching guitars");
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE builder = ? OR model = ? OR type = ? OR back_wood = ? OR top_wood = ? OR num_strings = ?",
                new Object[] { guitarSpec.getBuilder(), guitarSpec.getModel(), guitarSpec.getType(), guitarSpec.getBackWood(), guitarSpec.getTopWood(), guitarSpec.getNumStrings() },
                (rs, rowNum) -> new Guitar(rs.getInt("id"),
                        rs.getString("serial_number"),
                        rs.getString("price"),
                        new GuitarSpec(rs.getString("builder"),
                                rs.getString("model"),
                                rs.getString("type"),
                                rs.getString("back_wood"),
                                rs.getString("top_wood"),
                                rs.getInt("num_strings")))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);
        });
        return matchingGuitars;
    }
    @Override
    public List<Guitar> readAll() {

        List<Guitar> matchingGuitars = new ArrayList<>();

        log.info("Querying for all guitars");
        jdbcTemplate.query(
                "SELECT * FROM inventory",
                (rs, rowNum) -> new Guitar(rs.getInt("id"),
                        rs.getString("serial_number"),
                        rs.getString("price"),
                        new GuitarSpec(rs.getString("builder"),
                                rs.getString("model"),
                                rs.getString("type"),
                                rs.getString("back_wood"),
                                rs.getString("top_wood"),
                                rs.getInt("num_strings")))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);
        });
        return matchingGuitars;
    }
    @Override
    public void updateGuitar(GuitarSpec guitarSpec, int id) {
        jdbcTemplate.update(
                "UPDATE inventory SET builder = ?, model = ?, type = ?, back_wood = ?, top_wood = ?, num_strings = ? WHERE id = ?",
                guitarSpec.getBuilder(), guitarSpec.getModel(), guitarSpec.getType(), guitarSpec.getBackWood(), guitarSpec.getTopWood(), guitarSpec.getNumStrings(), id);
    }
    @Override
    public void deleteGuitar(int id) {
        jdbcTemplate.update("DELETE FROM inventory WHERE id=?", id);
    }
}

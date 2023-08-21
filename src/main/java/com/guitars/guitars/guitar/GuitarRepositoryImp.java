package com.guitars.guitars.guitar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class GuitarRepositoryImp implements GuitarRepository{
    private static final Logger log = LoggerFactory.getLogger(GuitarRepositoryImp.class);
    @Override
    public void createGuitar(JdbcTemplate jdbcTemplate, Guitar guitar) {
        log.info("Inserting guitar");
        jdbcTemplate.update(
                "INSERT INTO inventory" +
                        "(id, serial_number, price, builder, model, type, back_wood, top_wood)" +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?)",
                guitar.getSerialNumber(),
                guitar.getPrice(),
                guitar.getBuilder(),
                guitar.getModel(),
                guitar.getType(),
                guitar.getBackWood(),
                guitar.getTopWood()
                //todo: use args = {guitar.getThings}
        );
        log.info("Completed insert \n" + guitar);
    }

    @Override
    public List<Guitar> readGuitarsWithSpec(JdbcTemplate jdbcTemplate, GuitarSpec guitarSpec) {

        Set<Guitar> matchingGuitars = new HashSet<>();

        log.info("Querying for matching guitars");
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE builder = ?", new Object[] { guitarSpec.getBuilder() }
                ,
                (rs, rowNum) -> new Guitar(rs.getString("serial_number"),
                        rs.getString("price"),
                        rs.getString("builder"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("back_wood"),
                        rs.getString("top_wood"))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);

        });
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE model = ?", new Object[] { guitarSpec.getModel() }
                ,
                (rs, rowNum) -> new Guitar(rs.getString("serial_number"),
                        rs.getString("price"),
                        rs.getString("builder"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("back_wood"),
                        rs.getString("top_wood"))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);

        });
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE type = ?", new Object[] { guitarSpec.getType() }
                ,
                (rs, rowNum) -> new Guitar(rs.getString("serial_number"),
                        rs.getString("price"),
                        rs.getString("builder"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("back_wood"),
                        rs.getString("top_wood"))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);

        });
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE back_wood = ?", new Object[] { guitarSpec.getBackWood() }
                ,
                (rs, rowNum) -> new Guitar(rs.getString("serial_number"),
                        rs.getString("price"),
                        rs.getString("builder"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("back_wood"),
                        rs.getString("top_wood"))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);

        });
        jdbcTemplate.query(
                "SELECT * FROM inventory WHERE top_Wood = ?", new Object[] { guitarSpec.getTopWood() },
                (rs, rowNum) -> new Guitar(rs.getInt("id"),
                        rs.getString("serial_number"),
                        rs.getString("price"),
                        rs.getString("builder"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("back_wood"),
                        rs.getString("top_wood"))
        ).forEach(guitar ->{
            log.info("found: "+ guitar);
            matchingGuitars.add(guitar);

        });
        return new ArrayList<>(matchingGuitars);
    }
}

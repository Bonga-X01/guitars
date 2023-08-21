package com.guitars.guitars.guitar;

import com.guitars.guitars.guitar.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GuitarRepository {

    public void createGuitar(JdbcTemplate jdbcTemplate, Guitar guitar);
    public List<Guitar> readGuitarsWithSpec(JdbcTemplate jdbcTemplate, GuitarSpec guitarSpec);


}

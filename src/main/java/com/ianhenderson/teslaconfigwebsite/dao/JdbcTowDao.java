package com.ianhenderson.teslaconfigwebsite.dao;


import com.ianhenderson.teslaconfigwebsite.model.Customer;
import com.ianhenderson.teslaconfigwebsite.model.Tow;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcTowDao implements TowDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcTowDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Tow getTow(int towId) {
        Tow tow = null;
        String sql = "SELECT * " +
                "FROM tow_hitch " +
                "WHERE tow_hitch_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, towId);
        if (results.next()) {
            tow = mapRowToTow(results);
        }
        return tow;
    }

    @Override
    public Tow getTowName(String towName){
        Tow tow = null;
        String sql = "SELECT * " +
                "FROM tow_hitch " +
                "WHERE tow_confirmed = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, towName);
        if(results.next()){
            tow = mapRowToTow(results);
        }
        return tow;
    }

    @Override
    public List<Tow> getTowOptions() {
        List <Tow> tows = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM tow_hitch ORDER BY tow_hitch_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            tows.add(mapRowToTow(results));
        }
        return tows;

    }

    private Tow mapRowToTow(SqlRowSet rowSet){
        Tow tow = new Tow();
        tow.setTowId(rowSet.getInt("tow_hitch_id"));
        tow.setTowConfirmed(rowSet.getString("tow_confirmed"));
        tow.setTowPrice(rowSet.getDouble("tow_hitch_price"));
        return tow;
    }
}

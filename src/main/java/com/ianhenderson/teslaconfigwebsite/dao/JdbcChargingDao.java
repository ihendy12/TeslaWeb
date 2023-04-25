package com.ianhenderson.teslaconfigwebsite.dao;
import com.ianhenderson.teslaconfigwebsite.model.Charging;
import com.ianhenderson.teslaconfigwebsite.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcChargingDao implements ChargingDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcChargingDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Charging getCharging(int chargingId) {
        Charging charging = null;
        String sql = "SELECT * " +
                "FROM charging " +
                "WHERE charging_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, chargingId);
        if (results.next()) {
            charging = mapRowToCharging(results);
        }
        return charging;



    }

    @Override
    public Charging getChargingName(String chargingName){
        Charging charging = null;
        String sql = "SELECT * " +
                "FROM charging " +
                "WHERE charging_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, chargingName);
        if(results.next()){
            charging = mapRowToCharging(results);
        }
        return charging;
    }

    @Override
    public List<Charging> getAllCharging() {
        List <Charging> chargings = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM charging ORDER BY charging_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            chargings.add(mapRowToCharging(results));
        }
        return chargings;
    }



    private Charging mapRowToCharging(SqlRowSet rowSet){
        Charging charging = new Charging();
        charging.setChargingId(rowSet.getInt("charging_id"));
        charging.setChargingName(rowSet.getString("charging_type"));
        charging.setChargingPrice(rowSet.getDouble("charging_price"));
        return charging;
    }
}

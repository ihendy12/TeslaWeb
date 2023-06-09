package com.ianhenderson.teslaconfigwebsite.dao;



import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcAutopilotDao implements AutopilotDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcAutopilotDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Autopilot getAutopilot(int autopilotId) {
        Autopilot autopilot = null;
        String sql = "SELECT * " +
                "FROM autopilot_level " +
                "WHERE autopilot_level_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, autopilotId);
        if (results.next()) {
            autopilot = mapRowToAutopilot(results);
        }
        return autopilot;



    }

    @Override
    public Autopilot getAutopilotName(String autopilotName){
        Autopilot autopilot = null;
        String sql = "SELECT * " +
                "FROM autopilot_level " +
                "WHERE autopilot_level_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, autopilotName);
        if(results.next()){
            autopilot = mapRowToAutopilot(results);
        }
        return autopilot;
    }

    @Override
    public List<Autopilot> getAllAutopilotOptions() {
        List <Autopilot> autopilots = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM autopilot_level ORDER BY autopilot_level_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            autopilots.add(mapRowToAutopilot(results));
        }
        return autopilots;

    }

    @Override
    public Autopilot createAutopilot(Autopilot newAutopilot) {
        return null;
    }

    private Autopilot mapRowToAutopilot(SqlRowSet rowset){
        Autopilot autopilot = new Autopilot();
        autopilot.setAutopilotId(rowset.getInt("autopilot_level_id"));
        autopilot.setAutopilotName(rowset.getString("autopilot_level_name"));
        autopilot.setAutopilotPrice(rowset.getDouble("autopilot_price"));
        return autopilot;
    }
}
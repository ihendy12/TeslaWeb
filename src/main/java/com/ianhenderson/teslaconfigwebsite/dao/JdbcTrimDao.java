package com.ianhenderson.teslaconfigwebsite.dao;
import com.ianhenderson.teslaconfigwebsite.model.Customer;
import com.ianhenderson.teslaconfigwebsite.model.Trim;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrimDao implements TrimDao {


    private final JdbcTemplate jdbcTemplate;
    public JdbcTrimDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Trim getTrim(int trimId) {
        Trim trim = null;
        String sql = "SELECT * " +
                "FROM trim_level " +
                "WHERE trim_level_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trimId);
        if (results.next()) {
            trim = mapRowToTrim(results);
        }
        return trim;
    }

    @Override
    public Trim getTrimName(String trimName){
        Trim trim = null;
        String sql = "SELECT * " +
                "FROM trim_level " +
                "WHERE trim_level_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trimName);
        if(results.next()){
            trim = mapRowToTrim(results);
        }
        return trim;
    }

    @Override
    public Trim createTrim(Trim newTrim) {
        return null;
    }

    @Override
    public List<Trim> getAllTrims() {
        List <Trim> trims = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM trim_level ORDER BY trim_level_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            trims.add(mapRowToTrim(results));
        }
        return trims;
    }


    private Trim mapRowToTrim(SqlRowSet rowSet){
        Trim trim = new Trim();
        trim.setTrimId(rowSet.getInt("trim_level_id"));
        trim.setTrimName(rowSet.getString("trim_level_name"));
        trim.setTrimPrice(rowSet.getDouble("trim_price"));
        return trim;
    }
}

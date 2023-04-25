package com.ianhenderson.teslaconfigwebsite.dao;
import com.ianhenderson.teslaconfigwebsite.model.Customer;
import com.ianhenderson.teslaconfigwebsite.model.Seat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSeatDao implements SeatDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcSeatDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Seat getSeat(int seatId) {
        Seat seat = null;
        String sql = "SELECT * " +
                "FROM seat_number " +
                "WHERE seat_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, seatId);
        if(results.next()){
            seat = mapRowToSeat(results);
        }
        return seat;
    }

    @Override
    public Seat getSeatName(String seatName){
        Seat seat = null;
        String sql = "SELECT * " +
                "FROM seat_number " +
                "WHERE number_of_seats = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, seatName);
        if(results.next()){
            seat = mapRowToSeat(results);
        }
        return seat;
    }

    @Override
    public List<Seat> getAllSeats() {
        List <Seat> seats = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM seat_number ORDER BY seat_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            seats.add(mapRowToSeat(results));
        }
        return seats;
    }

    private Seat mapRowToSeat(SqlRowSet rowSet){
        Seat seat = new Seat();
        seat.setSeatId(rowSet.getInt("seat_id"));
        seat.setNumOfSeats(rowSet.getString("number_of_seats"));
        seat.setSeatPrice(rowSet.getDouble("seat_price"));
        return seat;
    }
}

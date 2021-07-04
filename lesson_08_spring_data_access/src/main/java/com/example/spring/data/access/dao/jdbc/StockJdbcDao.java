package com.example.spring.data.access.dao.jdbc;

import com.example.spring.data.access.dao.StockDao;
import com.example.spring.data.access.dto.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
@Qualifier("jdbc")
public class StockJdbcDao implements StockDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Stock findById(String id) {
        String sqlquery = "SELECT id, name, price FROM stocks where id=?";

        //return  jdbcTemplate.queryForObject(sqlquery, jdbcTemplate, new Object[] { id });

        //jdbcTemplate.queryForObject(sqlquery, new Object[]{id}, new BeanPropertyRowMapper<>(Stock.class));

        //return jdbcTemplate.queryForObject(sqlquery, new BeanPropertyRowMapper<>(Stock.class), id);

        return jdbcTemplate.queryForObject(sqlquery, new Object[]{id}, new BeanPropertyRowMapper<>(Stock.class));
    }

    @Override
    @Transactional
    public void save(Stock stock) {
        String sqlQuery = "MERGE INTO stocks KEY(id) VALUES(?,?,?)";
        jdbcTemplate.update(sqlQuery, stock.getId(), stock.getName(), stock.getPrice());
    }
}

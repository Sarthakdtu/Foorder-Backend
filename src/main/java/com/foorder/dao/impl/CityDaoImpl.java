package com.foorder.dao.impl;

import com.foorder.dao.CityDao;
import com.foorder.mapper.CityMapper;
import com.foorder.model.City;
import com.foorder.utils.LoggerService;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CityDaoImpl implements CityDao {

    NamedParameterJdbcTemplate template;

    public CityDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    @Override
    public City getCityByName(String name) {
        String query = new StringBuilder("SELECT * FROM CITY WHERE name='%s'").toString();
        query = String.format(query, name);
        return (City) template.query(query, new CityMapper()).get(0);
    }

    @Override
    public void insertCity(City city) {
        final String query = "INSERT INTO CITY(name) " +
                "VALUES(:name)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", city.getName());
        LoggerService.debug(query);
        template.update(query, param, keyHolder);
    }

    @Override
    public void deleteCity(String name) {
        final String query = "DELETE FROM CITY WHERE name=:name";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        template.execute(query, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });
    }

    @Override
    public List<City> getAllCities() {
        return template.query("SELECT * FROM CITY ", new CityMapper());
    }
}

package com.foorder.dao.postgres.impl;

import com.foorder.constants.Table;
import com.foorder.dao.postgres.UserProfileDao;
import com.foorder.mapper.UserProfileMapper;
import com.foorder.model.UserProfile;
import com.foorder.utils.LoggerService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

    NamedParameterJdbcTemplate template;

    public UserProfileDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        String query = "SELECT * FROM " + Table.USER_PROFILE.name;
        return (List<UserProfile>) template.query(query, new UserProfileMapper());
    }

    @Override
    public UserProfile getUserProfileById(String username) {
        String query = "SELECT * FROM " + Table.USER_PROFILE.name +" WHERE username='%s'";
        query = String.format(query, username);
        LoggerService.info(query);
        return (UserProfile) template.query(query, new UserProfileMapper()).get(0);
    }

    @Override
    public List<UserProfile> getUserProfilesByCity(String cityName) {
        String query = "SELECT * FROM " + Table.USER_PROFILE.name +" WHERE cityName='%s'";
        query = String.format(query, cityName);
        LoggerService.info(query);
        return (List<UserProfile>) template.query(query, new UserProfileMapper());
    }

    @Override
    public List<UserProfile> getUserProfilesByStreet(String streetName, String cityName) {
        String query = "SELECT * FROM " + Table.USER_PROFILE.name +" WHERE cityName='%s' AND streetName='%s'";
        query = String.format(query, cityName, streetName);
        LoggerService.info(query);
        return (List<UserProfile>) template.query(query, new UserProfileMapper());
    }

    @Override
    public void insertUserProfile(UserProfile userProfile) {
        final String query = "INSERT INTO " + Table.USER_PROFILE.name +" (username, houseNumber, cityName, streetName, mobileNumber) " +
                "VALUES(:username, :houseNumber, :cityName, :streetName, :mobileNumber)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("username", userProfile.getUsername())
                .addValue("houseNumber", userProfile.getHouseNumber())
                .addValue("streetName", userProfile.getStreetName())
                .addValue("cityName", userProfile.getCityName())
                .addValue("mobileNumber", userProfile.getMobileNumber());
        LoggerService.debug(query);
        template.update(query, param, keyHolder);
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {

    }

    @Override
    public void deleteUserProfile(String id) {

    }
}

package com.foorder.mapper;

import com.foorder.model.City;
import com.foorder.model.Street;
import com.foorder.model.UserProfile;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileMapper implements RowMapper {

    @Override
    public UserProfile mapRow(ResultSet resultSet, int i) throws SQLException {
        String username = resultSet.getString("username");
        UserProfile userProfile = new UserProfile(username);
        userProfile.setHouseNumber(resultSet.getString("houseNumber"));
        userProfile.setCityId(resultSet.getString("cityId"));
        userProfile.setStreetId(resultSet.getString("streetId"));
        return userProfile;
    }
}
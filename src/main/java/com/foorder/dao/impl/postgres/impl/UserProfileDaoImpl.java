package com.foorder.dao.impl.postgres;

import com.foorder.dao.UserProfileDao;
import com.foorder.model.City;
import com.foorder.model.Street;
import com.foorder.model.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {
    @Override
    public List<UserProfile> getAllUserProfiles() {
        return null;
    }

    @Override
    public UserProfile getUserProfileById(String userId) {
        return null;
    }

    @Override
    public List<UserProfile> getUserProfilesByCity(City city) {
        return null;
    }

    @Override
    public List<UserProfile> getUserProfilesByStreet(Street street) {
        return null;
    }

    @Override
    public void insertUserProfile(UserProfile userProfile) {

    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {

    }

    @Override
    public void deleteUserProfile(String userId) {

    }
}

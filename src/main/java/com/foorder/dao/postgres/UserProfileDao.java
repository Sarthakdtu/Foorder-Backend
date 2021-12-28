package com.foorder.dao.postgres;

import com.foorder.model.City;
import com.foorder.model.Street;
import com.foorder.model.UserProfile;

import java.util.List;

public interface UserProfileDao {
    public List<UserProfile> getAllUserProfiles();

    public UserProfile getUserProfileById(String userId);

    public List<UserProfile> getUserProfilesByCity(City city);

    public List<UserProfile> getUserProfilesByStreet(Street street);

    public void insertUserProfile(UserProfile userProfile);

    public void updateUserProfile(UserProfile userProfile);

    public void deleteUserProfile(String userId);
}

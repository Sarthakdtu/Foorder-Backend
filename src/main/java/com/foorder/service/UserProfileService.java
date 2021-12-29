package com.foorder.service;

import com.foorder.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    public List<UserProfile> getAllUserProfiles();

    public UserProfile getUserProfileById(String id);

    public List<UserProfile> getUserProfilesByCity(String cityName);

    public List<UserProfile> getUserProfilesByStreet(String streetName, String cityName);

    public void insertUserProfile(UserProfile userProfile);

    public void updateUserProfile(UserProfile userProfile);

    public void deleteUserProfile(String id);
}

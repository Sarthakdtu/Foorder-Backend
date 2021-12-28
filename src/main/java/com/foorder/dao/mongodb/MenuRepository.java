package com.foorder.dao.mongodb;

import com.foorder.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MenuRepository extends MongoRepository<Menu, String> {

    @Query("{restaurantId:'?0'}")
    Menu findMenuByRestaurantId(String restaurantId);

    public long count();
}

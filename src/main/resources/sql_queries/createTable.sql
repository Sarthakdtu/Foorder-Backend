
CREATE TABLE CITY(
                    name VARCHAR(16) PRIMARY KEY NOT NULL
);

CREATE TABLE STREET(name VARCHAR(26) NOT NULL,
                    cityName VARCHAR(16) NOT NULL,
                    pincode VARCHAR(16) NOT NULL,
                    PRIMARY KEY(name, cityName),
                    CONSTRAINT fk_cityName
                            FOREIGN KEY(cityName)
                       	        REFERENCES CITY(name)
);

CREATE TABLE USER_PROFILE(
    username VARCHAR(16) NOT NULL PRIMARY KEY,
    houseNumber VARCHAR(16) NOT NULL,
    cityName VARCHAR(16) NOT NULL,
    streetName VARCHAR(26) NOT NULL,
    CONSTRAINT fk_cityName
        FOREIGN KEY(cityName)
            REFERENCES CITY(name)
);

CREATE TABLE RESTAURANT(
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    name VARCHAR(16) NOT NULL,
    cityName VARCHAR(16) NOT NULL,
    streetName VARCHAR(26) NOT NULL,
    CONSTRAINT fk_cityName
        FOREIGN KEY(cityName)
            REFERENCES CITY(name)
);


CREATE TABLE DELIVERED_ORDERS(
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    username VARCHAR(16) NOT NULL,
    restaurantId VARCHAR(16) NOT NULL,
    orderedItemsID VARCHAR(20) NOT NULL,
    orderTime TIMESTAMP NOT NULL,
    deliveryId VARCHAR(20) NOT NULL,
    deliveryTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    price REAL,
    CONSTRAINT fk_username
        FOREIGN KEY(username)
            REFERENCES USER_PROFILE(username),
    CONSTRAINT fk_restaurantId
        FOREIGN KEY(restaurantId)
            REFERENCES RESTAURANT(id)
);

CREATE TABLE PENDING_ORDERS(
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    username VARCHAR(16) NOT NULL,
    restaurantId VARCHAR(16) NOT NULL,
    orderedItemsID VARCHAR(20) NOT NULL,
    orderTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    pickUpTime TIMESTAMP,
    price REAL,
    CONSTRAINT fk_username
        FOREIGN KEY(username)
            REFERENCES USER_PROFILE(username),
    CONSTRAINT fk_restaurantId
        FOREIGN KEY(restaurantId)
            REFERENCES RESTAURANT(id)
);
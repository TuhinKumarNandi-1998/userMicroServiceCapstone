CREATE TABLE address
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    last_modifieda  datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    city            VARCHAR(255) NULL,
    street          VARCHAR(255) NULL,
    number          INT    NOT NULL,
    zip_code        VARCHAR(255) NULL,
    geo_location_id BIGINT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE geo_location
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    last_modifieda datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    latitude       VARCHAR(255) NULL,
    longitude      VARCHAR(255) NULL,
    CONSTRAINT pk_geolocation PRIMARY KEY (id)
);

CREATE TABLE names
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    last_modifieda datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    first_name     VARCHAR(255) NULL,
    last_name      VARCHAR(255) NULL,
    CONSTRAINT pk_names PRIMARY KEY (id)
);

CREATE TABLE users
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    last_modifieda datetime NULL,
    is_deleted     BIT(1) NOT NULL,
    email          VARCHAR(255) NULL,
    user_name      VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    name_id        BIGINT NULL,
    address_id     BIGINT NULL,
    phone_no       VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_GEO_LOCATION FOREIGN KEY (geo_location_id) REFERENCES geo_location (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_NAME FOREIGN KEY (name_id) REFERENCES names (id);
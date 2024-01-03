create DATABASE osahaneat;

USE osahaneat;

CREATE TABLE roles (
    id INT auto_increment,
    role_name VARCHAR(20),
    created_at TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE user(
    id INT auto_increment,
    user_name VARCHAR(1000),
    password VARCHAR(100),
    full_name VARCHAR(50),
    created_at TIMESTAMP,
    role_id INT,

PRIMARY KEY(id)

);

CREATE TABLE ratings (
    id INT auto_increment,
    user_id INT,
    food_id INT,
    content TEXT,
    rate_point INT(5),

    PRIMARY KEY(id)

);

CREATE TABLE category (
    id INT auto_increment,
    name_category VARCHAR(100),
    created_at TIMESTAMP,

PRIMARY KEY(id)
);

CREATE TABLE food (
    id INT auto_increment,
    title VARCHAR(255),
    image TEXT,
    time_ship VARCHAR(10),
    price DECIMAL,
    cate_id INT,

    PRIMARY KEY(id)
);

CREATE TABLE ratingrestaurant(
    id INT auto_increment,
    user_id INT,
    restaurant_id INT,
    content TEXT,
    rate_point INT(5),

    PRIMARY KEY(id)
);

CREATE TABLE order (
    id INT auto_increment,
    user_id int,
    res_id int,
    create_at TIMESTAMP,

    PRIMARY KEY(id)

);

CREATE TABLE menu_restaurant(
    cate_id INT,
    res_id  INT,
    create_at TIMESTAMP,

    PRIMARY KEY(cate_id, res_id)
);

CREATE TABLE restaurant(
    id int auto_increment,
    title VARCHAR(255),
    subtitle VARCHAR(255),
    description TEXT,
    image TEXT,
    is_free_ship BOOLEAN,
    address VARCHAR(255),
    open_date TIMESTAMP

    PRIMARY KEY(id)
);

CREATE TABLE promotion(
    id int auto_increment,
    res_id int,
    percent int,
    start_date TIMESTAMP,
    end_date TIMESTAMP,

    PRIMARY KEY(id)
);

CREATE TABLE order_item(
    order_id INT,
    food_id INT,
    created_date TIMESTAMP,

    PRIMARY KEY(order_id, food_id)
);

ALTER TABLE user ADD constraint fk_user_role_id FOREIGN KEY(role_id) REFERENCES roles(id);
ALTER TABLE ratings ADD constraint fk_ratings_user_id FOREIGN KEY(user_id) REFERENCES user(id);
ALTER TABLE ratings ADD constraint fk_ratings_food_id FOREIGN KEY(food_id) REFERENCES food(id);
ALTER TABLE food ADD constraint fk_ratings_cate_id FOREIGN KEY(cate_id) REFERENCES category(id);

ALTER TABLE ratingrestaurant ADD constraint fk_ratings_user_id FOREIGN KEY(user_id) REFERENCES user(id);
ALTER TABLE ratingrestaurant ADD constraint fk_ratings_res_id FOREIGN KEY(restaurant_id) REFERENCES restaurant(id);

ALTER TABLE order ADD constraint fk_order_user_id FOREIGN KEY(user_id) REFERENCES user(id);
ALTER TABLE order ADD constraint fk_order_res_id FOREIGN KEY(res_id) REFERENCES restaurant(id);
ALTER TABLE order_item ADD constraint fk_orderitem_order_id FOREIGN KEY(order_id) REFERENCES order(id);
ALTER TABLE order_item ADD constraint fk_orderitem_food_id FOREIGN KEY(food_id) REFERENCES food(id);

ALTER TABLE menu_restaurant ADD constraint fk_menu_restaurant_cate_id FOREIGN KEY(cate_id) REFERENCES category(id);
ALTER TABLE menu_restaurant ADD constraint fk_menu_restaurant_res_id FOREIGN KEY(res_id) REFERENCES restaurant(id);
ALTER TABLE promotion ADD constraint fk_promotion_res_id FOREIGN KEY(res_id) REFERENCES restaurant(id);






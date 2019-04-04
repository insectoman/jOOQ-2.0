CREATE TABLE customer
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    surname VARCHAR(100),
    phone_number VARCHAR(100) NOT NULL,
    email VARCHAR(200)
);

CREATE TABLE car
(
    id IDENTITY PRIMARY KEY ,
    brand VARCHAR(100) NOT NULL,
    model_year INTEGER NOT NULL,
    customer_id BIGINT,

    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE "order"
(
    id IDENTITY PRIMARY KEY,
    price FLOAT,
    finished BOOLEAN NOT NULL DEFAULT false,
    description VARCHAR(2000) NOT NULL,
    car_id BIGINT,

    FOREIGN KEY (car_id) REFERENCES car(id)
);

CREATE TABLE mechanic
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL
);

CREATE TABLE mechanic_order
(
    id IDENTITY PRIMARY KEY,
    mechanic_id BIGINT,
    order_id BIGINT,

    FOREIGN KEY (mechanic_id) REFERENCES mechanic(id),
    FOREIGN KEY (order_id) REFERENCES "order"(id)
)

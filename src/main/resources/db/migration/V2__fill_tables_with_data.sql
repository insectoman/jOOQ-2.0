INSERT INTO customer
    (id, name, surname, phone_number, email)
VALUES (1, 'Piotr', 'Hendzel', '666604804', 'phendzel.dev@gmail.com'),
       (2, 'Adam', 'Adamski', '123602304', 'adamski@gmail.com'),
       (3, 'Stanislaw', 'Jodla', '435604544', 'stasz@gmail.com');

INSERT INTO car
    (id, brand, model_year, customer_id)
values (1, 'VW', 2010, 1),
       (2, 'Audi', 2001, 2),
       (3, 'Skoda', 2012, 3),
       (4, 'BMW', 2015, 1);

INSERT INTO mechanic
    (id, name, surname)
VALUES (1, 'Janusz', 'Januszowy'),
       (2, 'Tomasz', 'Tomaszowy');

INSERT INTO "order"
(id, price, finished, description, car_id)
VALUES (1, NULL, FALSE, 'Cos stuka w lewym kole.', 1),
       (2, 1250.00, TRUE, 'Wymiana rozrzadu.', 2),
       (3, 100.00, TRUE, 'Sprawdzenie stanu olejow.', 1);

INSERT INTO mechanic_order
(id, order_id, mechanic_id)
values (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1);

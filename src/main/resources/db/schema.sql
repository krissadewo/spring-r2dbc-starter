CREATE TABLE IF NOT EXISTS param
(
    id
    SERIAL
    PRIMARY
    KEY,
    first_name
    VARCHAR
(
    255
), last_name VARCHAR
(
    255
));

CREATE TABLE IF NOT EXISTS category
(
    id
    SERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
));

CREATE TABLE IF NOT EXISTS item
(
    id
    SERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
),
    category_id SERIAL,
    CONSTRAINT fk_category
    FOREIGN KEY
(
    category_id
)
    REFERENCES category
(
    id
));

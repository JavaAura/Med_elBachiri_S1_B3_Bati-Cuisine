-- set enum columns
CREATE TYPE status_enum AS ENUM ("IN_PROGRESS", "DONE", "CANCELED");

-- create db
-- CREATE DATABASE bati_cuisine;

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    address TEXT,
    phone VARCHAR(244),
    is_professional BOOLEAN
);

CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    benefit_margin NUMERIC,
    total_cost NUMERIC,
    status status_enum
);

CREATE TABLE IF NOT EXISTS quotation (
    id SERIAL PRIMARY KEY,
    estimated_amount NUMERIC,
    issue_date DATE,
    valid_until DATE,
    is_accepted BOOLEAN
);




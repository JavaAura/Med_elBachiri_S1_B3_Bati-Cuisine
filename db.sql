-- set enum columns if not exists
CREATE TYPE status_enum AS ENUM ('IN_PROGRESS', 'DONE', 'CANCELED');

-- create db
-- CREATE DATABASE bati_cuisine;

CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(70) UNIQUE NOT NULL,
    address VARCHAR(250) NOT NULL,
    phone VARCHAR(12) NOT NULL,
    is_professional BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) UNIQUE NOT NULL,
    benefit_margin NUMERIC(11, 4) NOT NULL,
    total_cost NUMERIC(20, 4) NOT NULL,
    status status_enum NOT NULL,
    client_id
);

CREATE TABLE IF NOT EXISTS components (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) UNIQUE NOT NULL,
    unit_cost NUMERIC(20, 4) NOT NULL,
    quantity NUMERIC(14, 4) NOT NULL,
    type VARCHAR(40) NOT NULL,
    tva_rate NUMERIC NOT NULL
);

CREATE TABLE IF NOT EXISTS quotation (
    estimated_amount NUMERIC(14, 4) NOT NULL,
    issue_date DATE NOT NULL,
    valid_until DATE NOT NULL,
    is_accepted BOOLEAN DEFAULT FALSE
) INHERITS (components);

CREATE TABLE IF NOT EXISTS labors (
    hourly_rate NUMERIC(11, 4) NOT NULL,
    hours_worked NUMERIC(11, 4) NOT NULL,
    worker_productivity NUMERIC(6,4) NOT NULL
) INHERITS (components);




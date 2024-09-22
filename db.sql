-- set enum columns if not exists
CREATE TYPE status_enum AS ENUM ('IN_PROGRESS', 'DONE', 'CANCELED');

-- create db
-- CREATE DATABASE bati_cuisine;

CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(70) UNIQUE NOT NULL,
    address VARCHAR(250) NOT NULL,
    phone VARCHAR(16) NOT NULL,
    is_professional BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70),
    benefit_margin NUMERIC(11, 2),
    total_cost NUMERIC(11, 2),
    status status_enum,
    kitchen_area_m2 NUMERIC(6,2),
    client_id INT REFERENCES clients
);

CREATE TABLE IF NOT EXISTS components (
    id SERIAL PRIMARY KEY,
    name VARCHAR(70) UNIQUE NOT NULL,
    component_type VARCHAR(40) NOT NULL,
    tva_rate NUMERIC,
    project_id INT REFERENCES projects(id)
);

CREATE TABLE IF NOT EXISTS materials (
    unit_cost NUMERIC(20, 2) NOT NULL,
    quantity NUMERIC(14, 2) NOT NULL,
    transport_cost NUMERIC(20, 2),
    coefficient_quality NUMERIC(11, 2),
    material_cost NUMERIC(20, 2) NOT NULL
) INHERITS (components);

CREATE TABLE IF NOT EXISTS labors (
    hourly_rate NUMERIC(11, 2) NOT NULL,
    hours_worked NUMERIC(11, 2) NOT NULL,
    worker_productivity NUMERIC(6,2) NOT NULL,
    labor_cost NUMERIC(20, 2) NOT NULL
) INHERITS (components);

CREATE TABLE IF NOT EXISTS quotation (
    id SERIAL PRIMARY KEY,
    estimated_amount NUMERIC(14,2),
    issue_date DATE NOT NULL,
    valid_until DATE NOT NULL,
    accepted BOOLEAN DEFAULT FALSE
);



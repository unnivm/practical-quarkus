-- V1__Create_user_table.sql
-- This script creates the user table for our Quarkus application

CREATE TABLE IF NOT EXISTS app_user (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    age INTEGER NOT NULL
);

-- Create an index on email for faster lookups
CREATE INDEX idx_user_email ON app_user(email);

-- Create an index on name for search queries
CREATE INDEX idx_user_name ON app_user(name);
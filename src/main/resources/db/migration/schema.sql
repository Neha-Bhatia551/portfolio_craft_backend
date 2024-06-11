CREATE TABLE IF NOT EXISTS signupinfo (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,

);

-- Other existing tables
CREATE TABLE IF NOT EXISTS userinfo (
    id SERIAL PRIMARY KEY,
    templateid int,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(100),
    university VARCHAR(100),
    education TEXT,
    experience TEXT,
    tech_stack TEXT,
    projects TEXT,
    summary TEXT,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    linked_in VARCHAR(255)
);

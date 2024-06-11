DROP TABLE IF EXISTS userinfo;

CREATE TABLE userinfo (
    id SERIAL PRIMARY KEY,
    templateid int,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(100),
    university VARCHAR(100),
    education TEXT,
    tech_stack TEXT,
    summary TEXT,
    gpa VARCHAR(10), -- Add this line
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    linked_in VARCHAR(255)
);

CREATE TABLE experience_list (
    user_id int,
    experience TEXT,
    FOREIGN KEY (user_id) REFERENCES userinfo(id) ON DELETE CASCADE
);

CREATE TABLE project_list (
    user_id int,
    project TEXT,
    FOREIGN KEY (user_id) REFERENCES userinfo(id) ON DELETE CASCADE
);

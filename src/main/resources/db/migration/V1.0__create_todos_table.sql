-- CREATE TODOS TABLE
DROP TABLE IF EXISTS todos;

CREATE TABLE IF NOT EXISTS todos
(
    id              INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title           TEXT,
    content         TEXT ,
    status          TEXT NOT NULL,
    due_date        TIMESTAMP WITH TIME ZONE,
    created_at      TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at      TIMESTAMP WITH TIME ZONE NOT NULL
);

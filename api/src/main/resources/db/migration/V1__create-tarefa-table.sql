CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tarefa (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo varchar(100) NOT NULL,
    descricao varchar(1000) NOT NULL,
    validade TIMESTAMP NOT NULL

)

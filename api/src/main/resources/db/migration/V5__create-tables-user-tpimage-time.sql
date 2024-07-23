CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE time (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255)
);

CREATE TABLE tipo_imagem (
    id SERIAL PRIMARY KEY,
    codigo INTEGER,
    nome VARCHAR(255)
);

CREATE TABLE auth_user (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255),
    senha VARCHAR(255),
    email VARCHAR(255)
);

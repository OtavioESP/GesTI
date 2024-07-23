CREATE TABLE imagem (
    id SERIAL PRIMARY KEY,
    key VARCHAR(255),
    tarefa_id UUID,
    FOREIGN KEY (tarefa_id) REFERENCES tarefa(id)
);
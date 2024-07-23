ALTER TABLE tarefa
ADD COLUMN status_id INTEGER,
ADD CONSTRAINT fk_status
FOREIGN KEY (status_id)
REFERENCES status(id);
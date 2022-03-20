DROP TABLE IF EXISTS grupo CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS usuario_categoria CASCADE;

CREATE TABLE grupo (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE usuario (
  id bigint GENERATED ALWAYS AS IDENTITY,
  username varchar(255),
  password varchar(128),
  auth_token varchar(128),
  PRIMARY KEY (id)
);

CREATE TABLE categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name varchar(255),
  id_grupo bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_id_grupo FOREIGN KEY (id_grupo) REFERENCES grupo(id) ON DELETE SET NULL
);

CREATE TABLE usuario_categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  id_categoria bigint,
  id_usuario bigint,
  times_searched bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id) ON DELETE SET NULL,
  CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE SET NULL
);



























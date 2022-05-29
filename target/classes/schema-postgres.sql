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
  auth_token varchar(128) UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name varchar(255) UNIQUE,
  id_grupo bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_id_grupo FOREIGN KEY (id_grupo) REFERENCES grupo(id) ON DELETE SET NULL
);

CREATE TABLE usuario_categoria (
  id bigint GENERATED ALWAYS AS IDENTITY,
  name_categoria varchar(255),
  token_usuario varchar(128),
  interest_rate bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_name_categoria FOREIGN KEY (name_categoria) REFERENCES categoria(name) ON DELETE SET NULL,
  CONSTRAINT fk_token_usuario FOREIGN KEY (token_usuario) REFERENCES usuario(auth_token) ON DELETE SET NULL
);



























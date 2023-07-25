DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS produto CASCADE;
DROP TABLE IF EXISTS pedido CASCADE;

CREATE TABLE usuario (
    id bigint GENERATED ALWAYS AS IDENTITY,
    nome varchar(255),
    sobrenome varchar(255),
    nascimento_data varchar(255),
    email varchar(255) UNIQUE,
    senha varchar(255),
    token varchar(255) UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE produto (
    id bigint GENERATED ALWAYS AS IDENTITY,
    nome varchar(255),
    preco bigint,
    estoque bigint,
    PRIMARY KEY (id)
);

CREATE TABLE pedido (
    id bigint GENERATED ALWAYS AS IDENTITY,
    usuario_id bigint,
    usuario_token varchar(255),
    produto_id bigint,
    status_pagamento varchar(255),
    status_entrega varchar(255),
    PRIMARY KEY (id),
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL,
    CONSTRAINT fk_usuario_token FOREIGN KEY (usuario_token) REFERENCES usuario(token) ON DELETE SET NULL,
    CONSTRAINT fk_produto_id FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE SET NULL
);
create table cliente
(
    id   smallint unsigned auto_increment
        primary key,
    nome varchar(60) not null,
    fone char(10)    null
);

INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (1, 'Adriano Arruda', '1322444422');
INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (2, 'Sonia Costa', '1123456789');
INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (3, 'Amanda Pizarro', '1567890098');
INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (4, 'Orioles Junior', '6177899987');
INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (5, 'Fabio Henrique Silva', '1222344321');
INSERT INTO cadastro_clientes.cliente (id, nome, fone) VALUES (6, 'Zelia Amato', '6599554433');
create table pedido
(
    id         smallint unsigned auto_increment
        primary key,
    data       date              not null,
    valor      decimal(10, 2)    not null,
    id_cliente smallint unsigned not null,
    constraint pedido_ibfk_1
        foreign key (id_cliente) references cliente (id)
);

create index id_cliente
    on pedido (id_cliente);

INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (1, '2015-10-01', 1045.77, 1);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (2, '2015-10-02', 210.00, 1);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (3, '2015-10-03', 38.90, 1);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (4, '2015-10-04', 12.01, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (5, '2015-10-05', 138.90, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (6, '2015-10-06', 318.90, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (7, '2015-10-07', 381.90, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (8, '2015-10-08', 328.90, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (9, '2015-10-09', 338.90, 2);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (10, '2015-10-10', 3438.90, 3);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (11, '2015-10-10', 1238.90, 4);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (12, '2015-10-11', 3238.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (13, '2015-10-12', 308.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (14, '2015-10-14', 328.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (15, '2015-10-15', 318.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (16, '2015-10-16', 138.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (17, '2015-10-17', 138.90, 5);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (18, '2015-10-18', 438.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (19, '2015-10-19', 538.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (20, '2015-10-20', 638.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (21, '2015-10-21', 738.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (22, '2015-10-22', 838.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (23, '2015-10-23', 938.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (24, '2015-10-24', 1138.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (25, '2015-10-25', 1238.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (26, '2015-10-26', 138.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (27, '2015-10-27', 238.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (28, '2015-10-28', 538.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (29, '2015-10-29', 638.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (30, '2016-10-18', 438.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (31, '2016-10-19', 538.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (32, '2016-10-20', 638.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (33, '2016-10-21', 738.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (34, '2016-10-22', 838.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (35, '2016-10-23', 938.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (36, '2016-10-24', 1138.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (37, '2016-10-25', 1238.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (38, '2016-10-26', 138.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (39, '2016-10-27', 238.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (40, '2016-10-28', 538.90, 6);
INSERT INTO cadastro_clientes.pedido (id, data, valor, id_cliente) VALUES (41, '2016-10-29', 638.90, 6);
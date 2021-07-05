drop table if exists tbl_anuncio CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table tbl_anuncio (
    id bigint not null,
    data_inicio date,
    data_termino date,
    nome_anuncio varchar(255),
    nome_cliente varchar(255),
    valor_investido_dia double,
    primary key (id)
);
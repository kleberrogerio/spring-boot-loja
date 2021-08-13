create schema loja;

use loja;


create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on loja.* to user@'localhost';

create table mar_marca(
	mar_id bigint unsigned not null auto_increment,
	mar_nome varchar(20) not null,
	primary key (mar_id),
	unique key mar_marca_nome (mar_nome)
);

create table pro_produto(
	pro_id bigint unsigned not null auto_increment,
	pro_nome varchar(20) not null,
	mar_id bigint unsigned not null,
	pro_preco decimal(15,2) not null,
	primary key (pro_id),
	foreign key pro_mar_fk (mar_id)
		references mar_marca (mar_id)
		on delete restrict on update cascade
);

create table ven_venda(
	ven_id bigint unsigned not null auto_increment,
	ven_data date not null,
        ven_qtde bigint not null,
  	ven_preco_venda decimal(15,2) not null,
	primary key (ven_id)
);

create table ite_itemvenda(
  pro_id bigint unsigned not null,
  ven_id bigint unsigned not null,
  primary key (pro_id, ven_id),
  foreign key ite_pro_fk (pro_id) references pro_produto (pro_id) on delete restrict on update cascade,
  foreign key ite_ven_fk (ven_id) references ven_venda (ven_id) on delete restrict on update cascade
);
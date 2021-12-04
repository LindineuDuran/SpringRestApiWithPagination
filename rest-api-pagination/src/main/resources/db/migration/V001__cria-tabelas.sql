create table `cargo`
(
  `id` bigint(20) not null,
  `funcao` varchar(255) default null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

create table `funcionario`
(
  `id` bigint(20) not null,
  `id_cargo` bigint(20) not null,
  `nome` varchar(255) default null,
  `email` varchar(255) default null,
  primary key (`id`),
  key `FK92othhhe25gno2qtus5woc6ys` (`id_cargo`),
  constraint `FK92othhhe25gno2qtus5woc6ys` foreign key (`id_cargo`) references `cargo` (`id`)
) engine=InnoDB default charset=utf8;
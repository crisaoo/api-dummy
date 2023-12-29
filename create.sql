create table tb_catch_rate (catch_rate float(53), pokeball_type_code smallint not null check (pokeball_type_code between 0 and 26), pokemon_type_code smallint not null check (pokemon_type_code between 0 and 17), primary key (pokeball_type_code, pokemon_type_code));
create table tb_pokeball (price float(53), id bigserial not null, description TEXT, type varchar(255) check (type in ('REGULAR','GREAT','ULTRA','MASTER','LOVE','LURE','NET','SAFARI','LEVEL','LUXURY','PREMIER','DIVE','NEST','REPEAT','TIMER','QUICK','DUSK','SPORT','HEAL','CHERISH','PARK','DREAM','BEAST','FAST','FRIEND','HEAVY','MOON')), primary key (id));
create table tb_pokemon (height float(53), weight float(53), evolution bigint, id bigserial not null, name varchar(255), primary key (id));
create table tb_pokemon_captured (capture_date date, pokeball_id bigint not null unique, pokemon_id bigint not null unique, location varchar(255), trainer varchar(255), primary key (pokeball_id, pokemon_id));
create table tb_pokemon_type (pokemon_id bigint not null, type varchar(255) check (type in ('NORMAL','FIRE','WATER','ELECTRIC','GRASS','ICE','FIGHTING','POISON','GROUND','FLYING','PSYCHIC','BUG','ROCK','GHOST','DRAGON','DARK','STEEL','FAIRY')));
create table tb_pokemon_weakness (pokemon_id bigint not null, weakness varchar(255) check (weakness in ('NORMAL','FIRE','WATER','ELECTRIC','GRASS','ICE','FIGHTING','POISON','GROUND','FLYING','PSYCHIC','BUG','ROCK','GHOST','DRAGON','DARK','STEEL','FAIRY')));
alter table if exists tb_pokemon_captured add constraint FKka5l554gh3svds0q9oonuy58u foreign key (pokeball_id) references tb_pokeball;
alter table if exists tb_pokemon_captured add constraint FKfq1m8e11dwvgqt3g90v51d1n7 foreign key (pokemon_id) references tb_pokemon;
alter table if exists tb_pokemon_type add constraint FKfqiyoqhq5ngss04dopl12mf7n foreign key (pokemon_id) references tb_pokemon;
alter table if exists tb_pokemon_weakness add constraint FKb9d8bya6dsjfswtyrpklaupu9 foreign key (pokemon_id) references tb_pokemon;
INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (1, 'Bulbasaur', null, 6.9, 0.7);
INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (2, 'Squirtle', null, 9, 0.5);
INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (3, 'Charmander', null, 8.5, 0.61);
INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (4, 'Pikachu', null, 6, 0.4);
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'GRASS');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'POISON');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (2, 'WATER');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (3, 'FIRE');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (4, 'ELECTRIC');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FIRE');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'ICE');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FLYING');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'POISON');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'BUG');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (2, 'ELECTRIC');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (2, 'GRASS');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (3, 'WATER');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (3, 'ROCK');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (4, 'FLYING');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (4, 'STEEL');
INSERT INTO tb_pokeball (id, type, price, description) VALUES (1, 'SAFARI', null, 'The Safari Ball is a type of Poké Ball introduced in Generation I. It can be used to catch wild Pokémon during a Safari Game.');
INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 4);
INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 11);
INSERT INTO tb_pokemon_captured (capture_date, location, trainer, pokemon_id, pokeball_id) VALUES (null, 'Wild village', 'Ash', 1, 1);

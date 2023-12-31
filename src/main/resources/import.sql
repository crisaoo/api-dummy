INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Bulbasaur', null, 6.9, 0.7);
INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Squirtle', null, 9, 0.5);
INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Pikachu', null, 6, 0.4);
INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Charizard', null, 90.5, 1.7);
INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Charmeleon', 4, 19, 1.1);
INSERT INTO tb_pokemon (name, evolution_id, weight, height) VALUES ('Charmander', 5, 8.5, 0.61);


INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'GRASS');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'POISON');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (2, 'WATER');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (3, 'ELECTRIC');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (4, 'FLYING');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (4, 'FIRE');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (5, 'FIRE');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (6, 'FIRE');


INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FIRE');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'ICE');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FLYING');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'POISON');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'BUG');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (2, 'ELECTRIC');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (2, 'GRASS');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (3, 'FLYING');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (3, 'STEEL');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (4, 'WATER');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (4, 'ROCK');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (5, 'WATER');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (5, 'ROCK');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (6, 'WATER');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (6, 'ROCK');


-- INSERT INTO tb_pokeball (id, type, price, description) VALUES (1, 'SAFARI', null, 'The Safari Ball is a type of Poké Ball introduced in Generation I. It can be used to catch wild Pokémon during a Safari Game.');
--
--
-- INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 4);
-- INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 11);
--
--
-- INSERT INTO tb_pokemon_captured (capture_date, location, trainer, pokemon_id, pokeball_id) VALUES (null, 'Wild village', 'Ash', 1, 1);
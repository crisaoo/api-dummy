INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (1, 'Bulbasaur', null, 6.9, 0.7);
INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (2, 'Caterpie', null, 2.9, 0.3);

INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'GRASS');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'POISON');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (2, 'BUG')

INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FIRE');
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (2, 'FIRE');

INSERT INTO tb_pokeball (id, type, price, description) VALUES (1, 'SAFARI', null, 'The Safari Ball is a type of Poké Ball introduced in Generation I. It can be used to catch wild Pokémon during a Safari Game.');

INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 4);
INSERT INTO tb_catch_rate (catch_rate, pokeball_type_code, pokemon_type_code) VALUES (1.5, 7, 11);

INSERT INTO tb_pokemon_captured (capture_date, location, trainer, pokemon_id, pokeball_id) VALUES (null, 'Wild village', 'Ash', 1, 1); 
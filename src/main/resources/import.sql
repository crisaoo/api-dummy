INSERT INTO tb_pokemon (id, name, evolution, weight, height) VALUES (1, 'Bulbasaur', null, 6.9, 0.7);

INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'GRASS');
INSERT INTO tb_pokemon_type (pokemon_id, type) VALUES (1, 'POISON');
--
INSERT INTO tb_pokemon_weakness (pokemon_id, weakness) VALUES (1, 'FIRE');
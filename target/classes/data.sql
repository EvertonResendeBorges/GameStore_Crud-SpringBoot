INSERT INTO tb_game (name, genrer, platform, price, release, description) VALUES ('Castlevania', 'Platformer', 'NES', 2.00, 1986, 'Controle Simon Belmont e entre no castelo de Drácula para vencer todos os monstros e acabar com o mal.');
INSERT INTO tb_game (name, genrer, platform, price, release, description) VALUES ('Megaman', 'Platformer', 'NES', 2.00, 1986, 'Megaman é um robo azul combatente da justiça. Ajude-o a derrotar os 8 robos malignos e parar os planos do maléfico Dr.Willy.');

INSERT INTO tb_player (nick, email, password, wallet) VALUES ('Knight_Light', 'evertonrborges12@gmail.com', '12345', 250.00);
INSERT INTO tb_player (nick, email, password, wallet) VALUES ('gracinha173', 'gracinha173@gmail.com', '45879', 100.00);

INSERT INTO tb_player_game (player_id, game_id) VALUES (1,1);
INSERT INTO tb_player_game (player_id, game_id) VALUES (1,2);
INSERT INTO tb_player_game (player_id, game_id) VALUES (2,1);
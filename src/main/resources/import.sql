-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');





INSERT INTO public.estados(dataalteracao, datainclusao, id, nome, sigla)
	VALUES ('2023-04-12', '2023-04-12', 1, 'tribom', 'tb');

INSERT INTO public.estados(dataalteracao, datainclusao, id, nome, sigla)
	VALUES ('2023-04-12', '2023-04-12', 2, 'quadribom', 'qd');

INSERT INTO public.estados(dataalteracao, datainclusao, id, nome, sigla)
	VALUES ('2023-04-12', '2023-04-12', 3, 'bom', 'bm');

INSERT INTO public.estados(dataalteracao, datainclusao, id, nome, sigla)
	VALUES ('2023-04-12', '2023-04-12', 4, 'bomdemaisdaconta', 'bc');

-- -------------------------------------------------------------------------------------------

INSERT INTO public.municipio(dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 1, 1, 'proto-proto');

INSERT INTO public.municipio(dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 2, 2, 'proto-final');

INSERT INTO public.municipio(dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 3, 3, 'proto-inicio');

INSERT INTO public.municipio(dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 4, 4, 'proto');

	
-- -------------------------------------------------------------------------------------------

INSERT INTO public.endereco(dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 1, 1, 253443262, 24, 'rua patuver patuven', 'pertor do pato');

INSERT INTO public.endereco(dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 1, 2, 253443262, 24, 'rua que tem pedra', 'pertor da pedra');

INSERT INTO public.endereco( dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 2, 3, 74567456767, 54, 'não tem rua', 'pertor do nada');

INSERT INTO public.endereco(dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 3, 4, 2354242346632, 23, 'rua dos bobos', 'so tem bobo');

INSERT INTO public.endereco(dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 4, 5, 234572452245, 64, 'rua do valorant', 'so tem games');
	
-- -------------------------------------------------------------------------------------------

INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('false', '2023-04-12', '2023-04-12', 1, 2534763345 , 63);
	
INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('false', '2023-04-12', '2023-04-12', 2, 356435463 , 63);

INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('true', '2023-04-12', '2023-04-12', 3, 599857858 , 63);

INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('true', '2023-04-12', '2023-04-12', 4, 123412343 , 63);
	
INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('true', '2023-04-12', '2023-04-12', 5, 234523452345 , 63);

-- -------------------------------------------------------------------------------------------

INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, nomeimagem, senha)
	VALUES (1, '2023-04-12', '2023-04-12', 1, 1, 23452345234 , 'lucas', 'lucas', '?', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');

INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, nomeimagem, senha)
	VALUES (2, '2023-04-12', '2023-04-12', 2, 2, 23452345246 , 'roberto', 'roberto', '?', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');
	
INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, nomeimagem, senha)
	VALUES (3, '2023-04-12', '2023-04-12', 3, 3, 124123513243 , 'clobesvaldo', 'clobesvaldo', '?', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');
	
INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, nomeimagem, senha)
	VALUES (4, '2023-04-12', '2023-04-12', 4, 4, 2451234234 , 'goku', 'goku', '?', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');

INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, nomeimagem, senha)
	VALUES (5, '2023-04-12', '2023-04-12', 5, 5, 2451234234 , 'string', 'string', '?', 'H91PnULY1YEFa/uppEhvAiwTiJXmOMZJe9lmBp+GosLTEPiyR9ZaH2e0vX4C2OpxYa7Bqx0PZUYZFITckmSCHA==');
	
-- -------------------------------------------------------------------------------------------

INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (1, 'Admin');

INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (4, 'Admin');

INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (2, 'Vendedor');

INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (1, 'Cliente');

INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (5, 'User');



-- -------------------------------------------------------------------------------------------

/*

 */
       

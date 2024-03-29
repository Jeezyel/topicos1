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

INSERT INTO public.municipio(
	dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 1, 1, 'belen');
	
INSERT INTO public.municipio(
	dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 2, 2, 'belo orisont');
	
INSERT INTO public.municipio(
	dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12',3, 3, 'porto');

	
-- -------------------------------------------------------------------------------------------

INSERT INTO public.endereco(
	dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
	VALUES ('2023-04-12', '2023-04-12', 1 , 1, '21513441313', 'acula', 'rua ali', 'perto do porte');
	
-- -------------------------------------------------------------------------------------------


INSERT INTO public.telefone(
	celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES (false, '2023-04-12', '2023-04-12', 1,63, 0345802623);

INSERT INTO public.telefone(
	celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES (false, '2023-04-12', '2023-04-12', 2,63, 0345802623);

INSERT INTO public.telefone(
	celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES (false, '2023-04-12', '2023-04-12', 3,63, 0345802623);
-- -------------------------------------------------------------------------------------------
INSERT INTO public.cliente(
	endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, login, nome, senha, nomeimagem)
	VALUES (1, '2023-04-12', '2023-04-12', 1, 3, '3245838576554', 'kk', 'kk', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', '?');

-- -------------------------------------------------------------------------------------------


INSERT INTO public.perfis(
	id_usuario, perfil)
	VALUES (1, 'Admin');
/*
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



 */
       

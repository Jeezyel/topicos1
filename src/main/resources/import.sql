-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO public.municipio(dataalteracao, datainclusao, estados_id, id, nome)
	VALUES ('2023-04-12', '2023-04-12', 1, 1, 'proto-proto');



INSERT INTO public.estados(dataalteracao, datainclusao, id, nome, sigla)
	VALUES ('2023-04-12', '2023-04-12', 1, 'tribom', 'tb');



INSERT INTO public.endereco(dataalteracao, datainclusao, estados, id, cep, complemento, enderecocompleto, referencia)
VALUES ('2023-04-12', '2023-04-12', 1, 1, 253443262, 24, 'rua patuver patuven', 'pertor do pato');


INSERT INTO public.telefone(celular, dataalteracao, datainclusao, id, codigodearea, numero)
	VALUES ('false', '2023-04-12', '2023-04-12', 1, 2534763345 , 63);


INSERT INTO public.cliente(endereco_id, dataalteracao, datainclusao, id, telefone_id, cpf, nome)
	VALUES (1, '2023-04-12', '2023-04-12', 1, 1, 3142175676, 'Lucas');

UPDATE public.cliente
	SET  login='Lucas', senha= 123
	WHERE nome = 'Lucas';
/*

 */
       

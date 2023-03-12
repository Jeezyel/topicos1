-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');




-- insert into Roupas (id,quantidade,valor,cor,tipoDeTercido,marca ) values(nextval('hibernate_sequence'), 6 , 84 , 'branco','algodão','lacost');


insert into Roupas (id,quantidade,valor,cor,tipoDeTercido,marca ,modelo)
 values(nextval('hibernate_sequence'), 6 , 84 , 'branco','algodão','lacost','Polo Masculina');

 insert into Roupas (id,quantidade,valor,cor,tipoDeTercido,marca,modelo )
 values(nextval('hibernate_sequence'), 79 , 81884 , 'cinza','cetim','prada' , 'bag');

 insert into Roupas (id,quantidade,valor,cor,tipoDeTercido,marca,modelo )
 values(nextval('hibernate_sequence'), 33 , 9999 , 'marron','cetim','louis vuitton','capucine');

 //////////////////////////////////////////////////////////////////////////////////////////////////
/*
insert into Cliente (id,cpf,datadenacimento,nome)
 values(nextval('hibernate_sequence'), '3344556677' , '2000/01/14' , 'Lucas');

 insert into Cliente (id,cpf,datadenacimento,nome)
 values(nextval('hibernate_sequence'), '7435634756' , '2007/08/11' , 'Danilo');

 insert into Cliente (id,cpf,datadenacimento,nome)
 values(nextval('hibernate_sequence'), '3476556734' , '2009/04/13' , 'Rafael');
*/
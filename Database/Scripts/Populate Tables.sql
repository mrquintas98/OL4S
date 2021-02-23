insert into usertype (usertype_type) values
('administrator'),
('support'),
('adventurer');

insert into usergender (usergender_type) values
('Female'),
('Male'),
('Non-Binary');

insert into userpasswords (userpasswords_string,userpasswords_salt) values
('65B602EA78B8188157DA96E5750479AEC67BB8FE10F111588DB868D252620A55BC6C5A51ED6C0396DF8DB146047B27C2FAEDE2B8C24B00CF17011C0EF0B9A887','hga534ckfjs764hf62sf5gjg7465'),
('CA063EAE58A8FB0B9E92D3BC03FBC1102B88215C4FD2CFB220707C483E20F758EB5F52D5A3ACC8196DE73FA08D7B0E33DA028810D620F1D30DF28559345DC738','ASD97823789HAKC89SA987VS789SD790SD7890SD890'),
('7EBEDF34C9D1A06989D7CCD89E80DE22AAE2D56E48ACC275E2C594B608A50D3E6B7DFFE652E8C7C8140A0E88BFA03B3B8223C4B7BF3BE3154EA302E306B9C639','kdhf5211794582164875235asascbd');

insert into ticketstatus (ticketstatus_status) values
('Pending'),
('Denied'),
('Approved');

insert into infospecifics (infospecifics_name) values
('animal'),
('bird'),
('fish'),
('store'),
('open field'),
('enclosure'),
('private land'),
('public area');

insert into infoactivity (infoactivity_name) values
('fishing'),
('farming'),
('hunting'),
('camping'),
('shopping');

insert into user (user_name,user_birth,user_email,user_pic,user_userpasswords_id,user_usertype_id,user_usergender_id) values
('Mafalda Quintas',str_to_date('07.09.1998','%d.%m.%Y'),'mrquintas@outlook.com',null,1,1,1),
('Jeff Jeff',str_to_date('26.02.1995','%d.%m.%Y'),'jefferino@gmail.com',null,2,2,3),
('Athos R.',str_to_date('16.08.2000','%d.%m.%Y'),'athosr00@hotmail.com',null,3,3,2);

insert into userstatistics (userstatistics_date,userstatistics_session,userstatistics_duration,userstatistics_fishes,userstatistics_birds,userstatistics_animals,userstatistics_timezones,userstatistics_user_id) values
(str_to_date('20.10.2020','%d.%m.%Y'),1,94,1,2,4,1,3),
(str_to_date('21.10.2020','%d.%m.%Y'),2,21,3,5,10,1,3),
(str_to_date('29.10.2020','%d.%m.%Y'),3,167,5,7,17,1,3);

insert into ticket ( ticket_descrition,ticket_name,ticket_scientificname,ticket_latitude,ticket_longitude,ticket_ticketstatus_id) values
('Peixe encontrado no Cais do Gás. Pesca água doce.','Corvina','Argyrosomus regius',38.704844,-9.147001,1) ;

insert into ut ( ut_userreq_id,ut_userval_id,ut_ticket_id) values
(3,2,1);

insert into tis (tis_ticket_id,tis_infospecifics_id) values
(1,3),
(1,8);

insert into tia (tia_ticket_id,tia_infoactivity_id) values
(1,1);

insert into info (info_latitude,info_longitude,info_description,info_name,info_scientificname) values
(38.704844,-9.147001,'Peixe encontrado no Cais do Gás. Pesca da família Moronidae de tons acinzentados. Habitat natural estende-se a todas as águas em torno da Europa.','Robalo','Dicentrarchus labrax');

insert into iia (iia_info_id,iia_infoactivity_id) values
(1,1);

insert into iis (iis_info_id,iis_infospecifics_id) values
(1,3),
(1,8);



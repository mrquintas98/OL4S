create table user (												-- all user table
	user_id int not null auto_increment,
	user_name varchar(60) not null,						-- name of user, can be nickname, first and/or last name
	user_birth date,									-- self explanatory
	user_email varchar(30) not null,					-- self explanatory
	user_pic varchar(200),								-- location of file
	user_userpasswords_id int ,
	user_usertype_id int ,
	user_usergender_id int,
	primary key (user_id) );
	
create table userpasswords (
	userpasswords_id int not null auto_increment,
	userpasswords_string varchar(200) not null,			-- full string of the user's password after adding salt
	userpasswords_salt varchar(50) not null,			-- salt added to user's password
	primary key (userpasswords_id));
	
create table userstatistics (
	userstatistics_id int not null auto_increment,
	userstatistics_date date not null,					-- date in DD/MM/YYYY of the access
	userstatistics_session int not null,				-- number of the session
	userstatistics_duration int not null,				-- duration, in mins, of said session
	userstatistics_fishes int,							-- number of fishes "seen"
	userstatistics_birds int,							-- number of birds "seen"
	userstatistics_animals int,							-- number of animals "seen"
	userstatistics_timezones int,						-- number of timezones visited
	userstatistics_user_id int,
	primary key (userstatistics_id) );
	
create table usertype (
	usertype_id int not null auto_increment,
	usertype_type varchar(15) not null,					-- either admin, support(ticket validation, user support, etc) or adventurer(basic user)
	primary key (usertype_id) );
	
create table usergender (
	usergender_id int not null auto_increment,
	usergender_type varchar(10) not null,				-- female, male, non-binary
	primary key (usergender_id) );
	
create table ut (
	ut_id int not null auto_increment,
	ut_userreq_id int,							-- id of user requesting the ticket
	ut_userval_id int,							-- id of user validating the ticket
	ut_ticket_id int,							-- id of said ticket
	primary key(ut_id));	
	
create table ticket (
	ticket_id int not null auto_increment,
	ticket_description varchar(2000) not null,			-- description of the ticket
	ticket_name varchar(50),
	ticket_scientificname varchar(100),
	ticket_latitude Decimal(8,6) not null,				  
	ticket_longitude Decimal(9,6) not null,
	ticket_ticketstatus_id int,
	primary key (ticket_id));
	
create table ticketstatus (
	ticketstatus_id int not null auto_increment,
	ticketstatus_status varchar(10) not null,			-- pending/denied/approved
	primary key (ticketstatus_id) );
	
	
create table info (
	info_id int not null auto_increment,				
	info_latitude Decimal(8,6) not null,
	info_longitude Decimal(9,6) not null,
	info_description varchar(400),						-- general description of the info
	info_name varchar(30),								-- name of the info (if it exists)
	info_scientificname varchar(100),					-- scientific name of the info (if it exists)
	primary key (info_id) ) ;
	
create table infospecifics (
	infospecifics_id int not null auto_increment,
	infospecifics_name varchar(15) not null,			-- animel/bird/fish/store/open field/ enclosure/ private land/park
	primary key (infospecifics_id) );
	
create table infoactivity (
	infoactivity_id int not null auto_increment,
	infoactivity_name varchar(15) not null,				-- fishing/hunting/farming/camping/shopping
	primary key (infoactivity_id) );
	
create table iis (												-- connection table between info and infospecifics
	iis_id int not null auto_increment,
	iis_info_id int not null,							-- connection to info table
	iis_infospecifics_id int not null,					-- connection to infospecifics table
	primary key (iis_id) );
 
 create table iia (												-- connection table between info and infoactivity
	iia_id int not null auto_increment,
	iia_info_id int not null,							-- connection to info table
	iia_infoactivity_id int not null,					-- connection to infoactivity table	
	primary key (iia_id) ) ;
 
 create table tia (												-- connection table between ticket and infoactivity
	tia_id int not null auto_increment,
	tia_ticket_id int not null,							-- connection to tivket table
	tia_infoactivity_id int not null,					-- connection to infoactivity table
	primary key (tia_id) );
	
create table tis (												-- connection table between ticket and infospecifics
	tis_id int not null auto_increment,
	tis_ticket_id int not null,							-- connection to ticket table
	tis_infospecifics_id int not null,					-- connection to infospecifics table
	primary key (tis_id) );
 
 
 
 
/* --------------------------------------------------------- FOREIGN KEYS ------------------------------------------------------------------*/
 
 
 alter table user add constraint user_fk_usertype
            foreign key (user_usertype_id) references usertype(usertype_id) 															-- FK USER --> USERTYPE
			ON DELETE NO ACTION ON UPDATE NO ACTION;
 
 alter table user add constraint user_fk_usergender
			foreign key (user_usergender_id) references usergender(usergender_id)														-- FK USER --> USERGENDER
			ON DELETE NO ACTION ON UPDATE NO ACTION;
 
 alter table user add constraint user_fk_userpasswords
			foreign key (user_userpasswords_id) references userpasswords(userpasswords_id)											-- FK USER --> USERPASSWORDS
			ON DELETE NO ACTION ON UPDATE NO ACTION; 
 
 alter table userstatistics add constraint userstatistics_fk_user
			foreign key (userstatistics_user_id) references user(user_id)																-- FK USERSTATISTICS --> USER
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table ut add constraint ut_fk_userreq
			foreign key (ut_userreq_id) references user(user_id)																		-- FK UT --> USER
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table ut add constraint ut_fk_userval
			foreign key (ut_userval_id) references user(user_id)																		-- FK UT --> USER
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table ut add constraint ut_fk_ticket
			foreign key (ut_ticket_id) references ticket(ticket_id)																	-- FK UT --> TICKET
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table ticket add constraint ticket_fk_ticketstatus
			foreign key (ticket_ticketstatus_id) references ticketstatus(ticketstatus_id)											-- FK TICKET --> TICKETSTATUS
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table iis add constraint iis_fk_info 
			foreign key (iis_info_id) references info(info_id)																		-- FK IIS --> INFO
			ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table iis add constraint iis_fk_infospecifics
			foreign key (iis_infospecifics_id) references infospecifics(infospecifics_id)											-- FK IIS --> INFOSPECIFICS
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table iia add constraint iia_fk_info
			foreign key (iia_infoactivity_id) references infoactivity(infoactivity_id)												-- FK IIA --> INFO
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table iia add constraint iia_fk_infoactivity
			foreign key (iia_infoactivity_id) references infoactivity(infoactivity_id)												-- FK IIA --> INFOACTIVITY
			ON DELETE NO ACTION ON UPDATE NO ACTION;
	
alter table tia add constraint tia_fk_ticket
			foreign key (tia_ticket_id) references ticket(ticket_id)																	-- FK TIA --> TICKET
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table tia add constraint tia_fk_infoactivity
			foreign key (tia_infoactivity_id) references infoactivity(infoactivity_id)												-- FK TIA --> INFOACTIVITY
			ON DELETE NO ACTION ON UPDATE NO ACTION;
		
alter table tis add constraint tis_fk_ticket
			foreign key (tis_ticket_id) references ticket(ticket_id)																	-- FK TIS --> TICKET
			ON DELETE NO ACTION ON UPDATE NO ACTION;
			
alter table tis add constraint tis_fk_infospecifics
			foreign key (tis_infospecifics_id) references infospecifics(infospecifics_id)											-- FK TIS -->INFOSPECIFICS
			ON DELETE NO ACTION ON UPDATE NO ACTION;

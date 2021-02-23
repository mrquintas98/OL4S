SET FOREIGN_KEY_CHECKS = 0;

drop table user;
drop table userstatistics;
drop table usertype;
drop table usergender;
drop table userpasswords;
drop table ticket;
drop table ticketstatus;
drop table info;
drop table infospecifics;
drop table infoactivity;
drop table ut;
drop table iis;
drop table iia;
drop table tia;
drop table tis;

SET FOREIGN_KEY_CHECKS = 1;



drop view userandpassword;
drop view basicuserinfo;
drop view ticketinfo;
drop view reqticketinfo;
drop view infosearchspecifics;
drop view infosearchactivity;
drop view infosearch;
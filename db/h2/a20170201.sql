USE keyspaceC;

/* Drop Tables */

DROP TABLE M_TAG_RELATION;

/* Create Tables */

CREATE TABLE IF NOT EXISTS keyspaceC.M_TAG_RELATION
(
	tag_id int  ,
	tag_name text ,
	parent_tag_id int,
	attibute text ,
	color text ,
	target_id text ,
	PRIMARY KEY (tag_id)
);




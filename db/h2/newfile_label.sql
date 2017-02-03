
/* Drop Tables */

DROP TABLE M_LABEL;




/* Create Tables */

-- ラベルテーブル
CREATE TABLE IF NOT EXISTS keyspaceC.M_LABEL
(
	label_id int ,
	label_name text ,
	parent_label_id int ,
	PRIMARY KEY (label_id)
);





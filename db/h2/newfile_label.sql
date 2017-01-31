
/* Drop Tables */

DROP TABLE M_LABEL;




/* Create Tables */

-- ラベルテーブル
CREATE TABLE M_LABEL
(
	-- ラベルID
	label_id int NOT NULL,
	-- ラベル名称
	label_name varchar(100) NOT NULL,
	-- 親ラベルID
	parent_label_id int DEFAULT 0,
	PRIMARY KEY (label_id)
);




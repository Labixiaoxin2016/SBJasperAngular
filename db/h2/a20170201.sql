USE keyspaceC;

/* Drop Tables */

DROP TABLE M_TAG_RELATION;

/* Create Tables */

-- タグ付けテーブル
CREATE TABLE IF EXIST M_TAG_RELATION
(
	-- タグID
	tag_id int NOT NULL ,
	-- タグ名称：ラベル名
	tag_name varchar(100) NOT NULL,
	-- 親タグID：階層構造用
	parent_tag_id int DEFAULT 0,
	-- 属性
	attibute varchar(100) NOT NULL,
	-- 色：色の名前なのか、独自色コードなのか、RGBの色コードなのか？
	color varchar(100) NOT NULL,
	-- タグ付け対象識別コード：各種情報に相当：型は何がベスト？
	target_id varchar(100) NOT NULL,
	PRIMARY KEY (tag_id)
);




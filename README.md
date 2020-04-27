## 社区

## 资料
[spring Document](https://spring.io/guides)

[github OAuth Document](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

## 讲解
dto主要是用来网络传输的模型

## sql  

```sql
create table question(
	id int PRIMARY key auto_increment,
	title VARCHAR(50),
	description text,
	gmt_creaet BIGINT,
	gmt_modified BIGINT
	creator INT.
	comment_count int DEFAULT(0),
	view_count int DEFAULT(0),
	like_count int DEFAULT(0),
	tag VARCHAR(256)
)
```




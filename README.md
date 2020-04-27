## 社区

## 资料
[spring Document](https://spring.io/guides)

[github OAuth Document](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[lombok](https://projectlombok.org/)

**如何要使用lombok需要idea安装对应的lombok插件，不然无法智能提示并且报set和get的错误**

## 讲解
dto主要是用来网络传输的模型

## sql  

```sql
// 创建 questin数据库
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
// 为user表添加字段
alter TABLE user ADD avatar_url VARCHAR(256);
```




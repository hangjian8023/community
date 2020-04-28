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

## 问题总结
1. textarea使用th:value不能回显
    - 需要使用th:text
2. fastjson可以自动把下划线映射到驼峰的属性
    - 如avatar_url可以直接写成avatarUrl
3. h2数据库是什么和链接异常的处理
    - h2数据库是直接通过文件的方式进行存储的
4. 错误提示没有的时候发布按钮飘动到了左边
    - 在里层在添加一个div
6. idea默认没有安装lombok插件
    - 在setting中plugins添加lombok插件
7. 提效chrome插件介绍
    - 




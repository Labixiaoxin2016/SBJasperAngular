# SBJasperAngular

Spring Framework（Spring Boot）を使った RestでJPAなサンプル

+ フロントエンドには、HTML5,CSS3,jQuery,Bootstrap,AngularJS,Thymleaf を使用
+ 帳票ツールに、JasperReports使用
+ DBにcassandraを使用

## 採用している技術

+ Spring Boot,
+ Spring MVC,
+ Spring Security,
+ Spring Data,
+ Spring Data JPA,
+ Spring Data Rest,
+ Spring Data Cassandra,
+ Thymleaf,
+ AngularJS,
+ Bootstrap,
+ JasperReports

## データベース

+ hsqldb → experiment_1_1　にて廃止
+ h2 → experiment_1_1　から採用
+ mysql
+ cassandra → experiment_1、experiment_1_1

## 開発環境

|key|value|
|:----|----:|
|OS|Windows 10,Windows 7 64bit|
|IDE|pleiades-e4.5|
|java|1.8|
|仮想基盤|VirtualBox 5.0.24|




## version

spring-boot-starter-parent

|artifactId/properties|version|
|:-----------|------------:|
|spring-boot-starter-parent|1.4.0.RELEASE|
|java.version|1.8|

依存モジュールのバージョンは、基本的に「spring-boot-starter-parent」のバージョンによって自動的に管理されます。

## dependencies

|groupId|artifactId|version/scope/optional|
|:-----------|------------:|------------:|
|org.springframework.boot|spring-boot-starter-data-cassandra||
|org.springframework.boot|spring-boot-starter-data-rest||
|org.flywaydb|flyway-core||
|org.springframework.boot|spring-boot-starter-jdbc||
|org.springframework.boot|spring-boot-starter-security||
|org.springframework.boot|spring-boot-starter-thymeleaf||
|org.springframework.boot|spring-boot-starter-web||
|org.springframework.boot|spring-boot-devtools|runtime|
|org.hsqldb|hsqldb|runtime|
|mysql|mysql-connector-java|runtime|
|org.projectlombok|lombok|true|
|org.springframework.boot|spring-boot-starter-test|test|


## MySQL 対応

MySQLを使う場合は、MySQLサーバを用意
（※デフォルトでは h2 を使うためあえて利用しなくてもいいものです。）

```
$ docker create --name sbjasperangular-storage hidetarou2013/mysql-storage
$ docker run --volumes-from sbjasperangular-storage --name sbjasperangular-server -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysqladmin -e MYSQL_USER=kenshuu -e MYSQL_PASSWORD=kenshuu -e MYSQL_DATABASE=sbjasperangular -d hidetarou2013/mysql-server:BASE

```

### NAPT設定

指定のポートをVirtualBoxのネットワークアダプターの設定にて、ポートフォワードしてください。

|HostIP|HostPort|GuestIP|GuestPort|
|:-----------|------------:|------------:|------------:|
|127.0.0.1|3306||3306|

## Cassandra対応

### Cassandraサーバを用意

前提として、Cassandraサーバを用意してください。
以下で用意できます。

```
$ sudo systemctl start firewalld
$ docker run --name cassandra_2_1_16 -d -p 7000:7000 -p 7199:7199 -p 9042:9042 -p 9160:9160 cassandra:2.1.16
$ sudo systemctl stop firewalld
```

### NAPT設定

指定のポートをVirtualBoxのネットワークアダプターの設定にて、ポートフォワードしてください。

|HostIP|HostPort|GuestIP|GuestPort|
|:-----------|------------:|------------:|------------:|
|127.0.0.1|7000||7000|
|127.0.0.1|7199||7199|
|127.0.0.1|9042||9042|
|127.0.0.1|9160||9160|

### キースペースを作成

今回のデフォルトキースペースは、keyspaceC　になります。

eclipseからは、ToolCreateCassandraKeyspace
を起動して作成可能です。

もしくは、直接Cassandraサーバにログインし、cqlsh にて作成します。

```
$ docker-enter cassandra_2_1_16

# cqlsh
> CREATE KEYSPACE keyspaceC WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
> use keyspaceC;
> describe tables;
> exit

# nodetool -h 127.0.0.1 flush
```


### create columnfamily memobox


```
$ docker cp database_creation_keyspaceC.cql cassandra_2_1_16:/tmp/
$ docker-enter cassandra_2_1_16

# cqlsh -f /tmp/database_creation_keyspaceC.cql
# nodetool -h 127.0.0.1 flush
```

## Applicationビルド＆起動

### Maven Build

```
mvn compile package
```

### Spring Boot run

```
mvn spring-boot:run
```

## or Java kick

```
$ java -jar target/sbjasperangular-0.0.1-SNAPSHOT.jar
```

### Application URL

http://localhost:8080/


### Rest Service

```
$ curl http://localhost:8080/rest/city
$ curl http://localhost:8080/rest/citycountry
$ curl http://localhost:8080/rest/citycountry2
$ curl http://localhost:8080/rest/rest_resource_citycountry -i -XGET
$ curl http://localhost:8080/rest/cassandra/memobox -i -XGET
$ curl http://localhost:8080/rest/cassandra/person -i -XGET
```

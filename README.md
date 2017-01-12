# SBJasperAngular 

## 採用している技術

Spring Boot, 
Security, 
REST, 
Thymleaf, 
AngularJS, 
Bootstrap, 
JasperReports 
JPA

## version

spring-boot-starter-parent

|artifactId/properties|version|
|:-----------|------------:|
|spring-boot-starter-parent|1.4.0.RELEASE|
|java.version|1.8|

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


## Cassandra対応

### Cassandraサーバを用意

前提として、Cassandraサーバを用意してください。
以下で用意できます。

```
sudo systemctl start firewalld
docker run --name cassandra_2_1_16 -d -p 7000:7000 -p 7199:7199 -p 9042:9042 -p 9160:9160 cassandra:2.1.16
sudo systemctl stop firewalld
```

### キースペースを作成

ToolCreateCassandraKeyspace
を起動してください。

### Spring Boot run

```
mvn spring-boot:run
```





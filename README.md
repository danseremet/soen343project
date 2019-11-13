### Development Setup
1. Get Intellij Ultimate Edition

2. Import salonapp as maven project
- Set to import maven projects automatically
- Java version >= 8
- Add lombok plugin to Intellij
- 

3. Install Postgresql\
Linux: follow this carefully
https://wiki.postgresql.org/wiki/Apt


##### Postgres Database setup:
**Note**: user, user password, database name, everything is salonapp\
sudo adduser --interactive\
name: salonapp\
password: salonapp\

sudo -u postgres psql               \
postgres=# create database mydb;    \
postgres=# create user salonapp with encrypted password 'salonapp'; \
postgres=# grant all privileges on database mydb to salonapp;




**_<== Веб-приложение, ориентированное на удобное взаимодействие с базой данных небольшого компьютерного магазина ==>_<br /><br />**

**Установка под Windows**
1. Склонируйте данный проект из репозитория

2. Загрузите и установите последнюю доступную версию СУБД MySql.<br />
Скачать: https://dev.mysql.com/downloads/

3. После установки СУБД MySql запустите скрипт создания и заполнения базы данных `computer_store_db.sql`, 
введя в Mysql Command Line Client следующую команду:<br />
`mysql> source путь_до_приложения\ComputerStore\computer_store_db.sql;`

4. Загрузите и распакуйте zip-архив с контейнером сервлетов Apache Tomcat, внутри которого будет работать приложение.<br />
Скачать: https://tomcat.apache.org/download-90.cgi

5. Загрузите и установите сборщик проекта Apache Maven.<br />
Скачать: https://maven.apache.org/download.cgi<br />
Инструкция по установке: https://github.com/Flibberty-GEA/blog/wiki/03.a-Как-установить-Maven-на-Windows-10

6. Используя любой текстовый редактор, откройте файл `ComputerStore\src\main\java\com\equrence\db_connection\JdbcManagerImpl.java`
и измените значения переменных USER и PASSWORD на указанные при установке в СУБД Mysql:<br />
`private static final String USER = "имя_пользователя_бд";`<br />
`private static final String PASSWORD = "пароль_к_бд";`

7. Запустите командную строку в корне проекта и введите команду `mvn package`,
затем перейдите в сгенерированную maven'ом директорию `target`, скопируйте оттуда файл `ComputerStore-1.0-SNAPSHOT.war`
и вставьте его в папку `webapps` ранее установленного контейнера сервлетов Tomcat.

8. Запустите Tomcat с помощью файла `\bin\startup.bat` и перейдите в браузере по адресу `localhost:8080/ComputerStore-1.0-SNAPSHOT`.

9. Войдите под ролью администратора (полный доступ) в приложение:<br />
ID: 101<br />
Пароль: 123qwe (пароль для всех сгенерированных с помощью sql-скрипта ролей одинаковый)



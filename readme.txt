Используются технологии:
Spring-MVC 4.3.12.RELEASE
Spring-JDBC 5.0.0.RELEASE
Jackson-2.9.2
Maven-3.5.0 (compiler-plugin for java 1.7)
Tomcat-8.5.231
Servlet-api 2.5
HikariCP-java7 2.4.13
MySQL (connector/j 6.0.6)

Проблемы:
1) hikari не коннектится с базой
пробовал напрямую без hikari - работает
2) зачем доп. слой dto? в чем отличие ItemEntity от Item?

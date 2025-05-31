# University Management Application

**Автор:** Лученко Олександр 

**Група:** АІ-222 (НУОП)

**Варіант:** 4 


## Опис проєкту

Цей проєкт є веб-додатком для управління університетськими даними, такими як студенти, курси та зарахування.Додаток побудований на основі Spring Boot із автентифікацією через JWT та логуванням через ELK-стек. Проєкт розгорнутий у хмарі на платформі Render і підтримує REST API для взаємодії з користувачами.

---

## Що було реалізовано

### REST API:
- **Реєстрація користувача:** `POST /api/auth/register`
- **Автентифікація:** `POST /api/auth/login` (повертає JWT-токен)
- **Управління студентами:** `POST /students` (додавання студента)
- **Управління курсами та зарахуваннями:** ендпоінти `/courses`, `/enrollments`

### Автентифікація та безпека:
- Використання JWT для захисту ендпоінтів
- Spring Security для управління доступом

### База даних:
- Використання PostgreSQL із таблицями: `app_user`, `student`, `course`, `enrollment`
- Автоматична генерація структури через Hibernate (`spring.jpa.hibernate.ddl-auto=update`)

### Логування:
- Налаштування ELK-стеку (Elasticsearch, Logstash, Kibana)
- Логи доступні локально через Kibana: [http://localhost:5601](http://localhost:5601)

### Деплой:
- Проєкт розгорнутий на Render:  
[https://university-app-4fny.onrender.com](https://university-app-4fny.onrender.com)

---

- **GitHub:** [https://github.com/luchenko04/university-app.git](https://github.com/luchenko04/university-app.git)
- **Деплой:** [https://university-app-4fny.onrender.com](https://university-app-4fny.onrender.com)
- **Логін для тестування:** `apiuser9 / api123`

---

## Технології
- **Spring Boot** (REST API, Security, JPA)
- **PostgreSQL** (база даних)
- **JWT** (автентифікація)
- **ELK Stack** (логування)
- **Docker** (контейнеризація)
- **Render** (деплой)

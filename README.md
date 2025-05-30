# University Management Application

**Автор:** Лученко Олександр 

**Група:** АІ-222 (НУОП)

**Варіант:** 4 


## Опис проєкту

Цей проєкт є веб-додатком для управління університетськими даними, такими як студенти, курси та зарахування.Додаток побудований на основі Spring Boot із автентифікацією через JWT та логуванням через ELK-стек.Проєкт розгорнутий у хмарі на платформі Render і підтримує REST API для взаємодії з користувачами.

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
  👉 [https://university-app-4fny.onrender.com](https://university-app-4fny.onrender.com)

---

## Як протестувати

### Через Postman

#### Реєстрація користувача:

**POST** `https://university-app-4fny.onrender.com/api/auth/register`  
```json
{
  "username": "apiuser9",
  "password": "api123"
}
```

#### Логін:

**POST** `https://university-app-4fny.onrender.com/api/auth/login`  
{
  "username": "apiuser9",
  "password": "api123"
}
```
**Відповідь:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

#### Додавання студента:

**POST** `https://university-app-4fny.onrender.com/students`  
**Headers:**
```
Authorization: Bearer <токен_з_логіну>
```
**Тіло:**
```json
{
  "name": "Test Deploy",
  "email": "pochta@gmail.com",
  "groupName": "AI-222"
}
```

---

### Через браузер

1. Відкрийте: [https://university-app-4fny.onrender.com/login](https://university-app-4fny.onrender.com/login)
2. Увійдіть: **apiuser9 / api123**
3. Перевірте доступ до сторінок ( `/home` `/register` `/login`)

---

## Важлива інформація

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

---

## Висновок

Проєкт виконано відповідно до вимог варіанту. Реалізовано функціонал управління університетськими даними, автентифікацію, логування та деплой у хмарі.  

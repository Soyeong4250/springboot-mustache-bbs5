# Spring Boot & Mustache를 이용한 병원 게시판

## 🛠 Dev Tool & Stack

- IntelliJ IDEA  2022.2.3
  - Spring Boot
  - JPA 
  - Spring Security
  - Spring Security Test
  - JWT
  - Lombok
  - MySQL Driver
- MySql 8.0
- Talend API Tester

<br />

<br />

### 🧩 IE 다이어그램

---

![hospital-visit.drawio](./assets/hospital-visit.drawio.png)

<br />

<br />

### 💻 구현 기능

---

|         기능         |          EndPoint          |  ex  |
| :------------------: | :------------------------: | :--: |
| 게시글 상세정보 조회 | GET /api/v1/articles/{id}  |      |
|     게시글 등록      |   POST /api/v1/articles    |      |
|  병원 상세정보 조회  | GET /api/v1/hospitals/{id} |      |
|                      |                            |      |


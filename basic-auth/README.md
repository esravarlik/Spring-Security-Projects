### Spring Boot basic-auth

This endpoint can be accessed without authorization.  
**Authorization Type:** Inherit auth from parent postman

Request:
```http
GET http://localhost:8080/api/public
```
Response: 200 OK
```json
"Hello -public-"
```
This endpoint can be accessed without authorization.  
**Authorization Type:** Inherit auth from parent postman

Request:
```http
POST http://localhost:8080/api/create
```
Response: 200 OK
```json
{
  "id": 1,
  "email": "user@gmail.com",
  "role": "USER"
}
```
Response: 200 OK
```json
{
  "id": 2,
  "email": "admin@gmail.com",
  "role": "ADMIN"
}
```
USER and ADMIN role can access.  
**Authorization Type:** Basic Auth
- Username: user@gmail.com
- Password: password  
          OR  
- Username: admin@gmail.com
- Password: password

Request:
```http
GET http://localhost:8080/api/user
```
Response: 200 OK
```json
"Role: user"
```
Only ADMIN role can access.  
**Authorization Type:** Basic Auth
- Username: admin@gmail.com
- Password: password  

Request:
```http
GET http://localhost:8080/api/admin
```
Response: 200 OK
```json
"Role: admin"
```



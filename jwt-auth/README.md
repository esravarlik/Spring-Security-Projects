### Spring Boot jwt-auth

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
ADMIN Request:  
``` json
{
    "username":"alp",
    "password": "pass"
}
```
```http
POST http://localhost:8080/api/auth/login
```
Response: 200 OK
```json
{
  "accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbHAiLCJpc3MiOiJqb2pvIiwiZXhwIjoxNjY5MzkyMzA2fQ.cmoLo-oWBj47ozxPP1pxX7m-q6uODaIzAPwRUXNHxro",
  "user": {
    "username": "alp",
    "role": "ADMIN",
    "id": 1
  }
}
```
USER Request:  
```
{
"username":"alperen",
"password": "pass"
}
```
```http
POST http://localhost:8080/api/auth/login
```
Response: 200 OK
```json
{
  "accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbHBlcmVuIiwiaXNzIjoiam9qbyIsImV4cCI6MTY2OTM5Mjc3NX0.xpZkB10ebPsOW5PRzUvMFnLIxG7JqpseNKM-kACAXjM",
  "user": {
    "username": "alperen",
    "role": "USER",
    "id": 2
  }
}
```
Only ADMIN role can access.
**Authorization Type:** Bearer Token  
ADMIN Token Example: ```"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
eyJzdWIiOiJhbHAiLCJpc3MiOiJqb2pvIiwiZXhwIjoxNjY5MzkyMzA2fQ.
cmoLo-oWBj47ozxPP1pxX7m-q6uODaIzAPwRUXNHxro"```

Request:  
```http
GET http://localhost:8080/api/admin
```
Response: 200 OK  
```json
"Role: Admin"
```
USER or ADMIN role can access.  
**Authorization Type:** Bearer Token  
USER Token Example: ```"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
eyJzdWIiOiJhbHAiLCJpc3MiOiJqb2pvIiwiZXhwIjoxNjY5MzkyMzA2fQ.
cmoLo-oWBj47ozxPP1pxX7m-q6uODaIzAPwRUXNHxro"```

Request:
```http
GET http://localhost:8080/api/user
```
Response: 200 OK
```json
"Role: User"
```
This endpoint can be accessed without authorization.  
**Authorization Type:** Inherit auth from parent postman
Request:
```http
GET http://localhost:8080/api/products/getAll
```
Response: 200 OK
```json
[
  {
    "id": 1,
    "productName": "HatayDurum",
    "unitPrice": 45.0,
    "unitsInStock": 50
  },
  {
    "id": 2,
    "productName": "Ayran",
    "unitPrice": 4.0,
    "unitsInStock": 50
  }
]
```
Only ADMIN role can access.
**Authorization Type:**  Bearer Token  
Token: ``eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbHAiLCJpc3MiOiJqb2pvIiwiZXhwIjoxNjY5Mzk1NDY1fQ.LkrCv1mjwwgk5dMfgmHGTJ_iyeb19lDE9TguFgxV9HQ``
Request:
```http
GET http://localhost:8080/api/products/getByProductName/Ayran
```
Response: 200 OK
```json
{
    "id": 2,
    "productName": "Ayran",
    "unitPrice": 4.0,
    "unitsInStock": 50
}
```

Only ADMIN role can access.
**Authorization Type:**  Bearer Token  
Token: ``eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbHAiLCJpc3MiOiJqb2pvIiwiZXhwIjoxNjY5Mzk1NDY1fQ.LkrCv1mjwwgk5dMfgmHGTJ_iyeb19lDE9TguFgxV9HQ``
Request:
```http
GET http://localhost:8080/api/products/getByProductName/Ayran
```
Response: 200 OK
```json
{
    "id": 2,
    "productName": "Ayran",
    "unitPrice": 4.0,
    "unitsInStock": 50
}
```
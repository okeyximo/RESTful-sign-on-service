## RESTful sign-on service (API)

A RESTful sign-on service for authenticating vendors
on a payment processing system.
A merchant has the following details: Company Name, Address, business type, Email, Phone Number,
bank account details.
The result of this activity is that :

1. A merchant should be able to sign up to create a profile.
2. A merchant should be able to log in and be assigned a security mechanism for accessing the wider payment processing
   system - This should be a set of Custom Security Headers with or without encryption
3. A merchant should be able to update profile information in real-time.

### Tools

* Spring Boot
* PostgreSQL
* Git
* Spring Data JPA
* JUnit/Mockito
* Spring Security

---

### Testing the API endpoints

### Register Merchant

* Endpoint: `http://localhost:8081/api/v1/register`

### Payload

```
curl --location --request POST 'http://localhost:8081/api/v1/register' \
--header 'Content-Type: application/json' \
--data-raw '{
"accountNumber": "0025582649",
"companyName": "Decagon Engineering",
"phoneNumber": "08065788379",
"address": "7 Asanjo way, Sangotedo Lagos",
"businessType": "Information Technology",
"email": "okey.onwuchekwa@gmail.com",
"password": "@ABC1bc123"
}'
```
### Response

```json
{
    "message": "success",
    "timeStamp": "2022-10-27T07:34:31.991299",
    "data": {
        "id": 1,
        "companyName": "Decagon Engineering",
        "phoneNumber": "08065788379",
        "address": "7 Asanjo way, Sangotedo Lagos",
        "email": "okey.onwuchekwa@gmail.com",
        "accountNumber": "0025582649"
    }
}
```
### Login

* Endpoint: `http://localhost:8081/api/v1/auth/login`

### Payload

```
curl --location --request GET 'http://localhost:8081/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
"email": "okey.onwuchekwa@gmail.com",
"password" : "@ABC1bc123"
}'
```

### Response 

```json
{
    "message": "Success",
    "timeStamp": "2022-10-27T07:47:17.589771",
    "data": {
        "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJva2V5Lm9ud3VjaGVrd2FAZ21haWwuY29tIiwiZXhwIjoxODQ2ODUzMjM3LCJpYXQiOjE2NjY4NTMyMzd9.ryLzTtgT1MO_TVlrwMtlE5JmFTDYXWPxR2SfASgs12uiV0ObvhK5nKkgCqqFc-QKFvFH-dnQRPFFZJINtrrMOQ",
        "id": 1,
        "companyName": "Decagon Engineering",
        "email": "okey.onwuchekwa@gmail.com",
        "phoneNumber": "08065788379",
        "businessType": "Information Technology"
    }
}
```

# Update Merchant 

* Endpoint: ``

### Payload

```
curl --location --request PUT 'http://localhost:8081/api/v1/update' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJva2V5Lm9ud3VjaGVrd2FAZ21haWwuY29tIiwiZXhwIjoxODQ2ODUzMjM3LCJpYXQiOjE2NjY4NTMyMzd9.ryLzTtgT1MO_TVlrwMtlE5JmFTDYXWPxR2SfASgs12uiV0ObvhK5nKkgCqqFc-QKFvFH-dnQRPFFZJINtrrMOQ' \
--header 'Content-Type: application/json' \
--data-raw '{
    "companyName" : "SystemSpecs Deelaa",
    "address" : "25b VI, Lekki, Lagos",
    "password" : "@Computer657890",
    "accountNumber" : "0025582649"
    
}'

```

### Response 

```json
{
    "message": "success",
    "timeStamp": "2022-10-27T07:56:08.316358",
    "data": {
        "id": 1,
        "companyName": "SystemSpecs Deelaa",
        "phoneNumber": "08065788379",
        "address": "25b VI, Lekki, Lagos",
        "email": "okey.onwuchekwa@gmail.com",
        "accountNumber": "0025582649"
    }
}
```


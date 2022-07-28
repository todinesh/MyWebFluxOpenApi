
--Create
curl --location --request POST 'http://localhost:8080/api/v1/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": null,
    "firstName": "John",
    "lastName": "Doe"
}'


--Get all
curl --location --request GET 'http://localhost:8080/api/v1/customer'

--Get one
curl --location --request GET 'http://localhost:8080/api/v1/customer/Doe'


-Put
curl --location --request PUT 'http://localhost:8080/api/v1/customer/Doe' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": null,
    "firstName": "John",
    "lastName": "Doe"
}'

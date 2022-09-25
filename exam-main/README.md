# exam

Request 1
http://localhost:8080/data/addAll
POST
--------------------------
Request 2
http://localhost:8080/cart/addCart
POST
{
"name":"cart1",
"productId": ["1","2"]
}

---------------------------
Request 3
http://localhost:8080/cart/populateAmount
POST
{
"cartId":"7ed61654-3130-4695-b213-60b6e023724a",
"cardType": "Normal"
}
---------------------------
Request 4
http://localhost:8080/cart/deleteOrder/?
DELETE
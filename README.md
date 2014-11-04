PhoneBook
=========

Simple REST service eample(Java, Spring, javax.ws.rs, MongoDB, maven )

Run:
--------------
Run MongoDB on port 27017
Deploy phoneBook.war to the servlet container (I used Apache Tomcat)
(if you run MongoDB on another host or port change phonebook-context.xml file)

Methods:
--------------

**Create new contact
-method: POST
-mime type: application/json
-request example: http://localhost:8080/phoneBook/json/createContact
-body example: {"address":"Dnepropetrovsk","name":"Mariia","localPhone":"+380933423403","intPhone":"+995595080080"}
-response example:{"status":"OK","contacts":null,"errorText":null}

**Update contact by id 
-method: POST
-mime type: application/json
-request example: http://localhost:8080/phoneBook/json/updateContact
-body example: {"address":"Kiev","id":1982743853} (id is requred, at least one of address, name, localPhone, intPhone is requred)
-response example:{"status":"OK","contacts":null,"errorText":null}

**Delete contact by id
-method: GET
-request params: id - contact id
-request example: http://localhost:8080/phoneBook/json/deleteContact?id=1982743853
-response example:{"status":"OK","contacts":null,"errorText":null}

**Get all contacts
-request example:
-method: GET
-request example: http://localhost:8080/phoneBook/json/getAll
-response example:{"status":"OK","contacts":[{"address":"Dnepropetrovsk","name":"Mariia","id":2077334640,"localPhone":"+380933423403","intPhone":"+995595080080"},{"address":"Kiev","name":"Mariia","id":2077939121,"localPhone":"+3805555555","intPhone":"+995595080080"}],"errorText":null}

**Get contact by name
-method: GET
-request params: name - contact name
-request example: http://localhost:8080/phoneBook/json/getByName?name=Mariia
-response example:
{"status":"OK","contacts":[{"address":"Dnepropetrovsk","name":"Mariia","id":1982743853,"localPhone":"+380933423403","intPhone":"+995595080080"}],"errorText":null}



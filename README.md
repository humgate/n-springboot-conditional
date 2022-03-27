Springboot application demonstrating conditional creation of bean, depending
on property value specified in application properties file.

Implemented application tests using test container and TestRestTemplate.
The test need prebuilt docker images named "devapp" and "prodapp", each one containing 
appropriately configured application properties "server" and "profile"  
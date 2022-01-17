# CurrencyCalculator
Application itself provides ability to convert currency rates, from rate -> to rate

To test the application we need 
1) clone the application from git repository
2) create in Intellij IDEA (for example) MySql connection named 'currencycalc' 
3) run spring boot application (the database 'currencycalc' will created automatically )
4) run all tests in currencyCalculatorApplicationTest class (db tables will be filled with test information)

 * Now we need to get jwt authentication token 
 for this purpose use any API platform like 'postman'.
 
5) Send a POST request to URI localhost:8081/api/v1/auth/login  with JSON body like {"username":"your_username", "password":"your_password"} (the credentials of user are in table users that we filled in step 4, password will be encrypted, therefor see the password in currencyCalculatorApplicationTest class )
response will contain roles, username and jwt token for user

 * Now we are authenticated and we have access to URI -s in application  if we add request header Authorization and value Bearer_<token> according on Spring Security configuration 

* To access any controllers in application which are avaliable  for roles of our user (see the spring security configuration in org.mygroup.springSecurity.config.securityConfig class) we can send with request header 'Authorization' our token (Bearer_<token>).

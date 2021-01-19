# account-rest-service

Quick assignment from Michael Daniaux done the 17th of january 2021

My goal was to show that it was easy for me to use :
Spring Boot Starters so that way all our maven depencies are managed
Spring Boot Application and configuration (application.properties)
Rest-services : Spring Web - Spring MVC
Spring design patterns : Controller - Services - Repository
MockMvc : for the unit tests
Embedded H2 SQL database : schema and data load from data.sql
JdbcTemplate and RowMapper to retrieve the data from the db
Exception management : 400 or 500 are properly returned when exceptions
Logging is also included

I did not spend time to do all the Assertions in the Unit tests by choice, I am still working for a client, so limited time available. The important is to show that I can do it...

I made the assumptions that 
- TODAY is current time stamp minus 1 day
- 7DAYS is current time stamp minus 7 days
- MONTH current time stamp minus 1 month

Also points 2 and 3 are done by the same method by the use of "Optional"

Only HTTP.GET methods are implemented as http params are small

If we are to retrieve lots of data in responses, we should use a paging system : 
- params : page number and page size
- response : add some metada like page number, page size, total items, total pages

I am sure I miss few things...

MD

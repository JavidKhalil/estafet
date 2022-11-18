# estafet
Task management project 

Avialable endpoints 


Returns all tasks 
GET /tasks

Returns task by id 
GET /task/{id} 

Create a task 
POST /add

Deletes a task by id 
DELETE /remove/{id}

Update the task by Task 
PUT /update

Database instace provided via docker. We use postgres (13 version). 
Run docker-compose in root of the project. 

Tests should be run after project is started 

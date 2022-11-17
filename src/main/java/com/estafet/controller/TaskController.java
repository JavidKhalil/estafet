package com.estafet.controller;

import com.estafet.domain.Task;
import com.estafet.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks")
    public List<Task> findAll(){
       return taskService.findAll();
    }

    @GetMapping(value = "/task/{id}")
    public Task findById(@PathVariable("id") Long id){
        return taskService.findById(id);
    }

    @PostMapping(value = "/add")
    public Task createTask(@RequestBody Task task) {
       return taskService.createTask(task);
    }

    @DeleteMapping(value = "/remove/{id}")
    public Boolean removeTask(@PathVariable("id") Long id) {
        return taskService.deleteTask(id);
    }

    @PutMapping(value = "/update")
    public String updateTask(@RequestBody Task task) {
        try {
            taskService.updateTask(task);
        } catch (Exception e) {
            e.printStackTrace(); // TO DO LOGGER
            return e.getMessage();
        }
        return null;
    }

}

package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    
    @Autowired
    private ToDoService todoService;


    @GetMapping
    public List<ToDo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return todoService.getToDoById(id)
            .orElseThrow(() -> new RuntimeException("ToDo not found."));
    }
    
    @PostMapping
    public ToDo postMethodName(@RequestBody ToDo todo) {
        return todoService.createToDo(todo);
    }
    
    @PutMapping("/{id}")
    public ToDo putMethodName(@PathVariable Long id, @RequestBody ToDo todo) {
        return todoService.updateToDo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id){
        todoService.deleteToDo(id);
    }
    
}

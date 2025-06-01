package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository todoRepo;

    public List<ToDo> getAllTodos(){
        return todoRepo.findAll();
    }

    public Optional<ToDo> getToDoById(Long id){
        return todoRepo.findById(id);
    }

    public ToDo createToDo(ToDo todo){
        return todoRepo.save(todo);
    }

        public void deleteToDo(Long id) {
        todoRepo.deleteById(id);
    }

    public ToDo updateToDo(Long id, ToDo updatedTodo){
        return todoRepo.findById(id).map(toDo -> {
            toDo.setTitle(updatedTodo.getTitle());
            toDo.setCompleted(updatedTodo.isCompleted());
            toDo.setDescription(updatedTodo.getDescription());
            toDo.setDueDate(updatedTodo.getDueDate());
            return todoRepo.save(toDo);
        }).orElseThrow(() -> new RuntimeException("ToDo not found."));
    }
}

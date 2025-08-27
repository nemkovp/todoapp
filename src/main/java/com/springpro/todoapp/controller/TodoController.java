package com.springpro.todoapp.controller;

import com.springpro.todoapp.model.TodoItem;
import com.springpro.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String index(Model model){

        todoRepository.save(new TodoItem("Pavel"));
        todoRepository.save(new TodoItem("Lisa"));

        List<TodoItem> allTodos = todoRepository.findAll();
        model.addAttribute("allTodos",allTodos);

        return "index";
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

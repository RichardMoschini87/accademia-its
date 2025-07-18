package accademia.liguria.its.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accademia.liguria.its.models.Todo;
import accademia.liguria.its.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/lista")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}

package accademia.liguria.its.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accademia.liguria.its.models.Todo;
import accademia.liguria.its.models.TodoComplete;
import accademia.liguria.its.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping("/{idTodo}")
    public Optional<Todo> getTodo(@PathVariable Integer idTodo) {
        return todoService.getTodo(idTodo);
    }
    
    @GetMapping("/lista/completa")
    public List<TodoComplete> getAllCompleteTodos() {
        return todoService.getAllCompleteTodos();
    }

    @GetMapping("/completo/{idTodo}")
    public List<TodoComplete> getTodoComplete(@PathVariable Integer idTodo) {
        return todoService.getTodoComplete(idTodo);
    }

    @PostMapping("/todo")
    public String postMethodName(@RequestBody Todo todo) {
        todoService.saveTodo(todo);
        return "Todo creato con successo";
    }
    
    @DeleteMapping("/{idTodo}")
    public String deleteTodo(@PathVariable Integer idTodo) {
        todoService.deleteTodo(idTodo);
        return "Todo eliminato con successo";
    }

}

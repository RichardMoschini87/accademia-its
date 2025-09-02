package accademia.liguria.its.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import accademia.liguria.its.models.Todo;
import accademia.liguria.its.models.TodoComplete;
import accademia.liguria.its.repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/**
 * Classe di business per la gestione dei toodo.
 */
public class TodoService {

    /**
     * Repository per l'accesso ai dati dei todo.
     */
    private final TodoRepository todoRepository;

    /**
     * Costruttore della classe TodoService.
     * TodoRepository è iniettato tramite il costruttore.
     * usare Autowired per l'iniezione automatica se necessario.
     * 
     * @param todoRepository il repository per l'accesso ai dati dei todo
     */
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        log.info("Recupero tutti i todo dal database");

        try {
            throw new RuntimeException("TEST ERRORE LOG");
        } catch (Exception e) {
            log.error("Si è verificato un errore durante il recupero dei todo", e);
        }

        return todoRepository.findAll();
    }

    public List<TodoComplete> getAllCompleteTodos() {
        log.info("Recupero tutti i todo completi dal database");
        return todoRepository.getAllTodoComplete();
        // return todoRepository.getAllTodoComplete();
    }

    public List<TodoComplete> getTodoComplete(Integer idTodo) {
        log.info("Recupero il todo completo con ID: {}", idTodo);
        return todoRepository.getTodoComplete(idTodo);
    }

    /**
     * Insericse aggiorna il record
     * 
     * @param todo
     */
    public void saveTodo(Todo todo) {
        if (todo.getDescrizione() == null || todo.getDescrizione().isEmpty()) {
            throw new RuntimeException("La descrizione del todo non può essere vuota");
        } else {
            todoRepository.save(todo);
        }
    }

    public void deleteTodo(Integer idTodo) {
        todoRepository.deleteById(idTodo);
    }

    /**
     * 
     * @param idTodo
     * @return
     */
    public Todo getTodo(Integer idTodo) {
        Optional<Todo> todo = todoRepository.findById(idTodo);
        return todo.orElse(new Todo());
    }

}

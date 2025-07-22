package accademia.liguria.its.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import accademia.liguria.its.models.Todo;
import accademia.liguria.its.models.TodoComplete;
import accademia.liguria.its.repositories.TodoRepository;

@Service
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

    public List<Todo> getAllTodos(Integer page) {
         Page<Todo> paginate = todoRepository.findAll(PageRequest.of(page, 3));
        return paginate.getContent();
    }

    public List<TodoComplete> getAllCompleteTodos() {
        return todoRepository.getAllTodoComplete();
        // return todoRepository.getAllTodoComplete();
    }

    public List<TodoComplete> getTodoComplete(Integer idTodo) {
        return todoRepository.getTodoComplete(idTodo);
    }

    /**
     * Insericse aggiorna il record
     * 
     * @param todo
     */
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Integer idTodo) {
        todoRepository.deleteById(idTodo);
    }

    /**
     * 
     * @param idTodo
     * @return
     */
    public Optional<Todo> getTodo(Integer idTodo) {
        return todoRepository.findById(idTodo);
    }

}

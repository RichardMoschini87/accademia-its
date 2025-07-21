package accademia.liguria.its.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accademia.liguria.its.models.Todo;
import accademia.liguria.its.models.TodoComplete;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(nativeQuery = true, value = "SELECT t.id idTodo, t.descrizione descrizioneTodo, p.id idPriorita, p.descrizione descrizionePriorita FROM todo t INNER JOIN priorita p ON t.priorita = p.id")
    public List<TodoComplete> getAllTodoComplete();
    @Query(nativeQuery = true, value = "SELECT t.id idTodo, t.descrizione descrizioneTodo, p.id idPriorita, p.descrizione descrizionePriorita FROM todo t INNER JOIN priorita p ON t.priorita = p.id WHERE t.id = :idTodo")
    public List<TodoComplete> getTodoComplete(@Param("idTodo") Integer idTodo);
}

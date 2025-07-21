package accademia.liguria.its.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoComplete {

    private Integer idTodo;
    private String descrizioneTodo;
    private String idPriorita;
    private String descrizionePriorita;
}

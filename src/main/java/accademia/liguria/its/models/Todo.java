package accademia.liguria.its.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq_gen")
    @SequenceGenerator(name = "todo_seq_gen", sequenceName = "todo_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "priorita")
    private String priorita;

}

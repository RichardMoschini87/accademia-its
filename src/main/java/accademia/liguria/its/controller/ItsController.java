package accademia.liguria.its.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accademia.liguria.its.models.Studente;

@RestController
@RequestMapping("/its")
public class ItsController {

	@GetMapping("/studenti")
	public ResponseEntity<List<Studente>> getRisorsa() {
		List<Studente> reult = new ArrayList<>();

		var st1 = new Studente();
		st1.setNome("Francesco");
		st1.setCognome("Muso");
		st1.setMatricola("V103");

		var st2 = new Studente();
		st2.setNome("Marco");
		st2.setCognome("Cristiano");
		st2.setMatricola("V104");

		var st3 = new Studente();
		st3.setNome("Andrea");
		st3.setCognome("Rossi");
		st3.setMatricola("V105");

		reult.add(st1);
		reult.add(st2);
		reult.add(st3);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reult);
	}

	@GetMapping("/studenti/studente/{matricola}")
	public Studente getRisorsa(@PathVariable String matricola) {
		List<Studente> studenti = new ArrayList<>();

		var st1 = new Studente();
		st1.setNome("Francesco");
		st1.setCognome("Muso");
		st1.setMatricola("V103");

		var st2 = new Studente();
		st2.setNome("Marco");
		st2.setCognome("Cristiano");
		st2.setMatricola("V104");

		var st3 = new Studente();
		st3.setNome("Andrea");
		st3.setCognome("Rossi");
		st3.setMatricola("V105");

		studenti.add(st1);
		studenti.add(st2);
		studenti.add(st3);

		return studenti.stream().filter(f -> f.getMatricola().equals(matricola)).findAny().orElse(null);
	}

	@PostMapping("/studenti/studente")
	public ResponseEntity<Studente> insert(@RequestBody(required = true) Studente studente) {
		return ResponseEntity.ok(studente);
	}

}

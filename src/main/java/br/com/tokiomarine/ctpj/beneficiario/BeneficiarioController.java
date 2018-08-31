package br.com.tokiomarine.ctpj.beneficiario;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@GetMapping("/v1/{id}")
	public ResponseEntity<List<Beneficiario>> listar(@PathVariable Long id) {
		List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
		return !beneficiarios.isEmpty() ? ResponseEntity.ok(beneficiarios) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/v1/items/{id}")
	public ResponseEntity<List<String>> items(@PathVariable Long id) {
		String a = "ITEM 1 - RUA ARTUR PRADO 200, BELA VISTA 01322-000";
		List<String> items = new ArrayList<>();
		items.add(a);
		return !items.isEmpty() ? ResponseEntity.ok(items) : ResponseEntity.noContent().build();
	}
	
	@PostMapping("/v1")
	public ResponseEntity<Beneficiario> cadastra(@Valid @RequestBody Beneficiario beneficiario) {
		Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(beneficiarioSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(beneficiario);
	}
	
	@DeleteMapping("/v1/{id}")
	public ResponseEntity<?> remove(@PathVariable String id) {
		beneficiarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/v1/criar")
	public ResponseEntity<List<Beneficiario>> criar() {
		List<Beneficiario> novos = new ArrayList<>();
		Beneficiario b1 = new Beneficiario(38872538840L, "Fernando Pessoa", new BigDecimal("20"), null, "Complemento", "1");
		novos.add(b1);
		List<Beneficiario> beneficiarios = beneficiarioRepository.saveAll(novos);
		return !beneficiarios.isEmpty() ? ResponseEntity.ok(beneficiarios) : ResponseEntity.noContent().build();
	}
}

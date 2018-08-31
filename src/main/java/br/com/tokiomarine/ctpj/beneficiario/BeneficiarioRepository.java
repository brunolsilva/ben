package br.com.tokiomarine.ctpj.beneficiario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeneficiarioRepository extends MongoRepository<Beneficiario, String> {
	
}

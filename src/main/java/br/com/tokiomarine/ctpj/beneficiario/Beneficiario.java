package br.com.tokiomarine.ctpj.beneficiario;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Beneficiario {
	
	@Id
	private String id;
	private Long numeroCPFCNPJ;
	private String nomePessoa;
	private BigDecimal percentualDistribuicao;
	private BigDecimal valorDistribuicao;
	private String descricaoComplemento;
	private String itemCotacao;
	
	public Beneficiario() {
		
	}
	
	public Beneficiario(Long numeroCPFCNPJ, String nomePessoa, BigDecimal percentualDistribuicao,
			BigDecimal valorDistribuicao, String descricaoComplemento, String itemCotacao) {
		super();
		this.numeroCPFCNPJ = numeroCPFCNPJ;
		this.nomePessoa = nomePessoa;
		this.percentualDistribuicao = percentualDistribuicao;
		this.valorDistribuicao = valorDistribuicao;
		this.descricaoComplemento = descricaoComplemento;
		this.itemCotacao = itemCotacao;
	}

	public Long getNumeroCPFCNPJ() {
		return numeroCPFCNPJ;
	}

	public void setNumeroCPFCNPJ(Long numeroCPFCNPJ) {
		this.numeroCPFCNPJ = numeroCPFCNPJ;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public BigDecimal getPercentualDistribuicao() {
		return percentualDistribuicao;
	}

	public void setPercentualDistribuicao(BigDecimal percentualDistribuicao) {
		this.percentualDistribuicao = percentualDistribuicao;
	}

	public BigDecimal getValorDistribuicao() {
		return valorDistribuicao;
	}

	public void setValorDistribuicao(BigDecimal valorDistribuicao) {
		this.valorDistribuicao = valorDistribuicao;
	}

	public String getDescricaoComplemento() {
		return descricaoComplemento;
	}

	public void setDescricaoComplemento(String descricaoComplemento) {
		this.descricaoComplemento = descricaoComplemento;
	}

	public String getItemCotacao() {
		return itemCotacao;
	}

	public void setItemCotacao(String itemCotacao) {
		this.itemCotacao = itemCotacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
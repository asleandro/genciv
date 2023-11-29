package com.genciv.model;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	private String obraOrcada;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco enderecoObra;

	private double valorMaterialTotal;
	private double valorServicoTotal;
	private String prazoPagamentoMaterial;
	private String prazoPagamentoServico;
	private Boolean ativo;
	private Boolean aprovado;

	@Column(name = "codigo_aprovacao")
	private String codigoAprovacao;

	@OneToMany(mappedBy = "orcamento", fetch = FetchType.EAGER)
	@Cascade(CascadeType.PERSIST)
	private List<ServicoOrcado> servicosOrcados;

	public Orcamento() {
		this.codigoAprovacao = UUID.randomUUID().toString();
	}

	public List<ServicoOrcado> getServicosOrcados() {
		return servicosOrcados;
	}

	public void setServicosOrcados(List<ServicoOrcado> servicosOrcados) {
		this.servicosOrcados = servicosOrcados;
	}

	public void aprovarOrcamento() {
		this.aprovado = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObraOrcada() {
		return obraOrcada;
	}

	public void setObraOrcada(String obraOrcada) {
		this.obraOrcada = obraOrcada;
	}

	public Endereco getEnderecoObra() {
		return enderecoObra;
	}

	public void setEnderecoObra(Endereco enderecoObra) {
		this.enderecoObra = enderecoObra;
	}

	public double getValorMaterialTotal() {
		return valorMaterialTotal;
	}

	public void setValorMaterialTotal(double valorMaterialTotal) {
		this.valorMaterialTotal = valorMaterialTotal;
	}

	public double getValorServicoTotal() {
		return valorServicoTotal;
	}

	public void setValorServicoTotal(double valorServicoTotal) {
		this.valorServicoTotal = valorServicoTotal;
	}

	public String getPrazoPagamentoMaterial() {
		return prazoPagamentoMaterial;
	}

	public void setPrazoPagamentoMaterial(String prazoPagamentoMaterial) {
		this.prazoPagamentoMaterial = prazoPagamentoMaterial;
	}

	public String getPrazoPagamentoServico() {
		return prazoPagamentoServico;
	}

	public void setPrazoPagamentoServico(String prazoPagamentoServico) {
		this.prazoPagamentoServico = prazoPagamentoServico;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String toString() {
		return "Orcamento{" + "id=" + id + ", cliente=" + cliente + ", obraOrcada='" + obraOrcada + '\''
				+ ", enderecoObra=" + enderecoObra + ", valorMaterialTotal=" + valorMaterialTotal
				+ ", valorServicoTotal=" + valorServicoTotal + ", prazoPagamentoMaterial='" + prazoPagamentoMaterial
				+ '\'' + ", prazoPagamentoServico='" + prazoPagamentoServico + '\'' + ", ativo=" + ativo
				+ ", servicosOrcados=" + servicosOrcados + '}';
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public void setStatus(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getCodigoAprovacao() {
		return codigoAprovacao;
	}

	public void setCodigoAprovacao(String codigoAprovacao) {
		this.codigoAprovacao = codigoAprovacao;
	}

}

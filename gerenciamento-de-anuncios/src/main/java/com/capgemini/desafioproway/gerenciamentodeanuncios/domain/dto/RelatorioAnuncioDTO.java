package com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;

public class RelatorioAnuncioDTO {

	private Anuncio anuncio;
	private Double totalInvestido;
	private Integer totalVisualizacoes;
	private Integer totalCliques;
	private Integer totalCompartilhamentos;

	public RelatorioAnuncioDTO() {
	}

	public RelatorioAnuncioDTO(Anuncio anuncio, Double totalInvestido, Integer totalCliques,
			Integer totalCompartilhamentos, Integer totalVisualizacoes) {
		this.anuncio = anuncio;
		this.totalInvestido = totalInvestido;
		this.totalCliques = totalCliques;
		this.totalCompartilhamentos = totalCompartilhamentos;
		this.totalVisualizacoes = totalVisualizacoes;
	}

	/**
	 * @return the anuncio
	 */
	public Anuncio getAnuncio() {
		return anuncio;
	}

	/**
	 * @param anuncio the anuncio to set
	 */
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	/**
	 * @return the totalInvestido
	 */
	public Double getTotalInvestido() {
		return totalInvestido;
	}

	/**
	 * @param totalInvestido the totalInvestido to set
	 */
	public void setTotalInvestido(Double totalInvestido) {
		this.totalInvestido = totalInvestido;
	}

	/**
	 * @return the totalVisualizacoes
	 */
	public Integer getTotalVisualizacoes() {
		return totalVisualizacoes;
	}

	/**
	 * @param totalVisualizacoes the totalVisualizacoes to set
	 */
	public void setTotalVisualizacoes(Integer totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;
	}

	/**
	 * @return the totalCliques
	 */
	public Integer getTotalCliques() {
		return totalCliques;
	}

	/**
	 * @param totalCliques the totalCliques to set
	 */
	public void setTotalCliques(Integer totalCliques) {
		this.totalCliques = totalCliques;
	}

	/**
	 * @return the totalCompartilhamentos
	 */
	public Integer getTotalCompartilhamentos() {
		return totalCompartilhamentos;
	}

	/**
	 * @param totalCompartilhamentos the totalCompartilhamentos to set
	 */
	public void setTotalCompartilhamentos(Integer totalCompartilhamentos) {
		this.totalCompartilhamentos = totalCompartilhamentos;
	}

}

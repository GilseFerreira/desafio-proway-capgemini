package com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "tbl_anuncio")
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeAnuncio;
	
	private String nomeCliente;
	
	private Double valorInvestidoDia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataTermino;

	public Anuncio() {
	}

	public Anuncio(long id, String nomeAnuncio, String nomeCliente, LocalDate dataInicio, LocalDate dataTermino,
			Double valorInvestidoDia) {
		this.id = id;
		this.nomeAnuncio = nomeAnuncio;
		this.nomeCliente = nomeCliente;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.valorInvestidoDia = valorInvestidoDia;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the dataInicio
	 */
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataTermino
	 */
	public LocalDate getDataTermino() {
		return dataTermino;
	}

	/**
	 * @param dataTermino the dataTermino to set
	 */
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	/**
	 * @return the valorInvestidoDia
	 */
	public Double getValorInvestidoDia() {
		return valorInvestidoDia;
	}

	/**
	 * @param valorInvestidoDia the valorInvestidoDia to set
	 */
	public void setValorInvestidoDia(Double valorInvestidoDia) {
		this.valorInvestidoDia = valorInvestidoDia;
	}
}

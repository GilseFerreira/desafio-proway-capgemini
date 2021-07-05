package com.capgemini.desafioproway.gerenciamentodeanuncios.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto.RelatorioAnuncioDTO;
import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;
import com.capgemini.desafioproway.gerenciamentodeanuncios.exception.ResourcesNotFoundException;

public interface AnuncioService {
	/**
	 * Lista todos anuncios cadastrados
	 * @return
	 */
	public List<Anuncio> listAll();
	
	/**
	 * Busca anuncio por id
	 * @param id
	 * @return
	 */
	public List<Anuncio> findById(Long id);
	
	/**
	 * Busca anuncio pelo nome do cliente
	 * @param cliente
	 * @return
	 */
	public List<Anuncio> findByNomeCliente(String cliente);
	
	/**
	 * Cria um novo anuncio
	 * @param anuncio
	 */
	public void create(Anuncio anuncio);
	
	/**
	 * Apara um anuncio
	 * @param id
	 * @throws ResourcesNotFoundException 
	 */
	public void delete(Long id) throws ResourcesNotFoundException;
	
	/**
	 * Gera relatorio de anuncios 
	 * @param dataInicio
	 * @param dataFim
	 * @param cliente
	 * @return
	 */
	public List<RelatorioAnuncioDTO> buildRelatorio(LocalDate dataInicio, LocalDate dataTermino, String cliente) throws ResourcesNotFoundException;
}

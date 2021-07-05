package com.capgemini.desafioproway.gerenciamentodeanuncios.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto.RelatorioAnuncioDTO;
import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;
import com.capgemini.desafioproway.gerenciamentodeanuncios.exception.ResourcesNotFoundException;
import com.capgemini.desafioproway.gerenciamentodeanuncios.repository.AnuncioRepository;
import com.capgemini.desafioproway.gerenciamentodeanuncios.service.AnuncioService;
import com.capgemini.desafioproway.gerenciamentodeanuncios.service.RelatorioService;

@Service
public class AnuncioServiceImpl implements AnuncioService {

	@Autowired
	AnuncioRepository anuncioRepository;

	@Autowired
	private RelatorioService relatorio;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Anuncio> listAll() {
		return anuncioRepository.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Anuncio> findById(Long id) {
		return anuncioRepository.findAllById(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Anuncio> findByNomeCliente(String nomeCliente) {
		return anuncioRepository.findAllByNomeClienteIgnoreCase(nomeCliente);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(Anuncio anuncio) {
		anuncioRepository.save(anuncio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Long id) throws ResourcesNotFoundException {
		verificaAnuncioExiste(id);
		anuncioRepository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelatorioAnuncioDTO> buildRelatorio(LocalDate dataInicio, LocalDate dataTermino, String nomeCliente) throws ResourcesNotFoundException {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();

		if (!ObjectUtils.isEmpty(nomeCliente) && dataInicio != null && dataTermino != null) {
			anuncios = findAnuncioByAnuncioPorPeriodoECliente(dataInicio, dataTermino, nomeCliente);
		} else if (dataInicio != null && dataTermino != null) {
			anuncios = findAnuncioByPeriodo(dataInicio, dataTermino);
		} else if (!ObjectUtils.isEmpty(nomeCliente)) {
			anuncios = findByNomeCliente(nomeCliente);
		} else {
			anuncios = listAll();
		}

		if (anuncios.isEmpty()) {
			throw new ResourcesNotFoundException("Anuncio não encontrado");
		}
		
		return relatorio.getRelatorio(anuncios);
	}

	private List<Anuncio> findAnuncioByPeriodo(LocalDate dataInicio, LocalDate dataTermino) {
		return anuncioRepository.findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqual(dataInicio,
				dataTermino);
	}

	private List<Anuncio> findAnuncioByAnuncioPorPeriodoECliente(LocalDate dataInicio,
			LocalDate dataTermino, String cliente) {
		return anuncioRepository.findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqualAndNomeClienteEquals(
				dataInicio, dataTermino, cliente);
	}

	private void verificaAnuncioExiste(Long id) throws ResourcesNotFoundException {
		if (anuncioRepository.findById(id).isEmpty()) {
			throw new ResourcesNotFoundException("Anuncio não encontrado!");
		}
	}
}
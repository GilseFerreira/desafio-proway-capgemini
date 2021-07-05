package com.capgemini.desafioproway.gerenciamentodeanuncios.service;

import java.util.List;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto.RelatorioAnuncioDTO;
import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;

public interface RelatorioService {
	public List<RelatorioAnuncioDTO> getRelatorio(List<Anuncio> anuncios);
}

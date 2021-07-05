package com.capgemini.desafioproway.gerenciamentodeanuncios.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto.RelatorioAnuncioDTO;
import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;
import com.capgemini.desafioproway.gerenciamentodeanuncios.service.RelatorioService;
import com.capgemini.desafioproway.gerenciamentodeanuncios.util.Calculadora;

@Service
public class RelatorioSeviceImpl implements RelatorioService {

	public List<RelatorioAnuncioDTO> getRelatorio(List<Anuncio> anuncios) {
		List<RelatorioAnuncioDTO> relatorioAnuncio = new ArrayList<RelatorioAnuncioDTO>();

		anuncios.stream().forEach(anuncio -> {
			Integer qtdDias = Calculadora.calculoQuantidadeDias(anuncio.getDataInicio(), anuncio.getDataTermino());
			double totalInvestimento = Calculadora.calculoInvestimento(anuncio.getValorInvestidoDia(), qtdDias);
			Integer totalCliques = Calculadora.calculoCliques(totalInvestimento);
			Integer totalCompartilhamentos = Calculadora.calculoCompartilhamentos(totalCliques);
			Integer totalVisualizacoes = Calculadora.calculoVisualizacoes(totalInvestimento, totalCompartilhamentos);
			
    		relatorioAnuncio.add(new RelatorioAnuncioDTO(
					anuncio, 
					totalInvestimento, 
					totalCliques, 
					totalCompartilhamentos, 
					totalVisualizacoes));
		});	

		return relatorioAnuncio;
	}
}

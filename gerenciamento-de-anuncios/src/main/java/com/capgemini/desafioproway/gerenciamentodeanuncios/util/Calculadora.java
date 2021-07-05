package com.capgemini.desafioproway.gerenciamentodeanuncios.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calculadora {
	
	public static Integer calculoQuantidadeDias(LocalDate dataInicio, LocalDate dataTermino) {
		Date inicio = Calculadora.convertToDateViaInstant(dataInicio);
		Date fim = Calculadora.convertToDateViaInstant(dataTermino);
		Long diff = fim.getTime() - inicio.getTime();

		Long retorno = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return retorno.intValue();
	}
	
	public static double calculoInvestimento(Double valorInvestidoDia, Integer qtdDias) {
		return valorInvestidoDia * qtdDias;
	}
	
	public static Integer calculoCliques(Double investimento) {
		Integer alcanceAnuncioOriginal;
		alcanceAnuncioOriginal = (int) (investimento * 30);
		return (alcanceAnuncioOriginal / 100) * 12;
	}

	public static Integer calculoCompartilhamentos(Integer cliques) {
		return (int) (cliques / 20 * 3);
	}

	public static Integer calculoVisualizacoes(double totalInvestido, Integer compartilhamentos) {
		Double alcanceAnunOrig;
		alcanceAnunOrig = totalInvestido * 30;
		return (int) ((compartilhamentos * 40) + alcanceAnunOrig);
	}

	public static Date convertToDateViaInstant(LocalDate localDateTime) {
		return Date.from(localDateTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}

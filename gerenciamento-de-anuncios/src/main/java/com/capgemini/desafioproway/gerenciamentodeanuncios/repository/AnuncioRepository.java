package com.capgemini.desafioproway.gerenciamentodeanuncios.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;


@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findAllById (Long id);
    List<Anuncio> findAllByNomeClienteIgnoreCase (String nomeCliente);
    List<Anuncio> findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqual (LocalDate inicioIntervalo, LocalDate fimIntervalo);
    List<Anuncio> findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqualAndNomeClienteEquals (LocalDate inicioIntervalo, LocalDate fimIntervalo, String nomeCliente);
}
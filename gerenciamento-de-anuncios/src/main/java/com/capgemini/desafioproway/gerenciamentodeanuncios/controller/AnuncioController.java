package com.capgemini.desafioproway.gerenciamentodeanuncios.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.dto.RelatorioAnuncioDTO;
import com.capgemini.desafioproway.gerenciamentodeanuncios.domain.entity.Anuncio;
import com.capgemini.desafioproway.gerenciamentodeanuncios.exception.ResourcesNotFoundException;
import com.capgemini.desafioproway.gerenciamentodeanuncios.service.impl.AnuncioServiceImpl;

@RestController
@RequestMapping("anuncio")
@CrossOrigin(origins = "*")
public class AnuncioController {

	@Autowired
	AnuncioServiceImpl anuncioService;

	@GetMapping
	public ResponseEntity<List<Anuncio>> listarTodos() {
		return ResponseEntity.ok(anuncioService.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Anuncio>> listarPorId(@PathParam("id") Long id) {
		return ResponseEntity.ok(anuncioService.findById(id));
	}

	@PostMapping()
	public Object cadastraAnuncio(@RequestBody @Validated Anuncio anuncio) {
		anuncioService.create(anuncio);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagaAnuncio(@PathVariable("id") Long id) throws ResourcesNotFoundException {
		anuncioService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("relatorio")
	public List<RelatorioAnuncioDTO> gerarRelatorioAnuncio(@RequestParam @Nullable LocalDate dataInicio,
			@RequestParam @Nullable LocalDate dataTermino, @RequestParam @Nullable String nomeCliente)
			throws ResourcesNotFoundException {
		return anuncioService.buildRelatorio(dataInicio, dataTermino, nomeCliente);
	}
}

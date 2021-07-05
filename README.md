<h2> Desafio Calculadora de Alcance de Anúncios | Capgemini </h2>

A calculadora foi desenvolvida a partir dos seguintes dados do problema:

1. A cada 100 pessoas que visualizam o anúncio 12 clicam nele.
2. A cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
3. Cada compartilhamento nas redes sociais gera 40 novas visualizações.
4. 30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
5. O mesmo anúncio é compartilhado no máximo 4 vezes em sequência.

<p> Criar um script que receba um valor investido em reais e retorne uma projeção aproximada da quantidade máxima de pessoas que visualizarão o mesmo anúncio (considerando o anúncio original + os compartilhamentos). </p>
 
<h3> Tecnologias Utilizadas: </h3>

- Java 8 
- Eclipse 
- Framework Spring 

<h3> Instruções: </h3>

- mvn clean package
- mvn spring-boot:run || java -jar package gerenciamento-de-anuncios-0.0.1-SNAPSHOT.jar


- GET http://localhost:8080/anuncio/
- GET http://localhost:8080/anuncio/1
- DELETE http://localhost:8080/anuncio/1
- POST http://localhost:8080/anuncio
```javascript{
    "nome": "Desafio Capgemini",
    "cliente": "Maria Joaquina",
    "dataInicio": "25/06/2021",
    "dataTermino": "04/07/2021",
    "valorInvestidoDia": "10.0"
}
```

- GET http://localhost:8080/anuncio/relatorio?dataInicio=25/07/2021&dataTermino=25/12/2021&nomeCliente=Facebook
package br.unitins.dto;

public record EstadosDTO(
    long id,
    String nome,
    String sigla,
    MunicipioDTO municipio
) {

}

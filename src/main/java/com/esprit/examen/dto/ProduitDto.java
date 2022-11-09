package com.esprit.examen.dto;

import lombok.Data;

@Data
public class ProduitDto {
	
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;

}

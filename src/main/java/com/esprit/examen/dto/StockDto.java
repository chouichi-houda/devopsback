package com.esprit.examen.dto;

import java.util.Set;


import com.esprit.examen.entities.Produit;

import lombok.Data;

@Data
public class StockDto {
	
	private Long idStock;
	private String libelleStock;
	private Integer qte;
	private Integer qteMin;
	private Set<Produit> produits;

}

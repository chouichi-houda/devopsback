package com.esprit.examen.dto;

import java.util.Set;

import com.esprit.examen.entities.Produit;

import lombok.Data;

@Data
public class CategorieProduitDto {
	
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	private Set<Produit> produits;

}

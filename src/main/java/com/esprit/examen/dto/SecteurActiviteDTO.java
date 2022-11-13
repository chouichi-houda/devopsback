package com.esprit.examen.dto;

import java.util.Set;

import com.esprit.examen.entities.Fournisseur;

import lombok.Data;

@Data
public class SecteurActiviteDTO {
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	private Set<Fournisseur> fournisseurs;
}

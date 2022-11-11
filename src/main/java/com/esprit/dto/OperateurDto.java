package com.esprit.dto;

import java.util.Set;

import javax.persistence.OneToMany;

import com.esprit.examen.entities.Facture;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class OperateurDto {
	private Long idOperateur;
	private String nom;
	private String prenom;
	
	private String password;
	
}

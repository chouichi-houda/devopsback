package com.esprit.examen.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import com.esprit.examen.entities.Produit;

@Getter
@Setter
public class DTOStock {
	private Long idStock;
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;

    private Set<Produit> produits;

    public DTOStock(String libelleStock, Integer qte, Integer qteMin) {
        super();
        this.libelleStock = libelleStock;
        this.qte = qte;
        this.qteMin = qteMin;
    }
    }
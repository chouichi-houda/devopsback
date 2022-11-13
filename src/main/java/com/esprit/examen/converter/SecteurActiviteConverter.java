package com.esprit.examen.converter;

import org.modelmapper.ModelMapper;

import com.esprit.examen.dto.SecteurActiviteDTO;
import com.esprit.examen.entities.SecteurActivite;
@Component
public class SecteurActiviteConverter {
	public SecteurActiviteDTO convertEntityToDto(SecteurActivite secteurActivite) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(secteurActivite, SecteurActiviteDTO.class);

    }

    public SecteurActivite convertDtoToEntity(SecteurActiviteDTO secteurActiviteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(secteurActiviteDTO, SecteurActivite.class);
    }
}

package com.esprit.examen.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.converter.SecteurActiviteConverter;
import com.esprit.examen.dto.SecteurActiviteDTO;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	
	@Autowired
    ModelMapper modelMapper;
	@Autowired(required = false)
    SecteurActiviteConverter secteurActiviteConverter;
    
    @Override
    public SecteurActiviteDTO saveSecteurActivite(SecteurActiviteDTO secteurActivitedto) {
    	SecteurActivite sa = secteurActiviteConverter.convertDtoToEntity(secteurActivitedto);
        sa = secteurActiviteRepository.save(sa);
        return secteurActiviteConverter.convertEntityToDto(sa);
    }
    
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		SecteurActivite secteurActivite = secteurActiviteRepository.findById(id).orElse(null);
		log.info("secteurActivite :" + secteurActivite);
		return secteurActivite;
	}

}

package com.mary.dojosNinjas.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mary.dojosNinjas.models.Dojo;
import com.mary.dojosNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public void creatDojo(@Valid Dojo dojo) {
		dojoRepository.save(dojo);
	}
	public Iterable<Dojo> allDojo() {
		return dojoRepository.findAll();
	}
	public Dojo findDojo(Long id) {
		 Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		 if(optionalDojo.isPresent()) {
			 return optionalDojo.get();
		 } else {
			 return null;
		 } 
	}
}

package com.mary.dojosNinjas.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mary.dojosNinjas.models.Ninja;
import com.mary.dojosNinjas.repositories.NinjasRepository;

@Service
public class NinjaService {
	private final NinjasRepository ninjasRepository ;
	public NinjaService(NinjasRepository ninjasRepository ) {
		this.ninjasRepository  = ninjasRepository ;
		
	}
	public void creatDojo(@Valid Ninja ninja) {
		ninjasRepository.save(ninja);
	}

}

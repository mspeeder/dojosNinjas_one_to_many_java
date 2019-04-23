package com.mary.dojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mary.dojosNinjas.models.Ninja;

@Repository
public interface NinjasRepository extends CrudRepository<Ninja, Long> {

}

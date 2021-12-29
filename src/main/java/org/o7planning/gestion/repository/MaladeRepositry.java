package org.o7planning.gestion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.o7planning.gestion.model.Malade;

@Repository
public interface MaladeRepositry extends JpaRepository<Malade, Long>{

}

package org.framestudy.springjpa.extendmag.dao;

import java.util.List;

import org.framestudy.springjpa.extendmag.PetBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPetDao extends JpaRepository<PetBean, Long>{
	
	@Query("from PetBean as p where p.petName like concat(?1,'%')")
	List<?> listPetBeanByPetName(String petName);
	
}

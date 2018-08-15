package org.framestudy.springjpa.extendmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.springjpa.extendmag.DogBean;
import org.framestudy.springjpa.extendmag.dao.IPetDao;
import org.framestudy.springjpa.extendmag.service.IPetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements IPetService {

	@Resource
	private IPetDao petDaoImpl;
	
	@Override
	public void saveDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.save(dog);
	}

	@Override
	public void updateDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.saveAndFlush(dog);
	}

	@Override
	public void deleteDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.delete(dog);
	}

	@Override
	public DogBean getDogBeanById(Long id) {
		// TODO Auto-generated method stub
		return (DogBean) petDaoImpl.findOne(id);
	}

	@Override
	public List<?> listAllPet() {
		// TODO Auto-generated method stub
		return petDaoImpl.findAll();
	}

	@Override
	public List<?> listPetBeanByPetName(String petName) {
		// TODO Auto-generated method stub
		return petDaoImpl.listPetBeanByPetName(petName);
	}

}

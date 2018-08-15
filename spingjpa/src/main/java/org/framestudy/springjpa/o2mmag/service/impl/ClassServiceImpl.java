package org.framestudy.springjpa.o2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.springjpa.o2mmag.ClassBean;
import org.framestudy.springjpa.o2mmag.dao.IClassDao;
import org.framestudy.springjpa.o2mmag.service.IClassService;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements IClassService {

	@Resource
	private IClassDao classDaoImpl;
	
	@Override
	public void saveClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		classDaoImpl.save(cls);
	}

	@Override
	public void updateClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		classDaoImpl.saveAndFlush(cls);
	}

	@Override
	public ClassBean getClassBeanById(Long id) {
		// TODO Auto-generated method stub
		return classDaoImpl.findOne(id);
	}

	@Override
	public List<?> listClassBeanByStudentName(String studentName) {
		// TODO Auto-generated method stub
		return classDaoImpl.listClassBeanByStudentName(studentName);
	}

}

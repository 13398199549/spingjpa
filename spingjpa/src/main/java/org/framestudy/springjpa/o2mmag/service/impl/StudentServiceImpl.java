package org.framestudy.springjpa.o2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.springjpa.o2mmag.StudentBean;
import org.framestudy.springjpa.o2mmag.dao.IStudentDao;
import org.framestudy.springjpa.o2mmag.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Resource
	private IStudentDao studentDaoImpl;
	
	
	@Override
	public void saveStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.save(student);
	}

	@Override
	public void updateStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.saveAndFlush(student);
	}

	@Override
	public void deleteStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.delete(student);
	}

	@Override
	public StudentBean getStudentBeanById(Long id) {
		// TODO Auto-generated method stub
		return studentDaoImpl.findOne(id);
	}

	@Override
	public List<?> listStudentByClassName(String className) {
		// TODO Auto-generated method stub
		return studentDaoImpl.listStudentByClassName(className);
	}

}

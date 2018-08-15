package org.framestudy.springjpa.o2mmag.dao;

import java.util.List;

import org.framestudy.springjpa.o2mmag.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentDao extends JpaRepository<StudentBean, Long>{
	
	@Query("select new map(s.studentName as studentName,c.className as className) from StudentBean as s left join s.cls as c where c.className like concat(?1,'%')")
	List<?> listStudentByClassName(String className);
}

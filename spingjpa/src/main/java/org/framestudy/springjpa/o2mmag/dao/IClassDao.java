package org.framestudy.springjpa.o2mmag.dao;

import java.util.List;

import org.framestudy.springjpa.o2mmag.ClassBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClassDao extends JpaRepository<ClassBean, Long>{

	//DISTINCT 去重
	@Query("select DISTINCT new map (c.className as className) from ClassBean as c left join c.students as s where s.studentName like concat(?1,'%')")
	List<?> listClassBeanByStudentName(String studentName);
}

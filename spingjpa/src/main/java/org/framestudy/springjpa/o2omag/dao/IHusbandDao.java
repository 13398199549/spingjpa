package org.framestudy.springjpa.o2omag.dao;

import java.util.List;

import org.framestudy.springjpa.o2omag.HusbandBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHusbandDao extends JpaRepository<HusbandBean, String>{
	
	//在spring jpa中  jpql不能使用left join fetch
	@Query(value="select new map(h.husbandName as husbandName,w.wifeName as wifeName) from HusbandBean as h left join h.wife as w where w.wifeName like concat(?1,'%')")
	List<?> listHusbandByWifeName(String wifeName);
	
	@Query(value="select new map(h.husbandName as husbandName,w.wifeName as wifeName) from HusbandBean as h left join h.wife as w where w.wifeName like concat(?1,'%')")
	Page<HusbandBean> listHusbandByParams2PagerBean(String wifeName,Pageable pager);
}

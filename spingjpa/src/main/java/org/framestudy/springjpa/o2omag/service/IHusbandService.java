package org.framestudy.springjpa.o2omag.service;

import java.util.List;
import java.util.Map;

import org.framestudy.springjpa.bean.PagerBean;
import org.framestudy.springjpa.o2omag.HusbandBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHusbandService {

	void saveHusband(HusbandBean husband); 
	
	void udpateHusband(HusbandBean husband); 
	
	void deleteHusband(HusbandBean husband); 
	
	HusbandBean getHusbandById(String id);
	
	List<?> listHusbandByWifeName(String wifeName);
	
	Page<HusbandBean> listHusbandByParams2PagerBean(Map params,Pageable pager);
	
	
	
}

package org.framestudy.springjpa.o2omag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.springjpa.o2omag.HusbandBean;
import org.framestudy.springjpa.o2omag.dao.IHusbandDao;
import org.framestudy.springjpa.o2omag.service.IHusbandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class HusbandServiceImpl implements IHusbandService {

	@Resource
	private IHusbandDao husbandDaoImpl;
	
	@Override
	public void saveHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		husbandDaoImpl.save(husband);
	}

	@Override
	public void udpateHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		husbandDaoImpl.saveAndFlush(husband);
	}

	@Override
	public void deleteHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		husbandDaoImpl.delete(husband);
	}

	@Override
	public HusbandBean getHusbandById(String id) {
		// TODO Auto-generated method stub
		return husbandDaoImpl.findOne(id);
	}

	@Override
	public List<?> listHusbandByWifeName(String wifeName) {
		// TODO Auto-generated method stub
		return husbandDaoImpl.listHusbandByWifeName(wifeName);
	}

	@Override
	public Page<HusbandBean> listHusbandByParams2PagerBean(Map params, Pageable pager) {
		// TODO Auto-generated method stub
		String wifeName = params.get("wifeName").toString();
		return husbandDaoImpl.listHusbandByParams2PagerBean(wifeName, pager);
	}

}

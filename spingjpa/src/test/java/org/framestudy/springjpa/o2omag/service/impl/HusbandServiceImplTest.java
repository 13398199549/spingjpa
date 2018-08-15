package org.framestudy.springjpa.o2omag.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.springjpa.o2omag.HusbandBean;
import org.framestudy.springjpa.o2omag.WifeBean;
import org.framestudy.springjpa.o2omag.service.IHusbandService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class HusbandServiceImplTest {

	@Resource
	private IHusbandService husbandServiceImpl;
	
	
	@Test
	public void listHusbandByParams2PagerBean() {
		
		Map params = new HashMap<>();
		params.put("wifeName", "小");
		Pageable pager = new PageRequest(0, 5);
		Page<HusbandBean> page = husbandServiceImpl.listHusbandByParams2PagerBean(params, pager);
		
		System.out.println(page.getNumber());//当前页码(在JPA中，0代表第1页，1代表第2页)
		System.out.println(page.getNumberOfElements());//当前页码中返回了多少条数据
		System.out.println(page.getSize());//需要从数据库读取数据的条数
		System.out.println(page.getTotalElements());//满足条件的总条数
		System.out.println(page.getTotalPages());//总页数
		System.out.println(page.hasContent());//是否有内容
		System.out.println(page.getContent());//具体内容
		System.out.println(page.hasPrevious());//是否有上一页
		System.out.println(page.hasNext());//是否有下一页
		System.out.println(page.isFirst());//是否是第一页
		System.out.println(page.isLast());//是否是最后一页

		
	}
	
	@Test
	public void listHusbandByWifeName() {
		String wifeName = "小";
		List<?> list = husbandServiceImpl.listHusbandByWifeName(wifeName);
		System.out.println(list);
		
	}
	
	
	@Test
	public void deleteHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164b577630164b577690a0000");
		Assert.assertNotNull(husband);
		husbandServiceImpl.deleteHusband(husband);
	}
	
	
	@Test
	public void updateHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164b577630164b577690a0000");
		
		
		Assert.assertNotNull(husband);
		WifeBean wife = husband.getWife();
		wife.setWifeName("小杨");
		husbandServiceImpl.udpateHusband(husband);
	}
	
	
	@Test
	public void saveHusband (){
		HusbandBean husband = new HusbandBean();
		husband.setHusbandName("小王3");
		
		WifeBean wife = new WifeBean();
		wife.setWifeName("小马3");
		
		//建立妻子和丈夫之间的关系
		husband.setWife(wife);
		wife.setHusband(husband);
		
		husbandServiceImpl.saveHusband(husband);
		
		
		
		
	}
	
	
	
}

package org.framestudy.springjpa.usermag.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.framestudy.springjpa.bean.HouseBean;
import org.framestudy.springjpa.bean.PagerBean;
import org.framestudy.springjpa.bean.UserBean;
import org.framestudy.springjpa.bean.UserInfoBean;
import org.framestudy.springjpa.usermag.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserServiceImplTest {

	@Resource
	private IUserService userServiceImpl;
	
	@Test
	public void listUserBeanByIdcard() {
		String idcard = "511";
		List<?> list = userServiceImpl.listUserBeanByIdcard(idcard);
		System.out.println(list);
		
//		int size = list.size();
//		for(int i = 0; i < size; i ++) {
//			Object[] objts = (Object[]) list.get(i);
//			System.out.println(objts[0]);
//			System.out.println(objts[1]);
//		}
		
	}
	
	
	@Test
	public void listUserBeanByParmas2PagerBean4CriteriaDemo() {
		
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "d");
		
		Pageable pageRequest = new PageRequest(0, 5, new Sort(Direction.DESC, "createTime","updateTime"));
		Page<UserBean> page = userServiceImpl.listUserBeanByParmas2PagerBean4CriteriaDemo(params, pageRequest);
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
	public void listUserBeanByParams2PagerBean() {
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "d");
		
		//创建分页请求对象，并且设置起始页码以及返回的条数
		Pageable pageRequest = new PageRequest(0, 5, new Sort(Direction.DESC, "createTime","updateTime"));
		Page<UserBean> page = userServiceImpl.listUserBeanByParams2PagerBean(params, pageRequest);
		System.out.println(page);
	}
	
	
	
	@Test
	public void listUserBeanByParams() {
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "d");
		
		List<?> datas = userServiceImpl.listUserBeanByParams(params);
		System.out.println(datas);
		
		
//		int lenth = datas.size();
//		for(int i = 0; i < lenth; i ++) {
//			Object [] objts = (Object[]) datas.get(i);
//			
//			System.out.println(objts[0]);
//			System.out.println(objts[1]);
//			
//		}
//		
		
	}
	
	
	
	@Test
	public void listUserBeanByObject() {
		UserBean user = new UserBean();
		user.setUserName("曹");
		user.setLoginName("d");
		List<?> datas = userServiceImpl.listUserBeanByObject(user);
		System.out.println(datas);
	}
	
	@Test
	public void listUserBeanByUserNameAndLoginName() {
		String userName = "曹";
		String loginName = "a";
		List<?> datas = userServiceImpl.listUserBeanByUserNameAndLoginName(userName, loginName);
		System.out.println(datas);
	}
	
	@Test
	public void deleteUserBean() {
		UserBean user = userServiceImpl.loadUserBeanById(1L);
		Assert.assertNotNull(user);
		
		userServiceImpl.deleteUserBean(user);
	}
	
	
	/**
	 * 程序抛出no session问题，需要在web.xml中配置
	 * org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter
	 * 作用=== OpenSessionInViewFilter
	 */
	@Test
	public void updateUserBean() {
		UserBean user = userServiceImpl.getUserBeanById(1L);
		Assert.assertNotNull(user);

		
		user.setUserName("貂蝉");
		user.setUpdateTime(new Date());
		
		UserInfoBean userInfo = user.getUserInfo();
		userInfo.setEducationLevel(2);
		
		HouseBean house = new HouseBean();
		house.setHouseAddress("九眼桥");
		house.setHouseNo("3号桥洞");
		user.getHouses().add(house);
		
		userServiceImpl.updateUserBean(user);
	}
	
	
	
	@Test
	public void saveUserBean() {
		//初始化用户
		UserBean user = new UserBean();
		user.setUserName("曹冲");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		user.setLoginName("d");
		//初始化用户信息
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setIdCard("511381199112341236");
		userInfo.setEducationLevel(4);
		user.setUserInfo(userInfo);
		//初始化房产信息
		Set<HouseBean> houses = new HashSet<>();
		HouseBean house = new HouseBean();
		house.setHouseAddress("九眼桥");
		house.setHouseNo("1号桥洞");
		
		HouseBean house2 = new HouseBean();
		house2.setHouseAddress("九眼桥");
		house2.setHouseNo("2号桥洞");
		houses.add(house2);
		houses.add(house);
		user.setHouses(houses);
		
		userServiceImpl.saveUserBean(user);
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
}

package org.framestudy.springjpa.usermag.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.framestudy.springjpa.bean.UserBean;
import org.framestudy.springjpa.usermag.dao.IUserDao;
import org.framestudy.springjpa.usermag.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDaoImpl;

	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.save(user);
	}

	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.saveAndFlush(user);
	}

	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.delete(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.findOne(id);// session.get();
	}

	@Override
	public UserBean loadUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getOne(id);// session.load();
	}

	@Override
	public List<?> listUserBeanByUserNameAndLoginName(String userName, String loginName) {
		// TODO Auto-generated method stub
		return userDaoImpl.findByUserNameStartingWithAndLoginNameStartingWithOrderByUpdateTimeDesc(userName, loginName);
	}

	@Override
	public List<?> listUserBeanByObject(UserBean user) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByUserNameAndLoginName(user.getUserName(), user.getLoginName());
	}

	@Override
	public List<?> listUserBeanByParams(Map params) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByUserNameAndLoginName(params.get("userName").toString(), params.get("loginName").toString());
	}

	@Override
	public Page<UserBean> listUserBeanByParams2PagerBean(Map params, Pageable page) {
		// TODO Auto-generated method stub
		String userName = params.get("userName").toString();
		String loginName = params.get("loginName").toString();
		return userDaoImpl.findByUserNameStartingWithAndLoginNameStartingWith(userName, loginName, page);
	}

	@Override
	public Page<UserBean> listUserBeanByParmas2PagerBean4CriteriaDemo(Map params, Pageable page) {
		// TODO Auto-generated method stub
		
		return userDaoImpl.findAll(new Specification<UserBean>() {
			
			@Override
			public Predicate toPredicate(Root<UserBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<Predicate>();// 添加查询条件
				String userName = params.get("userName").toString(); 
				String loginName = params.get("loginName").toString(); 
				if(StringUtils.hasLength(userName)) {
					predicates.add(cb.like(root.get("userName"), userName +"%"));
				}
				
				if(StringUtils.hasLength(loginName)) {
					predicates.add(cb.like(root.get("loginName"), loginName +"%"));
				}
				
				Predicate[] arrayPredicates = new Predicate[predicates.size()];
				return cb.and(predicates.toArray(arrayPredicates));
			}
		}, page);
	}

	@Override
	public List<?> listUserBeanByIdcard(String idcard) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByIdcard(idcard);
	}

}

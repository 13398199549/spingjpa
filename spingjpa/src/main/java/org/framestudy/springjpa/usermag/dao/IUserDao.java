package org.framestudy.springjpa.usermag.dao;

import java.util.List;

import org.framestudy.springjpa.bean.UserBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户持久层接口
 * @author puxubo
 *
 */
public interface IUserDao extends JpaRepository<UserBean, Long>,JpaSpecificationExecutor<UserBean> {
	
	//from UserBean as u where u.userName like concat(?1,'%') and u.loginName like concat(?2,'%')
	List<?> findByUserNameStartingWithAndLoginNameStartingWithOrderByUpdateTimeDesc(String userName,String loginName);
	/**
	 * 分页查询方法
	 * @param userName
	 * @param loginName
	 * @param pageable
	 * @return
	 */
	Page<UserBean> findByUserNameStartingWithAndLoginNameStartingWith(String userName,String loginName,Pageable pageable); 
	
	//nativeQuery=true 所谓本地查询，就是使用原生的sql语句
//	@Query(value="select * from t_user as u where u.user_name like concat(?1,'%') and u.login_name like concat(?2,'%')",nativeQuery=true)
	@Query(value="select new map(u.userName,u.password)from UserBean as u where u.userName like concat(?1,'%') and u.loginName like concat(?2,'%')")
	List<?> listUserBeanByUserNameAndLoginName(String userName,String loginName);
	
	@Query(value="select new map(u.userName,u.password)from UserBean as u where u.userInfo.idCard like concat(?1,'%')")
	List<?> listUserBeanByIdcard(String idcard);
	
}

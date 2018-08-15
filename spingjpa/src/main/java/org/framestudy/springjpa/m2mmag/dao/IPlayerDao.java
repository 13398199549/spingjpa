package org.framestudy.springjpa.m2mmag.dao;

import java.util.List;

import org.framestudy.springjpa.m2mmag.PlayerBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlayerDao extends JpaRepository<PlayerBean, Long>{
	
	@Query(value="select new map(p.id as id,p.playerName as playerName) from PlayerBean as p left join p.games as g where g.gameName like concat(?1,'%')")
	List<?> listPlayerBeanByGameName(String gameName);
	
}

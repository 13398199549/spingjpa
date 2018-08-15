package org.framestudy.springjpa.m2mmag.dao;

import java.util.List;

import org.framestudy.springjpa.m2mmag.GameBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGameDao extends JpaRepository<GameBean, Long>{

	@Query(value="select new map(g.gameName as gameName,g.id as id) from GameBean as g left join g.players as p where p.playerName like concat(?1,'%')")
	List<?> listGameBeanByPlayerName(String playerName);
	
}

package org.framestudy.springjpa.m2mmag.service;

import java.util.List;

import org.framestudy.springjpa.m2mmag.PlayerBean;

public interface IPlayerService {

	void savePlayer(PlayerBean player);
	
	void updatePlayer(PlayerBean player);
	
	void deletePlayer(PlayerBean player);
	
	PlayerBean getPlayerBeanById(Long id);
	
	List<?> listPlayerBeanByGameName(String gameName);
	
}

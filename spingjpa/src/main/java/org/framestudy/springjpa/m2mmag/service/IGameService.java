package org.framestudy.springjpa.m2mmag.service;

import java.util.List;

import org.framestudy.springjpa.m2mmag.GameBean;

public interface IGameService {

	void saveGame(GameBean game);
	
	GameBean getGameBeanById(Long id);
	
	List<?> listGameBeanByPlayerName(String playerName);
	
}

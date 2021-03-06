package org.framestudy.springjpa.m2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.springjpa.m2mmag.GameBean;
import org.framestudy.springjpa.m2mmag.dao.IGameDao;
import org.framestudy.springjpa.m2mmag.service.IGameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {

	@Resource
	private IGameDao gameDaoImpl;
	
	@Override
	public void saveGame(GameBean game) {
		// TODO Auto-generated method stub
		gameDaoImpl.save(game);
	}

	@Override
	public GameBean getGameBeanById(Long id) {
		// TODO Auto-generated method stub
		return gameDaoImpl.findOne(id);
	}

	@Override
	public List<?> listGameBeanByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		return gameDaoImpl.listGameBeanByPlayerName(playerName);
	}

}

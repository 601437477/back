package com.example.background.service.impl;

import com.example.background.dao.BetDao;
import com.example.background.domain.BetSearchVo;
import com.example.background.entity.Bet;
import com.example.background.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BetServiceImpl implements BetService {

    @Autowired
    private BetDao betDao;

    @Override
    public Bet queryById(Integer id) {
        return betDao.queryById(id);
    }

    @Override
    public Bet insert(Bet bet) {
        betDao.insert(bet);
        return bet;
    }

    @Override
    public Bet update(Bet bet) {
        betDao.update(bet);
        return bet;
    }

    @Override
    public boolean deleteById(Integer id) {
        return betDao.deleteById(id) > 0;
    }

    @Override
    public List<Bet> queryBet(BetSearchVo searchVo) {
        return betDao.queryBet(searchVo);
    }
    @Override
    public void deleteAll(){
        betDao.deleteAll();
    }
}

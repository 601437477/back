package com.example.background.service.impl;

import com.example.background.dao.LotteryDao;
import com.example.background.domain.LotterySearchVo;
import com.example.background.entity.Lottery;
import com.example.background.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryDao dao;

    @Override
    public Lottery queryById(Integer id) {
        return dao.queryById(id);
    }

    @Override
    public Lottery insert(Lottery lottery) {
        dao.insert(lottery);
        return lottery;
    }

    @Override
    public Lottery update(Lottery lottery) {
        dao.update(lottery);
        return lottery;
    }

    @Override
    public boolean deleteById(Integer id) {
        return dao.deleteById(id) > 0;
    }

    @Override
    public List<Lottery> queryLottery(LotterySearchVo searchVo) {
        return dao.queryLottery(searchVo);
    }

    @Override
    public Lottery queryLatest() {
        return dao.queryLatest();
    }

}

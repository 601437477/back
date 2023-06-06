package com.example.background.service;

import com.example.background.domain.BetSearchVo;
import com.example.background.entity.Bet;

import java.util.List;

public interface BetService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bet queryById(Integer id);


    /**
     * 新增数据
     *
     * @param bet 实例对象
     * @return 实例对象
     */
    Bet insert(Bet bet);


    /**
     * 修改数据
     *
     * @param bet 实例对象
     * @return 实例对象
     */
    Bet update(Bet bet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过查询条件查询
     *
     * @param searchVo 查询条件
     * @return 实例对象
     */
    List<Bet> queryBet(BetSearchVo searchVo);

    /**
     * 删除所有数据
     *
     */
    void deleteAll();
}

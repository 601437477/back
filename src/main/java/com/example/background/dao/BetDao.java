package com.example.background.dao;

import com.example.background.domain.BetSearchVo;
import com.example.background.entity.Bet;

import java.util.List;

public interface BetDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bet queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param Bet 实例对象
     * @return 对象列表
     */
    List<Bet> queryAll(Bet Bet);

    /**
     * 新增数据
     *
     * @param Bet 实例对象
     * @return 影响行数
     */
    int insert(Bet Bet);

    /**
     * 修改数据
     *
     * @param Bet 实例对象
     * @return 影响行数
     */
    int update(Bet Bet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过查询条件查询
     *
     * @param searchVo 查询条件
     * @return 对象列表
     */
    List<Bet> queryBet(BetSearchVo searchVo);

    void deleteAll();
}
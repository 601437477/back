package com.example.background.dao;

import com.example.background.domain.LotterySearchVo;
import com.example.background.entity.Lottery;

import java.util.List;

public interface LotteryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lottery queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param Lottery 实例对象
     * @return 对象列表
     */
    List<Lottery> queryAll(Lottery Lottery);

    /**
     * 新增数据
     *
     * @param Lottery 实例对象
     * @return 影响行数
     */
    int insert(Lottery Lottery);

    /**
     * 修改数据
     *
     * @param Lottery 实例对象
     * @return 影响行数
     */
    int update(Lottery Lottery);

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
    List<Lottery> queryLottery(LotterySearchVo searchVo);

    Lottery queryLatest();
}
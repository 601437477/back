package com.example.background.service;

import com.example.background.domain.LotterySearchVo;
import com.example.background.entity.Lottery;

import java.util.List;

public interface LotteryService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lottery queryById(Integer id);


    /**
     * 新增数据
     *
     * @param lottery 实例对象
     * @return 实例对象
     */
    Lottery insert(Lottery lottery);


    /**
     * 修改数据
     *
     * @param lottery 实例对象
     * @return 实例对象
     */
    Lottery update(Lottery lottery);

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
    List<Lottery> queryLottery(LotterySearchVo searchVo);

    Lottery queryLatest();
}

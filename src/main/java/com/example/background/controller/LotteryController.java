package com.example.background.controller;


import com.example.background.common.entity.JsonResult;
import com.example.background.common.utils.ResultTool;
import com.example.background.domain.LotterySearchVo;
import com.example.background.entity.Lottery;
import com.example.background.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    /**
     * 获取最新的彩票信息
     * @return
     */
    @GetMapping("/getLatest")
    public JsonResult getLatest() {
        Lottery lottery = lotteryService.queryLatest();
        return ResultTool.success(lottery);
    }

    /**
     * 通过条件查询彩票信息
     * @param searchVo
     * @return
     */
    @PostMapping("/searchLottery")
    public JsonResult searchLottery(@RequestBody LotterySearchVo searchVo) {
        if(searchVo.getLimit() == 0){
            searchVo.setLimit(100);
        }
        List<Lottery> lotteries = lotteryService.queryLottery(searchVo);
        return ResultTool.success(lotteries);
    }

    /**
     * 插入彩票信息
     * @param lottery
     * @return
     */
    @PostMapping("/insert")
    public JsonResult insert(@Validated @RequestBody Lottery lottery) {
        Lottery lotterie = lotteryService.insert(lottery);
        return ResultTool.success(lotterie);
    }

    /**
     * 删除彩票信息
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public JsonResult delete(@RequestParam("id") Integer id) {
        return ResultTool.success(lotteryService.deleteById(id));
    }

    /**
     * 更新彩票
     * @param lottery
     * @return
     */
    @PostMapping("update")
    public JsonResult update(@RequestBody Lottery lottery) {
        lotteryService.update(lottery);
        return ResultTool.success();
    }
}

package com.example.background.controller;


import com.example.background.common.entity.JsonResult;
import com.example.background.common.utils.ResultTool;
import com.example.background.domain.BetSearchVo;
import com.example.background.entity.Bet;
import com.example.background.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    /**
     * 投注信息录入
     * @param bet
     * @return
     */
    @PostMapping("/insert")
    public JsonResult insert(@Validated @RequestBody Bet bet) {
        Bet b = betService.insert(bet);
        return ResultTool.success(b);
    }

    /**
     * 删除投注信息
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public JsonResult delete(@RequestParam("id") Integer id) {
        return ResultTool.success(betService.deleteById(id));
    }

    /**
     * 更新投注信息
     * @param Bet
     * @return
     */
    @PostMapping("update")
    public JsonResult update(@RequestBody Bet Bet) {
        betService.update(Bet);
        return ResultTool.success();
    }

    @PostMapping("/searchBet")
    public JsonResult searchBet(@RequestBody BetSearchVo searchVo) {
        List<Bet> bets = betService.queryBet(searchVo);
        return ResultTool.success(bets);
    }
}

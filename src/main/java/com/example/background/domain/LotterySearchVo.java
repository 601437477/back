package com.example.background.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LotterySearchVo {
    private String id;

    private String period;

    private String code;

    private String number;

    private Date drawingTime;

    private Date beginDate;

    private Date endDate;

    private Integer limit;
}

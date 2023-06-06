package com.example.background.domain;

import lombok.Data;

@Data
public class LotterySearchVo {
    private String id;

    private String period;

    private String code;

    private String number;

    private String drawingTime;

    private String beginDate;

    private String endDate;
}

package com.example.background.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Lottery implements Serializable {

    private String id;
    // 期数
    private String period;
    // 特码
    private String code;
    // 码表
    private String number;
    //开奖时间
    private Date drawingTime;

    private Date createDate;

    private String createUser;
}

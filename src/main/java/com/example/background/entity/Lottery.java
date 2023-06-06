package com.example.background.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class Lottery implements Serializable {

    private String id;
    // 期数
    @NotBlank(message = "期数不为空")
    private String period;
    // 特码
    @NotBlank(message = "特码不为空")
    private String code;
    // 码表
    @NotBlank(message = "码表不为空")
    private String number;
    //开奖时间
    @NotBlank(message = "开奖不为空")
    private Date drawingTime;

    private Date createDate;
}

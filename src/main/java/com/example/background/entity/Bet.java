package com.example.background.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Bet implements Serializable {

    private Integer id;
    // 1 : 特码 3 : 正码 5: 连码 6:平特
    private Integer kind;

    private Integer type;

    private String data;

    private String odds;

    private String money;

    private Date createDate;

    private Integer createUser;
}

package com.example.background.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Bet implements Serializable {

    private String id;

    private String kind;

    private String type;

    private String data;

    private String odds;

    private String money;

    private Date createDate;

    private String createUser;
}

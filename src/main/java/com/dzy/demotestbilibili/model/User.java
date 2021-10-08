package com.dzy.demotestbilibili.model;

import lombok.Data;

/**
 * @author: dzy
 * @time: 2021/9/16 19:14
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String bio;
    private String avatarUrl;
}

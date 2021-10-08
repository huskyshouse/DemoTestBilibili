package com.dzy.demotestbilibili.dto;

import lombok.Data;

/**
 * @description:
 * @author: dzy
 * @time: 2021/9/15 19:35
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}

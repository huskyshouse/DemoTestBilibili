package com.dzy.demotestbilibili.model;

import lombok.Data;

/**
 * @author dzy
 * @time 2021/10/6 15:22
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}

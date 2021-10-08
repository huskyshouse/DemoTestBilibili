package com.dzy.demotestbilibili.dto;

import lombok.Data;

/**
 * @description:
 * @author dzy
 * @time 2021/9/15 17:44
 */
@Data
public class AccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
}

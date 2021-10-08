package com.dzy.demotestbilibili.provider;

import com.alibaba.fastjson.JSON;
import com.dzy.demotestbilibili.dto.AccessTokenDTO;
import com.dzy.demotestbilibili.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 提供github内容
 * @author dzy
 * @time 2021/9/15 17:41
 */
@Component
public class GithubProvider {

    /**
     * 从github通过返回的code获取accessToken
     * @param accessTokenDTO
     * @return  token
     * @author dzy
     * @time 2021/9/15 19:51
     */    
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通过accessToken获取github的user信息
     * @param accessToken
     * @return GithubUser
     * @author dzy
     * @date 2021/9/15 19:49
     */    
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}

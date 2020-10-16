/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-14 18:30
 */
package jsonTest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author LYH
 * @date 2020/09/14 18:30
 */
public class Company {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("username")
    private String username;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
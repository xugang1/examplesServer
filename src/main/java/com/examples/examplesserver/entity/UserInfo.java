package com.examples.examplesserver.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    private String id;

    private String username;

    private int age = 18;

    private String college = "东北林业大学";

    private String tel = "15776329576";
}

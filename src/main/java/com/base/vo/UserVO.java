package com.base.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserVO {

    public static class Save{
        @NotNull
        String name;
    }
}


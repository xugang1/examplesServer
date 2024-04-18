package com.examples.examplesserver.utils;

import com.examples.examplesserver.entity.Result;

public class ResultHandler {

    public static Result success(Object object) {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setData(object);
        result.setMessage("请求成功");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static <T> Result customResult(int code, T data, String message) {
        Result<T> result = new Result<>();

        result.setCode(code);
        result.setData(data);
        result.setMessage(message);

        return result;
    }
}

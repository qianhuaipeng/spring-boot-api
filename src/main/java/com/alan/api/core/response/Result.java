package com.alan.api.core.response;

import com.alibaba.fastjson.JSON;

/**
 * author: alan.peng
 * description: 统一API响应结果封装
 * date: create in 13:27 2018/11/7
 * modified By：
 */
public class Result {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 消息
     */
    private final String msg;

    /**
     * 数据内容，比如列表、实体
     */
    private final Object data;

    private Result(Builder builder){
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
    }

    public static class Builder {
        private final Integer code;
        private String msg;
        private Object data;

        public Builder(Integer code) {
            this.code = code;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public Result build() {
            return new Result(this);
        }

    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Result.Builder(1).msg("asdads").data("asdad").build()));

    }
}

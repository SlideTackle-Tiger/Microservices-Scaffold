package org.tiger.common.pojo.vo;

import lombok.Data;
import org.tiger.common.constant.Code;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description 响应类，统一响应数据格式
 * @Author tiger
 * @Date 2025/6/30 16:14
 */
@Data
public class Result<T> implements Serializable {
    private int code; // 响应状态码
    private String message; // 响应消息
    private T data; // 响应数据

    private static <T> Result<T> restResult(T data, int code, String message){
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }

    public static <T> Result<T> success(){
        return restResult(null, Code.SUCCESS, null);
    }
    public static <T> Result<T> success(T data){
        return restResult(data, Code.SUCCESS, null);
    }
    public static <T> Result<T> success(T data, String message){
        return restResult(data, Code.SUCCESS, message);
    }

    public static <T> Result<T> failed(){
        return restResult(null, Code.FAIL, null);
    }
    public static <T> Result<T> failed(String message){
        return restResult(null, Code.FAIL, message);
    }
    public static <T> Result<T> failed(T data){
        return restResult(data,Code.FAIL, null);
    }
    public static <T> Result<T> failed(T data, String message){
        return restResult(data, Code.FAIL, message);
    }
    public static <T> Result<T> failed(T data, int code, String message){
        return restResult(data, code, message);
    }
}

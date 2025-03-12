package org.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;  // 状态码
    private String message;    // 消息提示
    private T data;        // 响应数据（支持泛型）

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(null);
        return result;
    }
    public static Result error(String message) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

}

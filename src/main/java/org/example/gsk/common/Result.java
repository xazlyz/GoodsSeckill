package org.example.gsk.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Result<T> {
    private Integer code;//状态编码，成功1 其他失败
    private String msg;//返回信息
    private T data;   //返回数据
    private Map map=new HashMap ();

    public static <T> Result<T> success(T object)
    {
        Result<T> r=new Result<T> ();
        r.data=object;
        r.code=1;
        return r;
    }

    public static <T> Result<T> error(String msg)
    {
        Result<T> r=new Result<T>();
        r.code=0;
        r.msg=msg;
        return r;
    }

    public Result<T> add(String key,Object value)
    {
        this.map.put(key,value);
        return this;
    }
}

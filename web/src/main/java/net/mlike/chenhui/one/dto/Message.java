package net.mlike.chenhui.one.dto;

import org.springframework.http.HttpStatus;

public class Message<T>
{
    private int code;
    private String msg;
    private T data;

    public int getCode()
    {
        return this.code;
    }

    public static Message ok()
    {
        Message<String> message = new Message();
        message.setCode(HttpStatus.OK.value());
        return message;
    }

    public static Message failure(int code)
    {
        Message<String> message = new Message();
        message.setCode(code);
        return message;
    }

    public Message msg(String msg)
    {
        this.msg = msg;
        return this;
    }

    public Message code(int code)
    {
        this.code = code;
        return this;
    }

    public Message data(T data)
    {
        this.data = data;
        return this;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}

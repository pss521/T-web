package net.mlike.chenhui.one.dto;

public class Request<T>
{
    private T param;

    public Request(T param)
    {
        this.param = param;
    }

    public Request() {}

    public static <T> Request of(T param)
    {
        Request<T> request = new Request();
        request.param = (param == null ? (T)new Object() : param);
        return request;
    }

    public T getParam()
    {
        return this.param;
    }

    public void setParam(T param)
    {
        this.param = param;
    }
}

package net.mlike.chenhui.one.dto;

public class Param<T>
{
    private T param;

    public static <T> Param of(T param)
    {
        Param<T> request = new Param();
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

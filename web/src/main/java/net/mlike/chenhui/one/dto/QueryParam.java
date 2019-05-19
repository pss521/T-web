package net.mlike.chenhui.one.dto;

public class QueryParam<T>
{
    private T queryParam;

    public static <T> QueryParam of(T param)
    {
        QueryParam<T> request = new QueryParam();
        request.queryParam = (param == null ? (T)new Object() : param);
        return request;
    }

    public T getQueryParam()
    {
        return this.queryParam;
    }

    public void setQueryParam(T queryParam)
    {
        this.queryParam = queryParam;
    }
}

package net.mlike.chenhui.one.dto;

public class Dto<T>
{
    private T dto;

    public Dto(T dto)
    {
        this.dto = dto;
    }

    public Dto() {}

    public static <T> Dto of(T dto)
    {
        Dto<T> request = new Dto();
        request.dto = dto != null ? dto : (T)new Object();
        return request;
    }

    public T getDto()
    {
        return this.dto;
    }

    public void setDto(T dto)
    {
        this.dto = dto;
    }
}

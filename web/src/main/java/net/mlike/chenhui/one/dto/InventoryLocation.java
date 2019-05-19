package net.mlike.chenhui.one.dto;

public class InventoryLocation
{
    private Integer Quantity;
    private String Code;

    public Integer getQuantity()
    {
        return this.Quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.Quantity = quantity;
    }

    public String getCode()
    {
        return this.Code;
    }

    public void setCode(String code)
    {
        this.Code = code;
    }
}

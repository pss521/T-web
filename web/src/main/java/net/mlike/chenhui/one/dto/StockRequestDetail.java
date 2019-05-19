package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class StockRequestDetail
{
    private String Code;
    private CodeDto OutWarehouse;
    private CodeDto Inventory;
    private CustomItem[] CustomItems;
    private FreeItem[] FreeItems;
    private BigDecimal BaseQuantity;

    public String getCode()
    {
        return this.Code;
    }

    public void setCode(String code)
    {
        this.Code = code;
    }

    public CodeDto getOutWarehouse()
    {
        return this.OutWarehouse;
    }

    public void setOutWarehouse(CodeDto outWarehouse)
    {
        this.OutWarehouse = outWarehouse;
    }

    public CodeDto getInventory()
    {
        return this.Inventory;
    }

    public void setInventory(CodeDto inventory)
    {
        this.Inventory = inventory;
    }

    public CustomItem[] getCustomItems()
    {
        return this.CustomItems;
    }

    public void setCustomItems(CustomItem[] customItems)
    {
        this.CustomItems = customItems;
    }

    public FreeItem[] getFreeItems()
    {
        return this.FreeItems;
    }

    public void setFreeItems(FreeItem[] freeItems)
    {
        this.FreeItems = freeItems;
    }

    public BigDecimal getBaseQuantity()
    {
        return this.BaseQuantity;
    }

    public void setBaseQuantity(BigDecimal baseQuantity)
    {
        this.BaseQuantity = baseQuantity;
    }
}

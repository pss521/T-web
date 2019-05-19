package net.mlike.chenhui.one.dto;

public class GroupInfo
{
    private Boolean Warehouse;
    private Boolean Inventory;
    private Boolean Brand;
    private Boolean InvProperty;

    public Boolean getWarehouse()
    {
        return this.Warehouse;
    }

    public void setWarehouse(Boolean warehouse)
    {
        this.Warehouse = warehouse;
    }

    public Boolean getInventory()
    {
        return this.Inventory;
    }

    public void setInventory(Boolean inventory)
    {
        this.Inventory = inventory;
    }

    public Boolean getBrand()
    {
        return this.Brand;
    }

    public void setBrand(Boolean brand)
    {
        this.Brand = brand;
    }

    public Boolean getInvProperty()
    {
        return this.InvProperty;
    }

    public void setInvProperty(Boolean invProperty)
    {
        this.InvProperty = invProperty;
    }
}

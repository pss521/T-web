package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class InventoryPriceEntityDTO
{
    private String RowID;
    private String BusinessDate;
    private PartnerEntityDTO Partner;
    private InventoryEntityDTO Inventory;
    private UnitDTO Unit;
    private String Quantity;
    private BigDecimal Price;
    private BigDecimal DiscountRate;
    private BigDecimal DiscountPrice;
    private BigDecimal CashBackReturn;
    private Boolean WithTax;
    private String SelectFields;

    public String getRowID()
    {
        return this.RowID;
    }

    public void setRowID(String rowID)
    {
        this.RowID = rowID;
    }

    public String getBusinessDate()
    {
        return this.BusinessDate;
    }

    public void setBusinessDate(String businessDate)
    {
        this.BusinessDate = businessDate;
    }

    public PartnerEntityDTO getPartner()
    {
        return this.Partner;
    }

    public void setPartner(PartnerEntityDTO partner)
    {
        this.Partner = partner;
    }

    public InventoryEntityDTO getInventory()
    {
        return this.Inventory;
    }

    public void setInventory(InventoryEntityDTO inventory)
    {
        this.Inventory = inventory;
    }

    public UnitDTO getUnit()
    {
        return this.Unit;
    }

    public void setUnit(UnitDTO unit)
    {
        this.Unit = unit;
    }

    public String getQuantity()
    {
        return this.Quantity;
    }

    public void setQuantity(String quantity)
    {
        this.Quantity = quantity;
    }

    public BigDecimal getPrice()
    {
        return this.Price;
    }

    public void setPrice(BigDecimal price)
    {
        this.Price = price;
    }

    public BigDecimal getDiscountRate()
    {
        return this.DiscountRate;
    }

    public void setDiscountRate(BigDecimal discountRate)
    {
        this.DiscountRate = discountRate;
    }

    public BigDecimal getDiscountPrice()
    {
        return this.DiscountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice)
    {
        this.DiscountPrice = discountPrice;
    }

    public BigDecimal getCashBackReturn()
    {
        return this.CashBackReturn;
    }

    public void setCashBackReturn(BigDecimal cashBackReturn)
    {
        this.CashBackReturn = cashBackReturn;
    }

    public Boolean getWithTax()
    {
        return this.WithTax;
    }

    public void setWithTax(Boolean withTax)
    {
        this.WithTax = withTax;
    }

    public String getSelectFields()
    {
        return this.SelectFields;
    }

    public void setSelectFields(String selectFields)
    {
        this.SelectFields = selectFields;
    }
}

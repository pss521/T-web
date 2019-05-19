package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;
import java.util.List;

public class SaleDeliveryDetailDTO
{
    private WarehouseEntityDTO Warehouse;
    private ProjectDto Project;
    private InventoryEntityDTO Inventory;
    private String InventoryBarCode;
    private UnitDTO Unit;
    private UnitDTO Unit2;
    private BigDecimal UnitExchangeRate;
    private String Batch;
    private BigDecimal Quantity;
    private BigDecimal OrigPrice;
    private BigDecimal DiscountRate;
    private BigDecimal OrigDiscountPrice;
    private BigDecimal TaxRate;
    private BigDecimal OrigTaxPrice;
    private BigDecimal OrigDiscountAmount;
    private BigDecimal OrigTax;
    private BigDecimal OrigTaxAmount;
    private BigDecimal OrigDiscount;
    private BigDecimal ReceiveVoucherCode;
    private Boolean IsPresent;
    private String DeliveryDate;
    private Boolean IsManualCost;
    private BigDecimal CostAmount;
    private BigDecimal CostPrice;
    private InventoryLocationDTO[] inventoryLocations;
    private List<String> DynamicPropertyKeys;
    private List<String> DynamicPropertyValues;

    public WarehouseEntityDTO getWarehouse()
    {
        return this.Warehouse;
    }

    public void setWarehouse(WarehouseEntityDTO warehouse)
    {
        this.Warehouse = warehouse;
    }

    public ProjectDto getProject()
    {
        return this.Project;
    }

    public void setProject(ProjectDto project)
    {
        this.Project = project;
    }

    public InventoryEntityDTO getInventory()
    {
        return this.Inventory;
    }

    public void setInventory(InventoryEntityDTO inventory)
    {
        this.Inventory = inventory;
    }

    public String getInventoryBarCode()
    {
        return this.InventoryBarCode;
    }

    public void setInventoryBarCode(String inventoryBarCode)
    {
        this.InventoryBarCode = inventoryBarCode;
    }

    public UnitDTO getUnit()
    {
        return this.Unit;
    }

    public void setUnit(UnitDTO unit)
    {
        this.Unit = unit;
    }

    public UnitDTO getUnit2()
    {
        return this.Unit2;
    }

    public void setUnit2(UnitDTO unit2)
    {
        this.Unit2 = unit2;
    }

    public BigDecimal getUnitExchangeRate()
    {
        return this.UnitExchangeRate;
    }

    public void setUnitExchangeRate(BigDecimal unitExchangeRate)
    {
        this.UnitExchangeRate = unitExchangeRate;
    }

    public String getBatch()
    {
        return this.Batch;
    }

    public void setBatch(String batch)
    {
        this.Batch = batch;
    }

    public BigDecimal getQuantity()
    {
        return this.Quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.Quantity = quantity;
    }

    public BigDecimal getOrigPrice()
    {
        return this.OrigPrice;
    }

    public void setOrigPrice(BigDecimal origPrice)
    {
        this.OrigPrice = origPrice;
    }

    public BigDecimal getDiscountRate()
    {
        return this.DiscountRate;
    }

    public void setDiscountRate(BigDecimal discountRate)
    {
        this.DiscountRate = discountRate;
    }

    public BigDecimal getOrigDiscountPrice()
    {
        return this.OrigDiscountPrice;
    }

    public void setOrigDiscountPrice(BigDecimal origDiscountPrice)
    {
        this.OrigDiscountPrice = origDiscountPrice;
    }

    public BigDecimal getTaxRate()
    {
        return this.TaxRate;
    }

    public void setTaxRate(BigDecimal taxRate)
    {
        this.TaxRate = taxRate;
    }

    public BigDecimal getOrigTaxPrice()
    {
        return this.OrigTaxPrice;
    }

    public void setOrigTaxPrice(BigDecimal origTaxPrice)
    {
        this.OrigTaxPrice = origTaxPrice;
    }

    public BigDecimal getOrigDiscountAmount()
    {
        return this.OrigDiscountAmount;
    }

    public void setOrigDiscountAmount(BigDecimal origDiscountAmount)
    {
        this.OrigDiscountAmount = origDiscountAmount;
    }

    public BigDecimal getOrigTax()
    {
        return this.OrigTax;
    }

    public void setOrigTax(BigDecimal origTax)
    {
        this.OrigTax = origTax;
    }

    public BigDecimal getOrigTaxAmount()
    {
        return this.OrigTaxAmount;
    }

    public void setOrigTaxAmount(BigDecimal origTaxAmount)
    {
        this.OrigTaxAmount = origTaxAmount;
    }

    public BigDecimal getOrigDiscount()
    {
        return this.OrigDiscount;
    }

    public void setOrigDiscount(BigDecimal origDiscount)
    {
        this.OrigDiscount = origDiscount;
    }

    public BigDecimal getReceiveVoucherCode()
    {
        return this.ReceiveVoucherCode;
    }

    public void setReceiveVoucherCode(BigDecimal receiveVoucherCode)
    {
        this.ReceiveVoucherCode = receiveVoucherCode;
    }

    public Boolean getPresent()
    {
        return this.IsPresent;
    }

    public void setPresent(Boolean present)
    {
        this.IsPresent = present;
    }

    public String getDeliveryDate()
    {
        return this.DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate)
    {
        this.DeliveryDate = deliveryDate;
    }

    public Boolean getManualCost()
    {
        return this.IsManualCost;
    }

    public void setManualCost(Boolean manualCost)
    {
        this.IsManualCost = manualCost;
    }

    public BigDecimal getCostAmount()
    {
        return this.CostAmount;
    }

    public void setCostAmount(BigDecimal costAmount)
    {
        this.CostAmount = costAmount;
    }

    public BigDecimal getCostPrice()
    {
        return this.CostPrice;
    }

    public void setCostPrice(BigDecimal costPrice)
    {
        this.CostPrice = costPrice;
    }

    public InventoryLocationDTO[] getInventoryLocations()
    {
        return this.inventoryLocations;
    }

    public void setInventoryLocations(InventoryLocationDTO[] inventoryLocations)
    {
        this.inventoryLocations = inventoryLocations;
    }

    public List<String> getDynamicPropertyKeys()
    {
        return this.DynamicPropertyKeys;
    }

    public void setDynamicPropertyKeys(List<String> dynamicPropertyKeys)
    {
        this.DynamicPropertyKeys = dynamicPropertyKeys;
    }

    public List<String> getDynamicPropertyValues()
    {
        return this.DynamicPropertyValues;
    }

    public void setDynamicPropertyValues(List<String> dynamicPropertyValues)
    {
        this.DynamicPropertyValues = dynamicPropertyValues;
    }
}

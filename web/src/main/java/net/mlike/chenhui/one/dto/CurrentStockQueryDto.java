package net.mlike.chenhui.one.dto;

public class CurrentStockQueryDto
{
    private WarehouseEntityDTO[] Warehouse;
    private String InvBarCode;
    private String BeginInventoryCode;
    private String EndInventoryCode;
    private String InventoryName;
    private String Specification;
    private Boolean ReBarcode;
    private Boolean IsIncludeZero;
    private String Brand;
    private Integer PageSize;
    private Integer PageIndex;
    private String[] SkuCodes;
    private Boolean IsSkuOnly;
    private GroupInfo GroupInfo;

    public WarehouseEntityDTO[] getWarehouse()
    {
        return this.Warehouse;
    }

    public void setWarehouse(WarehouseEntityDTO[] warehouse)
    {
        this.Warehouse = warehouse;
    }

    public String getInvBarCode()
    {
        return this.InvBarCode;
    }

    public void setInvBarCode(String invBarCode)
    {
        this.InvBarCode = invBarCode;
    }

    public String getBeginInventoryCode()
    {
        return this.BeginInventoryCode;
    }

    public void setBeginInventoryCode(String beginInventoryCode)
    {
        this.BeginInventoryCode = beginInventoryCode;
    }

    public String getEndInventoryCode()
    {
        return this.EndInventoryCode;
    }

    public void setEndInventoryCode(String endInventoryCode)
    {
        this.EndInventoryCode = endInventoryCode;
    }

    public String getInventoryName()
    {
        return this.InventoryName;
    }

    public void setInventoryName(String inventoryName)
    {
        this.InventoryName = inventoryName;
    }

    public String getSpecification()
    {
        return this.Specification;
    }

    public void setSpecification(String specification)
    {
        this.Specification = specification;
    }

    public String getBrand()
    {
        return this.Brand;
    }

    public void setBrand(String brand)
    {
        this.Brand = brand;
    }

    public Integer getPageSize()
    {
        return this.PageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.PageSize = pageSize;
    }

    public Integer getPageIndex()
    {
        return this.PageIndex;
    }

    public void setPageIndex(Integer pageIndex)
    {
        this.PageIndex = pageIndex;
    }

    public String[] getSkuCodes()
    {
        return this.SkuCodes;
    }

    public void setSkuCodes(String[] skuCodes)
    {
        this.SkuCodes = skuCodes;
    }

    public Boolean getSkuOnly()
    {
        return this.IsSkuOnly;
    }

    public void setSkuOnly(Boolean skuOnly)
    {
        this.IsSkuOnly = skuOnly;
    }

    public GroupInfo getGroupInfo()
    {
        return this.GroupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo)
    {
        this.GroupInfo = groupInfo;
    }

    public Boolean getReBarcode()
    {
        return this.ReBarcode;
    }

    public void setReBarcode(Boolean reBarcode)
    {
        this.ReBarcode = reBarcode;
    }

    public Boolean getIncludeZero()
    {
        return this.IsIncludeZero;
    }

    public void setIncludeZero(Boolean includeZero)
    {
        this.IsIncludeZero = includeZero;
    }
}

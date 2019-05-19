package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class InventoryEntityDTO
{
    private String ID;
    private String Code;
    private String Name;
    private String Shorthand;
    private String Specification;
    private String DefaultBarCode;
    private InventoryClassDTO InventoryClass;
    private UnitDTO Unit;
    private EnumItemEntityDTO ProductInfo;
    private String Disabled;
    private UnitDTO UnitBySale;
    private UnitDTO UnitByRetail;
    private UnitDTO UnitByPurchase;
    private UnitDTO UnitByStock;
    private UnitDTO UnitByManufacture;
    private String IsPurchase;
    private String IsSale;
    private String IsMadeSelf;
    private String IsMaterial;
    private String IsSuite;
    private String IsLaborCost;
    private String TaxRate;
    private BigDecimal InvSCost;
    private BigDecimal LatestCost;
    private BigDecimal AvagCost;
    private BigDecimal Expired;
    private EnumItemEntityDTO ExpiredUnit;
    private InventoryImageEntity ImageList;
    private String Ts;
    private String PageSize;
    private String SelectFields = "Code,Name,Shorthand,Specification,DefaultBarCode,Disabled,IsPurchase,IsSale,IsMadeSelf,IsMaterial,IsSuite,IsLaborCost,Unit.Code,Unit.ID,Unit.Name,UnitBySale.Code,UnitBySale.ID,UnitBySale.Name,UnitByRetail.Code,UnitByRetail.ID,UnitByRetail.Name,UnitByPurchase.Code,UnitByPurchase.ID,UnitByPurchase.Name,UnitByStock.Code,UnitByStock.ID,UnitByStock.Name,UnitByManufacture.Code,UnitByManufacture.ID,UnitByManufacture.Name,InventoryClass.Code,ProductInfo.Code,ProductInfo.Name";

    public String getID()
    {
        return this.ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getCode()
    {
        return this.Code;
    }

    public void setCode(String code)
    {
        this.Code = code;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getShorthand()
    {
        return this.Shorthand;
    }

    public void setShorthand(String shorthand)
    {
        this.Shorthand = shorthand;
    }

    public String getSpecification()
    {
        return this.Specification;
    }

    public void setSpecification(String specification)
    {
        this.Specification = specification;
    }

    public String getDefaultBarCode()
    {
        return this.DefaultBarCode;
    }

    public void setDefaultBarCode(String defaultBarCode)
    {
        this.DefaultBarCode = defaultBarCode;
    }

    public InventoryClassDTO getInventoryClass()
    {
        return this.InventoryClass;
    }

    public void setInventoryClass(InventoryClassDTO inventoryClass)
    {
        this.InventoryClass = inventoryClass;
    }

    public UnitDTO getUnit()
    {
        return this.Unit;
    }

    public void setUnit(UnitDTO unit)
    {
        this.Unit = unit;
    }

    public EnumItemEntityDTO getProductInfo()
    {
        return this.ProductInfo;
    }

    public void setProductInfo(EnumItemEntityDTO productInfo)
    {
        this.ProductInfo = productInfo;
    }

    public String getDisabled()
    {
        return this.Disabled;
    }

    public void setDisabled(String disabled)
    {
        this.Disabled = disabled;
    }

    public UnitDTO getUnitBySale()
    {
        return this.UnitBySale;
    }

    public void setUnitBySale(UnitDTO unitBySale)
    {
        this.UnitBySale = unitBySale;
    }

    public UnitDTO getUnitByRetail()
    {
        return this.UnitByRetail;
    }

    public void setUnitByRetail(UnitDTO unitByRetail)
    {
        this.UnitByRetail = unitByRetail;
    }

    public UnitDTO getUnitByPurchase()
    {
        return this.UnitByPurchase;
    }

    public void setUnitByPurchase(UnitDTO unitByPurchase)
    {
        this.UnitByPurchase = unitByPurchase;
    }

    public UnitDTO getUnitByStock()
    {
        return this.UnitByStock;
    }

    public void setUnitByStock(UnitDTO unitByStock)
    {
        this.UnitByStock = unitByStock;
    }

    public UnitDTO getUnitByManufacture()
    {
        return this.UnitByManufacture;
    }

    public void setUnitByManufacture(UnitDTO unitByManufacture)
    {
        this.UnitByManufacture = unitByManufacture;
    }

    public String getIsPurchase()
    {
        return this.IsPurchase;
    }

    public void setIsPurchase(String isPurchase)
    {
        this.IsPurchase = isPurchase;
    }

    public String getIsSale()
    {
        return this.IsSale;
    }

    public void setIsSale(String isSale)
    {
        this.IsSale = isSale;
    }

    public String getIsMadeSelf()
    {
        return this.IsMadeSelf;
    }

    public void setIsMadeSelf(String isMadeSelf)
    {
        this.IsMadeSelf = isMadeSelf;
    }

    public String getIsMaterial()
    {
        return this.IsMaterial;
    }

    public void setIsMaterial(String isMaterial)
    {
        this.IsMaterial = isMaterial;
    }

    public String getIsSuite()
    {
        return this.IsSuite;
    }

    public void setIsSuite(String isSuite)
    {
        this.IsSuite = isSuite;
    }

    public String getIsLaborCost()
    {
        return this.IsLaborCost;
    }

    public void setIsLaborCost(String isLaborCost)
    {
        this.IsLaborCost = isLaborCost;
    }

    public String getTaxRate()
    {
        return this.TaxRate;
    }

    public void setTaxRate(String taxRate)
    {
        this.TaxRate = taxRate;
    }

    public BigDecimal getInvSCost()
    {
        return this.InvSCost;
    }

    public void setInvSCost(BigDecimal invSCost)
    {
        this.InvSCost = invSCost;
    }

    public BigDecimal getLatestCost()
    {
        return this.LatestCost;
    }

    public void setLatestCost(BigDecimal latestCost)
    {
        this.LatestCost = latestCost;
    }

    public BigDecimal getAvagCost()
    {
        return this.AvagCost;
    }

    public void setAvagCost(BigDecimal avagCost)
    {
        this.AvagCost = avagCost;
    }

    public BigDecimal getExpired()
    {
        return this.Expired;
    }

    public void setExpired(BigDecimal expired)
    {
        this.Expired = expired;
    }

    public EnumItemEntityDTO getExpiredUnit()
    {
        return this.ExpiredUnit;
    }

    public void setExpiredUnit(EnumItemEntityDTO expiredUnit)
    {
        this.ExpiredUnit = expiredUnit;
    }

    public InventoryImageEntity getImageList()
    {
        return this.ImageList;
    }

    public void setImageList(InventoryImageEntity imageList)
    {
        this.ImageList = imageList;
    }

    public String getTs()
    {
        return this.Ts;
    }

    public void setTs(String ts)
    {
        this.Ts = ts;
    }

    public String getPageSize()
    {
        return this.PageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.PageSize = pageSize;
    }

    public String getSelectFields()
    {
        return this.SelectFields;
    }
}

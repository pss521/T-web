package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class PartnerEntityDTO
{
    private String ID;
    private String Code;
    private String Name;
    private String Shorthand;
    private String PartnerAbbName;
    private EnumItemEntityDTO PartnerType;
    private PartnerClassDTO PartnerClass;
    private PartnerDTO SettlementPartner;
    private DepartmentDTO SaleDepartment;
    private PersonDTO SaleMan;
    private DistrictDTO District;
    private EnumItemEntityDTO PriceGrade;
    private String Disabled;
    private BigDecimal CreditBalance;
    private BigDecimal ARBalance;
    private BigDecimal AdvRBalance;
    private BigDecimal APBalance;
    private BigDecimal AdvPBalance;
    private String Ts;
    private PartnerAddressDTO PartnerAddress;
    private String SelectFields;

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

    public String getPartnerAbbName()
    {
        return this.PartnerAbbName;
    }

    public void setPartnerAbbName(String partnerAbbName)
    {
        this.PartnerAbbName = partnerAbbName;
    }

    public EnumItemEntityDTO getPartnerType()
    {
        return this.PartnerType;
    }

    public void setPartnerType(EnumItemEntityDTO partnerType)
    {
        this.PartnerType = partnerType;
    }

    public PartnerClassDTO getPartnerClass()
    {
        return this.PartnerClass;
    }

    public void setPartnerClass(PartnerClassDTO partnerClass)
    {
        this.PartnerClass = partnerClass;
    }

    public PartnerDTO getSettlementPartner()
    {
        return this.SettlementPartner;
    }

    public void setSettlementPartner(PartnerDTO settlementPartner)
    {
        this.SettlementPartner = settlementPartner;
    }

    public DepartmentDTO getSaleDepartment()
    {
        return this.SaleDepartment;
    }

    public void setSaleDepartment(DepartmentDTO saleDepartment)
    {
        this.SaleDepartment = saleDepartment;
    }

    public PersonDTO getSaleMan()
    {
        return this.SaleMan;
    }

    public void setSaleMan(PersonDTO saleMan)
    {
        this.SaleMan = saleMan;
    }

    public DistrictDTO getDistrict()
    {
        return this.District;
    }

    public void setDistrict(DistrictDTO district)
    {
        this.District = district;
    }

    public EnumItemEntityDTO getPriceGrade()
    {
        return this.PriceGrade;
    }

    public void setPriceGrade(EnumItemEntityDTO priceGrade)
    {
        this.PriceGrade = priceGrade;
    }

    public String getDisabled()
    {
        return this.Disabled;
    }

    public void setDisabled(String disabled)
    {
        this.Disabled = disabled;
    }

    public BigDecimal getCreditBalance()
    {
        return this.CreditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance)
    {
        this.CreditBalance = creditBalance;
    }

    public BigDecimal getARBalance()
    {
        return this.ARBalance;
    }

    public void setARBalance(BigDecimal ARBalance)
    {
        this.ARBalance = ARBalance;
    }

    public BigDecimal getAdvRBalance()
    {
        return this.AdvRBalance;
    }

    public void setAdvRBalance(BigDecimal advRBalance)
    {
        this.AdvRBalance = advRBalance;
    }

    public BigDecimal getAPBalance()
    {
        return this.APBalance;
    }

    public void setAPBalance(BigDecimal APBalance)
    {
        this.APBalance = APBalance;
    }

    public BigDecimal getAdvPBalance()
    {
        return this.AdvPBalance;
    }

    public void setAdvPBalance(BigDecimal advPBalance)
    {
        this.AdvPBalance = advPBalance;
    }

    public String getTs()
    {
        return this.Ts;
    }

    public void setTs(String ts)
    {
        this.Ts = ts;
    }

    public PartnerAddressDTO getPartnerAddress()
    {
        return this.PartnerAddress;
    }

    public void setPartnerAddress(PartnerAddressDTO partnerAddress)
    {
        this.PartnerAddress = partnerAddress;
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

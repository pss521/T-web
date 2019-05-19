package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PartnerDTO
{
    private String ID;
    private String Code;
    private String Name;
    private String PartnerAbbName;
    private EnumItem PartnerType;
    private PartnerDTO SettlementPartner;
    private String ShortHand;
    private BigDecimal SaleCreditLine;
    private Boolean SellCustomer;
    private Boolean RunShop;
    private Boolean Disabled;
    private Boolean AutoCreateMember;
    private MemberType MemberType;
    private String Representative;
    private EnumItem Accbank;
    private String BankAccount;
    private String TaxRegcode;
    private String CustomerAddressPhone;
    private EnumItem TaxRate;
    private EnumItem PriceGrade;
    private Boolean IsContainTaxOnPurchase;
    private BigDecimal priuserdefdecm1;
    private BigDecimal priuserdefdecm2;
    private BigDecimal priuserdefdecm3;
    private BigDecimal priuserdefdecm4;
    private BigDecimal priuserdefdecm5;
    private String priuserdefnvc1;
    private String priuserdefnvc2;
    private String priuserdefnvc3;
    private String priuserdefnvc4;
    private String priuserdefnvc5;
    private Date MadeRecordDate;
    private EnumItem SaleSettleStyle;
    private BigDecimal SaleCreditDays;
    private Date SaleStartDate;
    private Integer SaleSpaceMonth;
    private Integer SaleCheckMonth;
    private Integer SaleCheckDate;
    private EnumItem PurchaseSettleStyle;
    private BigDecimal PurchaseCreditDays;
    private Date PurchaseStartDate;
    private Integer PurchaseSpaceMonth;
    private Integer PurchaseCheckMonth;
    private Integer PurchaseCheckDate;
    private List<PartnerAddressDTO> PartnerAddresDTOs;

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

    public String getPartnerAbbName()
    {
        return this.PartnerAbbName;
    }

    public void setPartnerAbbName(String partnerAbbName)
    {
        this.PartnerAbbName = partnerAbbName;
    }

    public EnumItem getPartnerType()
    {
        return this.PartnerType;
    }

    public void setPartnerType(EnumItem partnerType)
    {
        this.PartnerType = partnerType;
    }

    public PartnerDTO getSettlementPartner()
    {
        return this.SettlementPartner;
    }

    public void setSettlementPartner(PartnerDTO settlementPartner)
    {
        this.SettlementPartner = settlementPartner;
    }

    public String getShortHand()
    {
        return this.ShortHand;
    }

    public void setShortHand(String shortHand)
    {
        this.ShortHand = shortHand;
    }

    public BigDecimal getSaleCreditLine()
    {
        return this.SaleCreditLine;
    }

    public void setSaleCreditLine(BigDecimal saleCreditLine)
    {
        this.SaleCreditLine = saleCreditLine;
    }

    public Boolean getSellCustomer()
    {
        return this.SellCustomer;
    }

    public void setSellCustomer(Boolean sellCustomer)
    {
        this.SellCustomer = sellCustomer;
    }

    public Boolean getRunShop()
    {
        return this.RunShop;
    }

    public void setRunShop(Boolean runShop)
    {
        this.RunShop = runShop;
    }

    public Boolean getDisabled()
    {
        return this.Disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.Disabled = disabled;
    }

    public Boolean getAutoCreateMember()
    {
        return this.AutoCreateMember;
    }

    public void setAutoCreateMember(Boolean autoCreateMember)
    {
        this.AutoCreateMember = autoCreateMember;
    }

    public MemberType getMemberType()
    {
        return this.MemberType;
    }

    public void setMemberType(MemberType memberType)
    {
        this.MemberType = memberType;
    }

    public String getRepresentative()
    {
        return this.Representative;
    }

    public void setRepresentative(String representative)
    {
        this.Representative = representative;
    }

    public EnumItem getAccbank()
    {
        return this.Accbank;
    }

    public void setAccbank(EnumItem accbank)
    {
        this.Accbank = accbank;
    }

    public String getBankAccount()
    {
        return this.BankAccount;
    }

    public void setBankAccount(String bankAccount)
    {
        this.BankAccount = bankAccount;
    }

    public String getTaxRegcode()
    {
        return this.TaxRegcode;
    }

    public void setTaxRegcode(String taxRegcode)
    {
        this.TaxRegcode = taxRegcode;
    }

    public String getCustomerAddressPhone()
    {
        return this.CustomerAddressPhone;
    }

    public void setCustomerAddressPhone(String customerAddressPhone)
    {
        this.CustomerAddressPhone = customerAddressPhone;
    }

    public EnumItem getTaxRate()
    {
        return this.TaxRate;
    }

    public void setTaxRate(EnumItem taxRate)
    {
        this.TaxRate = taxRate;
    }

    public EnumItem getPriceGrade()
    {
        return this.PriceGrade;
    }

    public void setPriceGrade(EnumItem priceGrade)
    {
        this.PriceGrade = priceGrade;
    }

    public Boolean getContainTaxOnPurchase()
    {
        return this.IsContainTaxOnPurchase;
    }

    public void setContainTaxOnPurchase(Boolean containTaxOnPurchase)
    {
        this.IsContainTaxOnPurchase = containTaxOnPurchase;
    }

    public BigDecimal getPriuserdefdecm1()
    {
        return this.priuserdefdecm1;
    }

    public void setPriuserdefdecm1(BigDecimal priuserdefdecm1)
    {
        this.priuserdefdecm1 = priuserdefdecm1;
    }

    public BigDecimal getPriuserdefdecm2()
    {
        return this.priuserdefdecm2;
    }

    public void setPriuserdefdecm2(BigDecimal priuserdefdecm2)
    {
        this.priuserdefdecm2 = priuserdefdecm2;
    }

    public BigDecimal getPriuserdefdecm3()
    {
        return this.priuserdefdecm3;
    }

    public void setPriuserdefdecm3(BigDecimal priuserdefdecm3)
    {
        this.priuserdefdecm3 = priuserdefdecm3;
    }

    public BigDecimal getPriuserdefdecm4()
    {
        return this.priuserdefdecm4;
    }

    public void setPriuserdefdecm4(BigDecimal priuserdefdecm4)
    {
        this.priuserdefdecm4 = priuserdefdecm4;
    }

    public BigDecimal getPriuserdefdecm5()
    {
        return this.priuserdefdecm5;
    }

    public void setPriuserdefdecm5(BigDecimal priuserdefdecm5)
    {
        this.priuserdefdecm5 = priuserdefdecm5;
    }

    public String getPriuserdefnvc1()
    {
        return this.priuserdefnvc1;
    }

    public void setPriuserdefnvc1(String priuserdefnvc1)
    {
        this.priuserdefnvc1 = priuserdefnvc1;
    }

    public String getPriuserdefnvc2()
    {
        return this.priuserdefnvc2;
    }

    public void setPriuserdefnvc2(String priuserdefnvc2)
    {
        this.priuserdefnvc2 = priuserdefnvc2;
    }

    public String getPriuserdefnvc3()
    {
        return this.priuserdefnvc3;
    }

    public void setPriuserdefnvc3(String priuserdefnvc3)
    {
        this.priuserdefnvc3 = priuserdefnvc3;
    }

    public String getPriuserdefnvc4()
    {
        return this.priuserdefnvc4;
    }

    public void setPriuserdefnvc4(String priuserdefnvc4)
    {
        this.priuserdefnvc4 = priuserdefnvc4;
    }

    public String getPriuserdefnvc5()
    {
        return this.priuserdefnvc5;
    }

    public void setPriuserdefnvc5(String priuserdefnvc5)
    {
        this.priuserdefnvc5 = priuserdefnvc5;
    }

    public Date getMadeRecordDate()
    {
        return this.MadeRecordDate;
    }

    public void setMadeRecordDate(Date madeRecordDate)
    {
        this.MadeRecordDate = madeRecordDate;
    }

    public EnumItem getSaleSettleStyle()
    {
        return this.SaleSettleStyle;
    }

    public void setSaleSettleStyle(EnumItem saleSettleStyle)
    {
        this.SaleSettleStyle = saleSettleStyle;
    }

    public BigDecimal getSaleCreditDays()
    {
        return this.SaleCreditDays;
    }

    public void setSaleCreditDays(BigDecimal saleCreditDays)
    {
        this.SaleCreditDays = saleCreditDays;
    }

    public Date getSaleStartDate()
    {
        return this.SaleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate)
    {
        this.SaleStartDate = saleStartDate;
    }

    public Integer getSaleSpaceMonth()
    {
        return this.SaleSpaceMonth;
    }

    public void setSaleSpaceMonth(Integer saleSpaceMonth)
    {
        this.SaleSpaceMonth = saleSpaceMonth;
    }

    public Integer getSaleCheckMonth()
    {
        return this.SaleCheckMonth;
    }

    public void setSaleCheckMonth(Integer saleCheckMonth)
    {
        this.SaleCheckMonth = saleCheckMonth;
    }

    public Integer getSaleCheckDate()
    {
        return this.SaleCheckDate;
    }

    public void setSaleCheckDate(Integer saleCheckDate)
    {
        this.SaleCheckDate = saleCheckDate;
    }

    public EnumItem getPurchaseSettleStyle()
    {
        return this.PurchaseSettleStyle;
    }

    public void setPurchaseSettleStyle(EnumItem purchaseSettleStyle)
    {
        this.PurchaseSettleStyle = purchaseSettleStyle;
    }

    public BigDecimal getPurchaseCreditDays()
    {
        return this.PurchaseCreditDays;
    }

    public void setPurchaseCreditDays(BigDecimal purchaseCreditDays)
    {
        this.PurchaseCreditDays = purchaseCreditDays;
    }

    public Date getPurchaseStartDate()
    {
        return this.PurchaseStartDate;
    }

    public void setPurchaseStartDate(Date purchaseStartDate)
    {
        this.PurchaseStartDate = purchaseStartDate;
    }

    public Integer getPurchaseSpaceMonth()
    {
        return this.PurchaseSpaceMonth;
    }

    public void setPurchaseSpaceMonth(Integer purchaseSpaceMonth)
    {
        this.PurchaseSpaceMonth = purchaseSpaceMonth;
    }

    public Integer getPurchaseCheckMonth()
    {
        return this.PurchaseCheckMonth;
    }

    public void setPurchaseCheckMonth(Integer purchaseCheckMonth)
    {
        this.PurchaseCheckMonth = purchaseCheckMonth;
    }

    public Integer getPurchaseCheckDate()
    {
        return this.PurchaseCheckDate;
    }

    public void setPurchaseCheckDate(Integer purchaseCheckDate)
    {
        this.PurchaseCheckDate = purchaseCheckDate;
    }

    public List<PartnerAddressDTO> getPartnerAddresDTOs()
    {
        return this.PartnerAddresDTOs;
    }

    public void setPartnerAddresDTOs(List<PartnerAddressDTO> partnerAddresDTOs)
    {
        this.PartnerAddresDTOs = partnerAddresDTOs;
    }
}

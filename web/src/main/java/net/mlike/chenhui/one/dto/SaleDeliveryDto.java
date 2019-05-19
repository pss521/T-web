package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class SaleDeliveryDto
{
    private String VoucherDate;
    private String ExternalCode;
    private String Code;
    private BusiTypeDTO BusinessType;
    private InvoiceType InvoiceType;
    private PartnerDTO Customer;
    private PartnerDTO SettleCustomer;
    private WarehouseEntityDTO Warehouse;
    private RdStyleDTO RdStyle;
    private Boolean IsAutoGenerateSaleOut;
    private DepartmentDTO Department;
    private PersonDTO Clerk;
    private ProjectDto Project;
    private CurrencyDTO Currency;
    private BigDecimal ExchangeRate;
    private String DeliveryDate;
    private DeliveryMode DeliveryMode;
    private ReciveType ReciveType;
    private String RecivingMaturity;
    private BigDecimal DiscountRate;
    private BigDecimal OrigSettleAmount;
    private BigDecimal OrigAllowances;
    private Boolean IsPriceTrace;
    private Boolean IsAutoGenerateInvoice;
    private Boolean IsSeparateByWareHouse;
    private MemberDTO MemberDTO;
    private String Address;
    private String LinkMan;
    private String ContactPhone;
    private String Maker;
    private String Memo;
    private SaleDeliverySettlementDTO[] SaleDeliverySettlements;
    private SaleDeliveryDetailDTO[] SaleDeliveryDetails;

    public String getExternalCode()
    {
        return this.ExternalCode;
    }

    public void setExternalCode(String externalCode)
    {
        this.ExternalCode = externalCode;
    }

    public String getCode()
    {
        return this.Code;
    }

    public void setCode(String code)
    {
        this.Code = code;
    }

    public BusiTypeDTO getBusinessType()
    {
        return this.BusinessType;
    }

    public void setBusinessType(BusiTypeDTO businessType)
    {
        this.BusinessType = businessType;
    }

    public InvoiceType getInvoiceType()
    {
        return this.InvoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType)
    {
        this.InvoiceType = invoiceType;
    }

    public PartnerDTO getCustomer()
    {
        return this.Customer;
    }

    public void setCustomer(PartnerDTO customer)
    {
        this.Customer = customer;
    }

    public PartnerDTO getSettleCustomer()
    {
        return this.SettleCustomer;
    }

    public void setSettleCustomer(PartnerDTO settleCustomer)
    {
        this.SettleCustomer = settleCustomer;
    }

    public WarehouseEntityDTO getWarehouse()
    {
        return this.Warehouse;
    }

    public void setWarehouse(WarehouseEntityDTO warehouse)
    {
        this.Warehouse = warehouse;
    }

    public RdStyleDTO getRdStyle()
    {
        return this.RdStyle;
    }

    public void setRdStyle(RdStyleDTO rdStyle)
    {
        this.RdStyle = rdStyle;
    }

    public Boolean getAutoGenerateSaleOut()
    {
        return this.IsAutoGenerateSaleOut;
    }

    public void setAutoGenerateSaleOut(Boolean autoGenerateSaleOut)
    {
        this.IsAutoGenerateSaleOut = autoGenerateSaleOut;
    }

    public DepartmentDTO getDepartment()
    {
        return this.Department;
    }

    public void setDepartment(DepartmentDTO department)
    {
        this.Department = department;
    }

    public PersonDTO getClerk()
    {
        return this.Clerk;
    }

    public void setClerk(PersonDTO clerk)
    {
        this.Clerk = clerk;
    }

    public ProjectDto getProject()
    {
        return this.Project;
    }

    public void setProject(ProjectDto project)
    {
        this.Project = project;
    }

    public CurrencyDTO getCurrency()
    {
        return this.Currency;
    }

    public void setCurrency(CurrencyDTO currency)
    {
        this.Currency = currency;
    }

    public BigDecimal getExchangeRate()
    {
        return this.ExchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate)
    {
        this.ExchangeRate = exchangeRate;
    }

    public String getDeliveryDate()
    {
        return this.DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate)
    {
        this.DeliveryDate = deliveryDate;
    }

    public DeliveryMode getDeliveryMode()
    {
        return this.DeliveryMode;
    }

    public void setDeliveryMode(DeliveryMode deliveryMode)
    {
        this.DeliveryMode = deliveryMode;
    }

    public ReciveType getReciveType()
    {
        return this.ReciveType;
    }

    public void setReciveType(ReciveType reciveType)
    {
        this.ReciveType = reciveType;
    }

    public String getRecivingMaturity()
    {
        return this.RecivingMaturity;
    }

    public void setRecivingMaturity(String recivingMaturity)
    {
        this.RecivingMaturity = recivingMaturity;
    }

    public BigDecimal getDiscountRate()
    {
        return this.DiscountRate;
    }

    public void setDiscountRate(BigDecimal discountRate)
    {
        this.DiscountRate = discountRate;
    }

    public BigDecimal getOrigSettleAmount()
    {
        return this.OrigSettleAmount;
    }

    public void setOrigSettleAmount(BigDecimal origSettleAmount)
    {
        this.OrigSettleAmount = origSettleAmount;
    }

    public BigDecimal getOrigAllowances()
    {
        return this.OrigAllowances;
    }

    public void setOrigAllowances(BigDecimal origAllowances)
    {
        this.OrigAllowances = origAllowances;
    }

    public Boolean getPriceTrace()
    {
        return this.IsPriceTrace;
    }

    public void setPriceTrace(Boolean priceTrace)
    {
        this.IsPriceTrace = priceTrace;
    }

    public Boolean getAutoGenerateInvoice()
    {
        return this.IsAutoGenerateInvoice;
    }

    public void setAutoGenerateInvoice(Boolean autoGenerateInvoice)
    {
        this.IsAutoGenerateInvoice = autoGenerateInvoice;
    }

    public Boolean getSeparateByWareHouse()
    {
        return this.IsSeparateByWareHouse;
    }

    public void setSeparateByWareHouse(Boolean separateByWareHouse)
    {
        this.IsSeparateByWareHouse = separateByWareHouse;
    }

    public MemberDTO getMemberDTO()
    {
        return this.MemberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO)
    {
        this.MemberDTO = memberDTO;
    }

    public String getAddress()
    {
        return this.Address;
    }

    public void setAddress(String address)
    {
        this.Address = address;
    }

    public String getLinkMan()
    {
        return this.LinkMan;
    }

    public void setLinkMan(String linkMan)
    {
        this.LinkMan = linkMan;
    }

    public String getContactPhone()
    {
        return this.ContactPhone;
    }

    public void setContactPhone(String contactPhone)
    {
        this.ContactPhone = contactPhone;
    }

    public String getMaker()
    {
        return this.Maker;
    }

    public void setMaker(String maker)
    {
        this.Maker = maker;
    }

    public String getMemo()
    {
        return this.Memo;
    }

    public void setMemo(String memo)
    {
        this.Memo = memo;
    }

    public SaleDeliverySettlementDTO[] getSaleDeliverySettlements()
    {
        return this.SaleDeliverySettlements;
    }

    public void setSaleDeliverySettlements(SaleDeliverySettlementDTO[] saleDeliverySettlements)
    {
        this.SaleDeliverySettlements = saleDeliverySettlements;
    }

    public String getVoucherDate()
    {
        return this.VoucherDate;
    }

    public void setVoucherDate(String voucherDate)
    {
        this.VoucherDate = voucherDate;
    }

    public SaleDeliveryDetailDTO[] getSaleDeliveryDetails()
    {
        return this.SaleDeliveryDetails;
    }

    public void setSaleDeliveryDetails(SaleDeliveryDetailDTO[] saleDeliveryDetails)
    {
        this.SaleDeliveryDetails = saleDeliveryDetails;
    }
}

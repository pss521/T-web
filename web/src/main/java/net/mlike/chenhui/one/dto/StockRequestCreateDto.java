package net.mlike.chenhui.one.dto;

public class StockRequestCreateDto
{
    private String ExternalCode;
    private String Code;
    private String VoucherDate;
    private CodeDto Store;
    private CodeDto Warehouse;
    private CodeDto OutWarehouse;
    private CodeDto BusiType;
    private CodeDto Person;
    private CodeDto Department;
    private CodeDto Project;
    private String Contact;
    private String TelePhone;
    private String ArrivalAddress;
    private String RequirementDate;
    private String StockRequestType;
    private String Memo;
    private Boolean IsAutoCreateTran;
    private CustomItem[] CustomItems;
    private FreeItem[] FreeItems;
    private StockRequestDetail[] StockRequestDetailList;
    private String Ts;

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

    public String getVoucherDate()
    {
        return this.VoucherDate;
    }

    public void setVoucherDate(String voucherDate)
    {
        this.VoucherDate = voucherDate;
    }

    public CodeDto getStore()
    {
        return this.Store;
    }

    public void setStore(CodeDto store)
    {
        this.Store = store;
    }

    public CodeDto getWarehouse()
    {
        return this.Warehouse;
    }

    public void setWarehouse(CodeDto warehouse)
    {
        this.Warehouse = warehouse;
    }

    public CodeDto getOutWarehouse()
    {
        return this.OutWarehouse;
    }

    public void setOutWarehouse(CodeDto outWarehouse)
    {
        this.OutWarehouse = outWarehouse;
    }

    public CodeDto getBusiType()
    {
        return this.BusiType;
    }

    public void setBusiType(CodeDto busiType)
    {
        this.BusiType = busiType;
    }

    public CodeDto getPerson()
    {
        return this.Person;
    }

    public void setPerson(CodeDto person)
    {
        this.Person = person;
    }

    public CodeDto getProject()
    {
        return this.Project;
    }

    public void setProject(CodeDto project)
    {
        this.Project = project;
    }

    public String getContact()
    {
        return this.Contact;
    }

    public void setContact(String contact)
    {
        this.Contact = contact;
    }

    public String getTelePhone()
    {
        return this.TelePhone;
    }

    public void setTelePhone(String telePhone)
    {
        this.TelePhone = telePhone;
    }

    public String getArrivalAddress()
    {
        return this.ArrivalAddress;
    }

    public void setArrivalAddress(String arrivalAddress)
    {
        this.ArrivalAddress = arrivalAddress;
    }

    public String getRequirementDate()
    {
        return this.RequirementDate;
    }

    public void setRequirementDate(String requirementDate)
    {
        this.RequirementDate = requirementDate;
    }

    public String getStockRequestType()
    {
        return this.StockRequestType;
    }

    public void setStockRequestType(String stockRequestType)
    {
        this.StockRequestType = stockRequestType;
    }

    public String getMemo()
    {
        return this.Memo;
    }

    public void setMemo(String memo)
    {
        this.Memo = memo;
    }

    public Boolean getAutoCreateTran()
    {
        return this.IsAutoCreateTran;
    }

    public void setAutoCreateTran(Boolean autoCreateTran)
    {
        this.IsAutoCreateTran = autoCreateTran;
    }

    public CodeDto getDepartment()
    {
        return this.Department;
    }

    public void setDepartment(CodeDto department)
    {
        this.Department = department;
    }

    public CustomItem[] getCustomItems()
    {
        return this.CustomItems;
    }

    public void setCustomItems(CustomItem[] customItems)
    {
        this.CustomItems = customItems;
    }

    public StockRequestDetail[] getStockRequestDetailList()
    {
        return this.StockRequestDetailList;
    }

    public void setStockRequestDetailList(StockRequestDetail[] stockRequestDetailList)
    {
        this.StockRequestDetailList = stockRequestDetailList;
    }

    public FreeItem[] getFreeItems()
    {
        return this.FreeItems;
    }

    public void setFreeItems(FreeItem[] freeItems)
    {
        this.FreeItems = freeItems;
    }

    public String getTs()
    {
        return this.Ts;
    }

    public void setTs(String ts)
    {
        this.Ts = ts;
    }
}

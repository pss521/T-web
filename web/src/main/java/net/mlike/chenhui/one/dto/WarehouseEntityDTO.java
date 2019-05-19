package net.mlike.chenhui.one.dto;

public class WarehouseEntityDTO
{
    private String ID;
    private String Code;
    private String Name;
    private String Address;
    private String Memo;
    private String Ts;
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

    public String getAddress()
    {
        return this.Address;
    }

    public void setAddress(String address)
    {
        this.Address = address;
    }

    public String getMemo()
    {
        return this.Memo;
    }

    public void setMemo(String memo)
    {
        this.Memo = memo;
    }

    public String getTs()
    {
        return this.Ts;
    }

    public void setTs(String ts)
    {
        this.Ts = ts;
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

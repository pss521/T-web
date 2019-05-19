package net.mlike.chenhui.one.dto;

public class BrandEntityDTO
{
    private String IdEnum;
    private String ID;
    private String Code;
    private String Name;
    private String Ts;
    private String SelectFields;

    public String getIdEnum()
    {
        return this.IdEnum;
    }

    public void setIdEnum(String idEnum)
    {
        this.IdEnum = idEnum;
    }

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

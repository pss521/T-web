package net.mlike.chenhui.one.dto;

public class StockRequestFindDto
{
    private String ID;
    private String Code;
    private String ExternalCode;

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

    public String getExternalCode()
    {
        return this.ExternalCode;
    }

    public void setExternalCode(String externalCode)
    {
        this.ExternalCode = externalCode;
    }
}

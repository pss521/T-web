package net.mlike.chenhui.one.dto;

public class StockRequestDeleteDto
{
    private String ExternalCode;
    private String Ts;

    public String getExternalCode()
    {
        return this.ExternalCode;
    }

    public void setExternalCode(String externalCode)
    {
        this.ExternalCode = externalCode;
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

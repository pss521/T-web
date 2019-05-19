package net.mlike.chenhui.one.dto;

public class SearchItem
{
    private String WhereName;
    private String CompareSign;
    private String ValueType;
    private String EnumName;
    private String IsBetween;
    private String BeginValue;
    private String EndValue;

    public String getWhereName()
    {
        return this.WhereName;
    }

    public void setWhereName(String whereName)
    {
        this.WhereName = whereName;
    }

    public String getCompareSign()
    {
        return this.CompareSign;
    }

    public void setCompareSign(String compareSign)
    {
        this.CompareSign = compareSign;
    }

    public String getValueType()
    {
        return this.ValueType;
    }

    public void setValueType(String valueType)
    {
        this.ValueType = valueType;
    }

    public String getEnumName()
    {
        return this.EnumName;
    }

    public void setEnumName(String enumName)
    {
        this.EnumName = enumName;
    }

    public String getIsBetween()
    {
        return this.IsBetween;
    }

    public void setIsBetween(String isBetween)
    {
        this.IsBetween = isBetween;
    }

    public String getBeginValue()
    {
        return this.BeginValue;
    }

    public void setBeginValue(String beginValue)
    {
        this.BeginValue = beginValue;
    }

    public String getEndValue()
    {
        return this.EndValue;
    }

    public void setEndValue(String endValue)
    {
        this.EndValue = endValue;
    }
}

package net.mlike.chenhui.one.dto;

public class StockRequestListDTO
{
    private String KeyWord;
    private String PageIndex;
    private String PageSize;
    private String DateRange;
    private String BeginDate;
    private String EndDate;
    private String ApproveState = "0";
    private String ID;
    private String idbusiType = "32";

    public String getKeyWord()
    {
        return this.KeyWord;
    }

    public void setKeyWord(String keyWord)
    {
        this.KeyWord = keyWord;
    }

    public String getPageIndex()
    {
        return this.PageIndex;
    }

    public void setPageIndex(String pageIndex)
    {
        this.PageIndex = pageIndex;
    }

    public String getPageSize()
    {
        return this.PageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.PageSize = pageSize;
    }

    public String getDateRange()
    {
        return this.DateRange;
    }

    public void setDateRange(String dateRange)
    {
        this.DateRange = dateRange;
    }

    public String getBeginDate()
    {
        return this.BeginDate;
    }

    public void setBeginDate(String beginDate)
    {
        this.BeginDate = beginDate;
    }

    public String getEndDate()
    {
        return this.EndDate;
    }

    public void setEndDate(String endDate)
    {
        this.EndDate = endDate;
    }

    public String getApproveState()
    {
        return this.ApproveState;
    }

    public void setApproveState(String approveState)
    {
        this.ApproveState = approveState;
    }

    public String getID()
    {
        return this.ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getIdbusiType()
    {
        return this.idbusiType;
    }

    public void setIdbusiType(String idbusiType)
    {
        this.idbusiType = idbusiType;
    }
}

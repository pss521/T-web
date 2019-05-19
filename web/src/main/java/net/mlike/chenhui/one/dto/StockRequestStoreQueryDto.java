package net.mlike.chenhui.one.dto;

public class StockRequestStoreQueryDto
{
    private String KeyWord;
    private String PageIndex;
    private String PageSize;

    public String getPageSize()
    {
        return this.PageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.PageSize = pageSize;
    }

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
}

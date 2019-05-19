package net.mlike.chenhui.one.dto;

public class InventoryImageEntity
{
    private String ImageUrl;
    private String IsDefault;

    public String getImageUrl()
    {
        return this.ImageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.ImageUrl = imageUrl;
    }

    public String getIsDefault()
    {
        return this.IsDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.IsDefault = isDefault;
    }
}

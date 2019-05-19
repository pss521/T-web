package net.mlike.chenhui.one.dto;

public class MemberDTO
{
    private MemberType MemberType;
    private String CardCode;
    private String Name;
    private String Mobilephone;
    private String Address;
    private String BirthDate;
    private String Email;
    private String QQ;

    public MemberType getMemberType()
    {
        return this.MemberType;
    }

    public void setMemberType(MemberType memberType)
    {
        this.MemberType = memberType;
    }

    public String getCardCode()
    {
        return this.CardCode;
    }

    public void setCardCode(String cardCode)
    {
        this.CardCode = cardCode;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getMobilephone()
    {
        return this.Mobilephone;
    }

    public void setMobilephone(String mobilephone)
    {
        this.Mobilephone = mobilephone;
    }

    public String getAddress()
    {
        return this.Address;
    }

    public void setAddress(String address)
    {
        this.Address = address;
    }

    public String getBirthDate()
    {
        return this.BirthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.BirthDate = birthDate;
    }

    public String getEmail()
    {
        return this.Email;
    }

    public void setEmail(String email)
    {
        this.Email = email;
    }

    public String getQQ()
    {
        return this.QQ;
    }

    public void setQQ(String QQ)
    {
        this.QQ = QQ;
    }
}

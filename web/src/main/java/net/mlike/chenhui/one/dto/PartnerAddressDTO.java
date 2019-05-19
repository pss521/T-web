package net.mlike.chenhui.one.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PartnerAddressDTO
{
    private String ID;
    private String Code;
    private String Name;
    private String ShipmentAddress;
    private EnumItem DeliveryMode;
    private String Contact;
    private String Position;
    private String MobilePhone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date Birthday;
    private String TelephoneNo;
    private String Fax;
    private String EmailAddr;
    private String QqNo;
    private String MsnAddress;
    private String UuNo;
    private String IsDefaultAddress;
    private String Status;

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

    public String getShipmentAddress()
    {
        return this.ShipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress)
    {
        this.ShipmentAddress = shipmentAddress;
    }

    public EnumItem getDeliveryMode()
    {
        return this.DeliveryMode;
    }

    public void setDeliveryMode(EnumItem deliveryMode)
    {
        this.DeliveryMode = deliveryMode;
    }

    public String getContact()
    {
        return this.Contact;
    }

    public void setContact(String contact)
    {
        this.Contact = contact;
    }

    public String getPosition()
    {
        return this.Position;
    }

    public void setPosition(String position)
    {
        this.Position = position;
    }

    public String getMobilePhone()
    {
        return this.MobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.MobilePhone = mobilePhone;
    }

    public Date getBirthday()
    {
        return this.Birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.Birthday = birthday;
    }

    public String getTelephoneNo()
    {
        return this.TelephoneNo;
    }

    public void setTelephoneNo(String telephoneNo)
    {
        this.TelephoneNo = telephoneNo;
    }

    public String getFax()
    {
        return this.Fax;
    }

    public void setFax(String fax)
    {
        this.Fax = fax;
    }

    public String getEmailAddr()
    {
        return this.EmailAddr;
    }

    public void setEmailAddr(String emailAddr)
    {
        this.EmailAddr = emailAddr;
    }

    public String getQqNo()
    {
        return this.QqNo;
    }

    public void setQqNo(String qqNo)
    {
        this.QqNo = qqNo;
    }

    public String getMsnAddress()
    {
        return this.MsnAddress;
    }

    public void setMsnAddress(String msnAddress)
    {
        this.MsnAddress = msnAddress;
    }

    public String getUuNo()
    {
        return this.UuNo;
    }

    public void setUuNo(String uuNo)
    {
        this.UuNo = uuNo;
    }

    public String getIsDefaultAddress()
    {
        return this.IsDefaultAddress;
    }

    public void setIsDefaultAddress(String isDefaultAddress)
    {
        this.IsDefaultAddress = isDefaultAddress;
    }

    public String getStatus()
    {
        return this.Status;
    }

    public void setStatus(String status)
    {
        this.Status = status;
    }
}

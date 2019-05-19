package net.mlike.chenhui.one.dto;

import java.math.BigDecimal;

public class SaleDeliverySettlementDTO
{
    private BigDecimal origAmount;
    private SettleStyleDTO SettleStyle;
    private BankAccountDTO BankAccount;
    private SaleDeliveryDetailDTO[] SaleDeliveryDetails;

    public BigDecimal getOrigAmount()
    {
        return this.origAmount;
    }

    public void setOrigAmount(BigDecimal origAmount)
    {
        this.origAmount = origAmount;
    }

    public SettleStyleDTO getSettleStyle()
    {
        return this.SettleStyle;
    }

    public void setSettleStyle(SettleStyleDTO settleStyle)
    {
        this.SettleStyle = settleStyle;
    }

    public BankAccountDTO getBankAccount()
    {
        return this.BankAccount;
    }

    public void setBankAccount(BankAccountDTO bankAccount)
    {
        this.BankAccount = bankAccount;
    }

    public SaleDeliveryDetailDTO[] getSaleDeliveryDetails()
    {
        return this.SaleDeliveryDetails;
    }

    public void setSaleDeliveryDetails(SaleDeliveryDetailDTO[] saleDeliveryDetails)
    {
        this.SaleDeliveryDetails = saleDeliveryDetails;
    }
}

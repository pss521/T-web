package net.mlike.chenhui.one.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.mlike.chenhui.one.dto.LoginDTO;

public class LoginParam
{
    private static final DateFormat FMT = new SimpleDateFormat("yy-MM-dd");
    @JsonProperty("UserName")
    private String username;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("AccountNumber")
    private String accountName;
    @JsonProperty("LoginDate")
    private String loginDate;

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAccountName()
    {
        return this.accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public String getLoginDate()
    {
        return this.loginDate;
    }

    public void setLoginDate(String loginDate)
    {
        this.loginDate = loginDate;
    }

    public static LoginParam convert(LoginDTO param)
    {
        LoginParam p = new LoginParam();
        p.setAccountName(param.getAccount());
        p.setLoginDate(FMT.format(new Date()));
        p.setPassword("1");
        return p;
    }
}

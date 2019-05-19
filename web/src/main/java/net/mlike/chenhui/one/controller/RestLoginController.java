package net.mlike.chenhui.one.controller;

import chanjet.sign.SignatureManage;
import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.LoginDTO;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"登陆相关"}, value="登陆登出")
public class RestLoginController
{
    private static final Logger LOG = LoggerFactory.getLogger(RestLoginController.class);
    @Value("${url.base}")
    private String baseUrl;
    @Value("${app.key}")
    private String key;
    @Value("${app.secret}")
    private String secret;
    @Value("${app.keyPath}")
    private String keyPath;

    @PostMapping({"/login"})
    @ApiOperation("登录")
    public Message login(@RequestBody LoginDTO param)
            throws Exception
    {
        ApiTool apiTool = new ApiTool(this.baseUrl);

        SignatureManage manage = new SignatureManage();
        String authStr = manage.CreateAuthorizationHeader(this.key, this.secret, "", this.keyPath, null);
        if (LOG.isErrorEnabled()) {
            LOG.error("User name: " + param.getUsername() + ", password " + param.getPassword() + ", accNum " + param.getAccount());
        }
        JsonObject accInfoJsonObj = new JsonObject();
        accInfoJsonObj.addProperty("userName", param.getUsername());
        accInfoJsonObj.addProperty("password", manage.getMD5(param.getPassword()));
        accInfoJsonObj.addProperty("accNum", param.getAccount());
        String accInfo = accInfoJsonObj.toString();

        String body = apiTool.getToken(authStr, accInfo);
        if (LOG.isErrorEnabled()) {
            LOG.error("Token: " + body);
        }
        String token = apiTool.getJson(body, "access_token");
        if (Strings.isNullOrEmpty(token)) {
            return Message.failure(400).data(body);
        }
        String auth = manage.CreateAuthorizationHeader(this.key, this.secret, "", this.keyPath, token);
        if (LOG.isErrorEnabled()) {
            LOG.error("Auth:" + auth);
        }
        return Message.ok().data(auth);
    }

    @PostMapping({"/logout"})
    @ApiOperation("登出")
    public Message logout()
    {
        ApiTool apiTool = new ApiTool(this.baseUrl);
        try
        {
            String token = CurrentUser.get();
            String data = apiTool.getData("Authorization/Logout", token, "");

            return Message.ok().data(data);
        }
        catch (Exception e)
        {
            LOG.warn(e.getMessage(), e);
            return Message.failure(500).data(e.getLocalizedMessage());
        }
    }
}

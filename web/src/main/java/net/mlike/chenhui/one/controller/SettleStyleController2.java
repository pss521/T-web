package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.Dto;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"结算方式"}, value="结算方式")
public class SettleStyleController2
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"SettleStyle/Query"})
    @ApiOperation("结算方式")
    public Message list()
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("SettleStyle/Query",
                            CurrentUser.get(),
                            JSON.toJSON(Dto.of(new Object()))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.PartnerEntityDTO;
import net.mlike.chenhui.one.dto.Request;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"往来单位查询(客户)"}, value="往来单位查询(客户)")
public class PartnerController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/partner/Query"})
    @ApiOperation("往来单位查询(客户)")
    public Message list(@RequestBody(required=false) PartnerEntityDTO dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("partner/Query",
                            CurrentUser.get(),
                            JSON.toJSON(Request.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

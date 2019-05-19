package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.BrandEntityDTO;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.Request;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"品牌"}, value="品牌相关")
public class BrandController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/brand/Query"})
    @ApiOperation("品牌查询")
    public Message list(@RequestBody(required=false) BrandEntityDTO dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("brand/Query",
                            CurrentUser.get(),
                            JSON.toJSON(Request.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

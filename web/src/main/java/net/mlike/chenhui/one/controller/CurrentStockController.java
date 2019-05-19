package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.CurrentStockQueryDto;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.Param;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/currentStock"})
@Api(tags={"现存量查询"}, value="现存量查询")
public class CurrentStockController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/Query"})
    @ApiOperation("现存量查询")
    public Message list(@RequestBody(required=false) Param<CurrentStockQueryDto> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("currentStock/Query",
                            CurrentUser.get(),
                            JSON.toJSON(dto)));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

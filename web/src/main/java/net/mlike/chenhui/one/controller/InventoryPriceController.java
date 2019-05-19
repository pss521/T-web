package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.InventoryPriceEntityDTO;
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
@Api(tags={"销售价格"}, value="销售价格")
public class InventoryPriceController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/inventoryPrice/QueryInventoryPrice"})
    @ApiOperation("销售价格查询")
    public Message list(@RequestBody(required=false) Request<InventoryPriceEntityDTO[]> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("inventoryPrice/QueryInventoryPrice",
                            CurrentUser.get(),
                            JSON.toJSON(dto)));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import net.mlike.chenhui.one.dto.DeleteSaleDeliveryDto;
import net.mlike.chenhui.one.dto.Dto;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.QueryParam;
import net.mlike.chenhui.one.dto.SaleDeliveryDto;
import net.mlike.chenhui.one.dto.SearchItem;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"销货单相关接口"}, value="销货单相关接口")
public class SaleDeliveryController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/saleDelivery/QueryExecuting"})
    @ApiOperation("销货单执行情况")
    public Message list(@RequestBody(required=false) List<SearchItem> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            dto = dto == null ? new ArrayList() : dto;
            return Message.ok().data(api
                    .getJson("saleDelivery/QueryExecuting",
                            CurrentUser.get(),
                            JSON.toJSON(QueryParam.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/saleDelivery/Delete"})
    @ApiOperation("销货单删除接口")
    public Message delete(@RequestBody(required=false) DeleteSaleDeliveryDto dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("saleDelivery/Delete",
                            CurrentUser.get(),
                            JSON.toJSON(Dto.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/saleDelivery/Create"})
    @ApiOperation("销货单创建")
    public Message create(@RequestBody(required=false) SaleDeliveryDto dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("saleDelivery/Create",
                            CurrentUser.get(),
                            JSON.toJSON(Dto.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

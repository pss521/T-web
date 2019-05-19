package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.Dto;
import net.mlike.chenhui.one.dto.InWarehouseCode;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.StockRequestCreateDto;
import net.mlike.chenhui.one.dto.StockRequestDeleteDto;
import net.mlike.chenhui.one.dto.StockRequestFindDto;
import net.mlike.chenhui.one.dto.StockRequestListDTO;
import net.mlike.chenhui.one.dto.StockRequestStoreQueryDto;
import net.mlike.chenhui.one.dto.WarehouseCodeDto;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("StockRequest")
@RequestMapping({"/StockRequest"})
@Api(tags={"要货单"}, value="要货单")
@Configuration
public class StockRequestController
{
    @Value("${url.base2}")
    private String baseUrl;

    @PostMapping({"/GetStockRequest_Store"})
    @ApiOperation("获取要货单门店列表")
    public Message getStore(@RequestBody(required=false) Dto<StockRequestStoreQueryDto> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/GetStockRequest_Store",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/GetStockRequest_OutWarehouse"})
    @ApiOperation("获取要货单出库仓库列表")
    public Message getOutwarehouse(@RequestBody(required=false) WarehouseCodeDto dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/GetStockRequest_OutWarehouse",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/GetStockRequest_InWarehouse"})
    @ApiOperation("获取要货单入库仓库列表")
    public Message getInWarehouse(@RequestBody(required=false) InWarehouseCode dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/GetStockRequest_InWarehouse",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/GetStockRequestsList"})
    @ApiOperation("要货单模糊查询接口")
    public Message getStockRequestsList(@RequestBody(required=false) Dto<StockRequestListDTO> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/GetStockRequestsList",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/Find"})
    @ApiOperation("要货单查询接口, 按照单据ID/单据编码/外部编码查询")
    public Message find(@RequestBody(required=false) Dto<StockRequestFindDto> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/Find",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/Delete"})
    @ApiOperation("要货单删除接口")
    public Message delete(@RequestBody(required=false) Dto<StockRequestDeleteDto> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/Delete",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }

    @PostMapping({"/Create"})
    @ApiOperation("要货单保存接口")
    public Message create(@RequestBody(required=false) Dto<StockRequestCreateDto> dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson2("StockRequest/Create",
                            CurrentUser.get(), dto));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

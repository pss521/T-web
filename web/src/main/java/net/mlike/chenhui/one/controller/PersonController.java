package net.mlike.chenhui.one.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mlike.chenhui.one.dto.Dto;
import net.mlike.chenhui.one.dto.Message;
import net.mlike.chenhui.one.dto.PersonDTO;
import net.mlike.chenhui.one.util.ApiTool;
import net.mlike.chenhui.one.util.CurrentUser;
import net.mlike.chenhui.one.util.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"人员"}, value="人员")
public class PersonController
{
    @Value("${url.base}")
    private String baseUrl;

    @PostMapping({"/person/Query"})
    @ApiOperation("人员查询")
    public Message list(@RequestBody(required=false) PersonDTO dto)
    {
        ApiTool api = new ApiTool(this.baseUrl);
        try
        {
            return Message.ok().data(api
                    .getJson("person/Query",
                            CurrentUser.get(),
                            JSON.toJSON(Dto.of(dto))));
        }
        catch (Exception e)
        {
            return Message.failure(500).msg(e.getLocalizedMessage());
        }
    }
}

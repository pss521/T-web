var addReturnRequestFun = function() {
    layui.use(['laytpl','laydate'], function () {
        var laytpl = layui.laytpl;
        var laydate = layui.laydate;

        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = addReturnRequestTmp.innerHTML
            ,view = document.getElementById('view');
        laytpl(getTpl).render({}, function(html){
            view.innerHTML = html;
        });
        $("#pullSignal").on("click",function(){
            location.hash = this.id;
            pages();
        });
        $("#selectreturnlist").on("click",function(){
            location.hash = this.id;
            sessionStorage.setItem("addpro1", JSON.stringify([]));
            var warehouse=$('#OutWarehouse').val();
            sessionStorage.setItem("OutWarehouse", warehouse);
            pages();
        })

        $("#addReturnoption").on("click",function(){
            if($("#Returnoptiondisplay").css("display") === "none"){
                $("#addReturnoption i").removeClass("layui-icon-down");
                $("#addReturnoption i").addClass("layui-icon-up");
                $("#Returnoptiondisplay").css("display","block");
            }else{
                $("#addoption i").removeClass("layui-icon-up");
                $("#addReturnoption i").addClass("layui-icon-down");
                $("#Returnoptiondisplay").css("display","none");
            }
        });

        $.post('/GetStockRequest_OutWarehouse',{parameter:JSON.stringify({warehouseCode:""})},function(data){

            $("#OutWarehouse").empty();
            data.data.WarehouseList.forEach(function(val,key){
                $("#OutWarehouse").append('<option data-outwarehouseid='+val.ID+' value="'+val.Code+'">'+val.Name+'</option>');
                if(key === data.data.WarehouseList.length-1){
                    $("#InWarehouse").empty();
                    $.post('/GetStockRequest_InWarehouse',{parameter:JSON.stringify({outWarehouseCode:$("#OutWarehouse").val()})},function(data1){

                        if(!data1.data.WarehouseList) return;
                        data1.data.WarehouseList.forEach(function(value){
                            console.log("in"+value);
                            $("#InWarehouse").append('<option data-outwarehouseid='+value.ID+' value="'+value.Code+'">'+value.Name+'</option>');
                        });
                    });
                }
            });
        });
        $("#OutWarehouse").change(function(){
            $("#InWarehouse").empty();
            $.post('/GetStockRequest_InWarehouse',{parameter:JSON.stringify({outWarehouseCode:$("#OutWarehouse").val()})},function(data1){

                if(!data1.data.WarehouseList) return;
                data1.data.WarehouseList.forEach(function(value){
                    $("#InWarehouse").append('<option data-outwarehouseid='+value.ID+' value="'+value.Code+'">'+value.Name+'</option>');
                });
            });

        });
        // laydate.render({
        //     elem: '#my-input'
        //     ,format: 'yyyy-MM-dd'
        // });
    });
};
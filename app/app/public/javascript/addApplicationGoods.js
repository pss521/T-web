var addApplicationGoodsFun = function() {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;

        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = addApplicationGoodsTmp.innerHTML
            ,view = document.getElementById('view');
        laytpl(getTpl).render({}, function(html){
            view.innerHTML = html;
        });
        $("#pullSignal").on("click",function(){
            location.hash = this.id;
            pages();
        });

        $("#selectproductlist").on("click",function(){
            location.hash = this.id;
            sessionStorage.setItem("addpro1", JSON.stringify([]));
            var warehouse=$('#OutWarehouse').val();
            sessionStorage.setItem("appOutWarehouse", warehouse);
            pages();
        })

        $("#addoption").on("click",function(){
            if($("#optiondisplay").css("display") === "none"){
                $("#addoption i").removeClass("layui-icon-down");
                $("#addoption i").addClass("layui-icon-up");
                $("#optiondisplay").css("display","block");
            }else{
                $("#addoption i").removeClass("layui-icon-up");
                $("#addoption i").addClass("layui-icon-down");
                $("#optiondisplay").css("display","none");
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
                            $("#InWarehouse").append('<option data-outwarehouseid='+value.ID+' value="'+value.Code+'">'+value.Name+'</option>');
                        });
                    });
                }
            });
        });

        $("#OutWarehouse").change(function(){
            $("#InWarehouse").empty();
            $.post('/GetStockRequest_InWarehouse',{parameter:JSON.stringify({outWarehouseCode:$("#OutWarehouse").val()})},function(data1){
                
                data1.data.WarehouseList.forEach(function(value){
                    $("#InWarehouse").append('<option data-outwarehouseid='+value.ID+' value="'+value.Code+'">'+value.Name+'</option>');
                });
            });
        });
    });
};
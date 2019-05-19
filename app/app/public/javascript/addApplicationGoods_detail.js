var addApplicationGoods_detailFun = function () {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        var layer = layui.layer;

        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = addApplicationGoods_detailTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });

        $('.weui-cell_swiped').swipeout()

        $("#pullSignal").on("click", function () {
            location.hash = this.id;
            pages();
        });
        $("#selectproductlist").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $("#submitrequiregoods").on('click', function () {
            var index22 = layer.load(1);
            var myDate = new Date();//获取系统当前时间
            var VoucherDate = myDate.getFullYear() + "-" + (myDate.getMonth() + 1) + "-" + myDate.getDate();
            var submitaddproarr = JSON.parse(sessionStorage["addpro1"]);
            var submitarr = [];
            if (submitaddproarr.length > 0) {
                submitaddproarr.forEach(function (val, index) {
                    submitarr.push({
                        "code": (index + 1).toString(),
                        "inventory": {
                            "code": val.Code,
                        },
                        "outWarehouse": {
                            "code": $("#OutWarehouse").val()
                        },
                        "baseQuantity": val.num
                    });
                });
            } else {
                layer.close(index22);
                return;
            }
            var json = {
                "dto": {
                    "externalCode": "",
                    "code": "",
                    "voucherDate": VoucherDate,
                    "warehouse": {
                        "code": $("#InWarehouse").val()
                    },
                    "outWarehouse": {
                        "code": $("#OutWarehouse").val()
                    },
                    "busiType": {
                        "code": "76"
                    },
                    "memo": $("#requiregoodsmemo").val(),
                    "stockRequestDetailList": submitarr
                }
            }

            $.post('/StockRequestCreate', { parameter: JSON.stringify(json) }, function (data) {
                layer.close(index22);
                console.log(data);
                if (data.data.Code) {
                    layer.alert('单据号：' + data.data.Code, { title: '保存成功' }, function (index) {
                        //do something
                        layer.close(index);
                        location.hash = "requireGoodsList";
                        pages();

                    });
                } else {
                    layer.alert('错误', { title: '保存错误' }, function (index) {
                        layer.close(index);
                    });
                }
            })
        });
        var addproarr = JSON.parse(sessionStorage["addpro1"]);
        if (addproarr.length > 0) {
            addproarr.forEach(function (val, key) {
                console.log(val);
                var html = '<div class="weui-cell weui-cell_swiped swipeout-touching">' +
                    '<div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">' +
                    '<div class="weui-cell">' +
                    '<div class="weui-cell__bd">' +
                    '<div class="cell-item">' +
                    '<div class="cell-left"  style="display:block;width: 50%;">' +
                    '<div>' +
                    '<p style="color:#000;">1.' + val.Name + '（' + val.Specification + '）</p>' +
                    '<p>待出可用量：<span></span></p>' +
                    '<p>数量：<span>' + val.num + '</span></p>' +
                    ' </div>' +
                    '</div>' +
                    '<div class="cell-right" style="display:block">' +
                    '<div style="line-height:72px">' +
                    ' <p>要货可用量：<span></span></p>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '<div class="weui-cell__ft">' +
                    '<a data-index="'+key+'" class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" style="line-height:72px;">删除</a>' +
                    '</div>' +
                    '</div>'

                $("#one_price_detail").append(html);
            });
            $('.weui-cell_swiped').swipeout()

            $('.delete-swipeout').on("click", function () {
                $deletedom = $(this);
                layer.confirm('您确认删除此存货?', { icon: 3, title: false }, function (index) {
                    //do something

                    addproarr.splice($deletedom.data("index"), 1);
                    sessionStorage.setItem("addpro1", JSON.stringify(addproarr))
                    location.reload()
                    layer.close(index);
                });
            });
        }
        $("#addoption").on("click", function () {
            if ($("#optiondisplay").css("display") === "none") {
                $("#addoption i").removeClass("layui-icon-down");
                $("#addoption i").addClass("layui-icon-up");
                $("#optiondisplay").css("display", "block");
            } else {
                $("#addoption i").removeClass("layui-icon-up");
                $("#addoption i").addClass("layui-icon-down");
                $("#optiondisplay").css("display", "none");
            }

        });
        var index11 = layer.load(1);
        $.post('/GetStockRequest_OutWarehouse', { parameter: JSON.stringify({ warehouseCode: "" }) }, function (data) {
            $("#OutWarehouse").empty();
            data.data.WarehouseList.forEach(function (val, key) {
                $("#OutWarehouse").append('<option data-outwarehouseid=' + val.ID + ' value="' + val.Code + '">' + val.Name + '</option>');
               /* if (key === data.data.WarehouseList.length - 1) {
                    $("#InWarehouse").empty();
                    $.post('/GetStockRequest_InWarehouse', { parameter: JSON.stringify({ outWarehouseCode: $("#OutWarehouse").val() }) }, function (data1) {

                        data1.data.WarehouseList.forEach(function (value, key1) {
                            $("#InWarehouse").append('<option data-outwarehouseid=' + value.ID + ' value="' + value.Code + '">' + value.Name + '</option>');
                            if (data1.data.WarehouseList.length - 1 == key1) {
                                layer.close(index11);
                            }
                        });
                    });
                }*/
            });
            $("#OutWarehouse").val(sessionStorage['appOutWarehouse']);
            $("#InWarehouse").empty();
            $.post('/GetStockRequest_InWarehouse', { parameter: JSON.stringify({ outWarehouseCode: $("#OutWarehouse").val() }) }, function (data1) {

                data1.data.WarehouseList.forEach(function (value, key1) {
                    $("#InWarehouse").append('<option data-outwarehouseid=' + value.ID + ' value="' + value.Code + '">' + value.Name + '</option>');
                    if (data1.data.WarehouseList.length - 1 == key1) {
                        layer.close(index11);
                    }
                });
            });
        });

        $("#OutWarehouse").change(function () {
            console.log($("#OutWarehouse").val());
            $("#InWarehouse").empty();
            $.post('/GetStockRequest_InWarehouse', { parameter: JSON.stringify({ outWarehouseCode: $("#OutWarehouse").val() }) }, function (data1) {

                data1.data.WarehouseList.forEach(function (value) {
                    $("#InWarehouse").append('<option data-outwarehouseid=' + value.ID + ' value="' + value.Code + '">' + value.Name + '</option>');
                });
            });
        });
    });
};
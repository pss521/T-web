var productListFun = function () {
    layui.use(['laytpl', 'form','element','layer'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        var element = layui.element;
        var layer = layui.layer;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = productListTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });
        var index111 = layer.load(1);
        //Code:'000000170664',SelectFields:'code,name,imageFile'
        $.post("/inventory", {parameter:JSON.stringify({param:{warehouse:[{code:sessionStorage['warehouse']}]}})}, function (data) {
            console.log("品牌:::", data);
            var product = data.data;
            var param = []; param.push();
            var warehouse = [];
            product.forEach(function (prod, index) {
                var html = '';
                html += '<div class="m-cell">';
                html += '<div class="cell-item">';
                html += '<div class="cell-left" style="display:block;width: 50%;">';
                html += '<div>';
                html += '<p>' + prod.Name + '(' + prod.Specification + ')</p>';
                html += '<p>可用量：<span  id="availableNum_'+prod.Code+'"></span><span id="availableUnitName_'+prod.Code+'"></span></p>';
                html += '<p>';
                html += '<input type="numbr" class="inputNum" style="width:50px;">';
                html += '<i data-name="' + prod.Name + '" data-specification="' + prod.Specification + '" data-code="' + prod.Code + '" style="margin-left:10px;font-size:20px;" class="layui-icon layui-icon-add-circle-fine addproduct"></i>';
                html += '</p>';
                html += '</div>';
                html += '</div>';
                html += '<div class="cell-right" style="display:block;line-height: 72px;">';
                html += '<div>';
                html += '<p><span id="code_' + prod.Code + '"></span></p>';
                html += '</div>';
                html += '</div>';
                html += '<div  id="productDetail" class="DetailCllick" style="line-height: 72px;">';
                html += '<i class="layui-icon layui-icon-right"></i>';
                html += '</div>';
                html += '</div>';
                html += '</div>';

                $('#product_list').append(html);
                param.push({
                    "partner": { "code": sessionStorage['cuscode'] },
                    "inventory": { "code": prod.Code },
                    "unit": { "code": prod.Unit.Code }
                });
                warehouse.push({code:prod.Code})
                
                if (product.length - 1 === index) {
                    console.log(JSON.stringify(param));
                    //
                    $.post('/currentStockQuery',{parameter:JSON.stringify({param:{warehouse:[{code:sessionStorage['warehouse']}]}})},function(currentStockQueryData){
                        console.log(currentStockQueryData);
                        currentStockQueryData.data.forEach(function(Stockdata){
                            var num=Stockdata.AvailableQuantity;
                            num=num.substring(0,num.indexOf("."));
                            $("#availableNum_"+Stockdata.InventoryCode).text(num);
                            $("#availableUnitName_"+Stockdata.InventoryCode).text(Stockdata.UnitName);
                        });
                    });
                    $.post("/QueryInventoryPrice", { "param": JSON.stringify(param) }, function (data) {
                        console.log("品牌:::", data);
                        var price = data.data;
                        price.forEach(function (pri, index1) {
                            $("#code_" + pri.Inventory.Code).html('最新售价：<span id="DiscountPrice_'+ pri.Inventory.Code +'">' + pri.DiscountPrice + '</span>元/<span id="Unit_'+pri.Inventory.Code+'">' + pri.Unit.Name+'</span>');

                            if (price.length - 1 === index1) {

                                


                                var addproductarr = JSON.parse(sessionStorage["addproduct"]);
                                $("#ShoppingCartNum").text(addproductarr.length);
                                layer.close(index111);
                                $(".addproduct").on("click", function () {
                                    addproductarr.push({
                                        Name: $(this).data("name"),
                                        Code: $(this).data("code"),
                                        Specification: $(this).data("specification"),
                                        num: 1,
                                        DiscountPrice: $("#DiscountPrice_" + $(this).data("code")).text(),
                                        Unit:$("#Unit_" + $(this).data("code")).text()
                                    });
                                    console.log(addproductarr);
                                    sessionStorage.setItem("addproduct", JSON.stringify(addproductarr));
                                    $("#ShoppingCartNum").text(addproductarr.length)
                                });

                                $("#addproduct").on("click", function () {
                                    for (var i = 0; i < $(".inputNum").length; i++) {
                                        console.log($($(".inputNum")[i]).val())
                                        if ($($(".inputNum")[i]).val() !== "") {
                                            addproductarr.push({
                                                Name: $($(".inputNum")[i]).next().data("name"),
                                                Code: $($(".inputNum")[i]).next().data("code"),
                                                Specification: $($(".inputNum")[i]).next().data("specification"),
                                                num: $($(".inputNum")[i]).val(),
                                                DiscountPrice: $("#DiscountPrice_" + $($(".inputNum")[i]).next().data("code")).text(),
                                                Unit:$("#Unit_" + $($(".inputNum")[i]).next().data("code")).text()
                                            });
                                            console.log(addproductarr);
                                            sessionStorage.setItem("addproduct", JSON.stringify(addproductarr));
                                            $("#ShoppingCartNum").text(addproductarr.length)
                                            $($(".inputNum")[i]).val("")
                                        }
                                    }
                                });

                                
                            }
                        })
                    });
                }
            })
        })


        $("#saleslist").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $(".DetailCllick").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $("#saleslist_goods").on("click", function () {
            sessionStorage.setItem("warehouse", sessionStorage['warehouse']);
            location.hash = this.id;
            pages();
        });

        var $tab = $('#J_Tab');

        // $tab.tab({
        //     nav: '.tab-nav-item',
        //     panel: '.tab-panel-item',
        //     activeClass: 'tab-active'
        // });

        // $tab.find('.tab-nav-item').on('open.ydui.tab', function (e) {
        //     console.log('索引：%s - [%s]正在打开', e.index, $(this).text());
        // });

        // $tab.find('.tab-nav-item').on('opened.ydui.tab', function (e) {
        //     console.log('索引：%s - [%s]已经打开了', e.index, $(this).text());
        // });
    });
};
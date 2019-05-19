var selectproductlistFun = function () {
    layui.use(['laytpl', 'form','element','layer'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        var element = layui.element;
        var layer = layui.layer;
        var addproarr = [];
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = selectproductlistTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });
        //var index111 = layer.load(1);
        $.post("/inventory", "", function (data) {
            console.log("品牌:::", data);
            var product = data.data;
            var param = []; param.push();
            product.forEach(function (prod, index) {
                var html = '';
                html += '<div class="m-cell">';
                html += '<div class="cell-item">';
                html += '<div class="cell-left" style="display:block;width: 50%;">';
                html += '<div>';
                html += '<p>' + prod.Name + '(' + prod.Specification + ')</p>';
                html += '<p>待出可用量：<span  id="availableNum_'+prod.Code+'"></span><span id="availableUnitName_'+prod.Code+'"></span></p>';
                html += '<p>';
                html += '<input type="numbr" class="inputNum" style="width:50px;">';
                html += '<i data-name="' + prod.Name + '" data-specification="' + prod.Specification + '" data-code="' + prod.Code + '" style="margin-left:10px;font-size:20px;" class="layui-icon layui-icon-add-circle-fine addproduct"></i>';
                html += '</p>';
                html += '</div>';
                html += '</div>';
                html += '<div class="cell-right" style="display:block;line-height: 72px;">';
                html += '<div>';
                html += '<p>要货可用量：<span  id="availableNum1_'+prod.Code+'"></span><span id="availableUnitName1_'+prod.Code+'"></span></p>';
                html += '</div>';
                html += '</div>';
                html += '<div  id="productDetail" class="DetailCllick" style="line-height: 72px;">';
                html += '<i class="layui-icon layui-icon-right"></i>';
                html += '</div>';
                html += '</div>';
                html += '</div>';

                $('#product_list').append(html);
                param.push({
                    "rowID": 1,
                    "businessDate": "2018-07-30",
                    "partner": { "code": sessionStorage['cuscode'] },
                    "inventory": { "code": prod.Code },
                    "unit": { "code": "2" },
                    "quantity": 10
                });
                if (product.length - 1 === index) {
                    $.post('/currentStockQuery',{parameter:JSON.stringify({param:{warehouse:[{code:sessionStorage['appOutWarehouse']}]}})},function(currentStockQueryData){
                        console.log(currentStockQueryData);
                        currentStockQueryData.data.forEach(function(Stockdata){
                            var num=Stockdata.AvailableQuantity;
                            num=num.substring(0,num.indexOf("."));
                            $("#availableNum_"+Stockdata.InventoryCode).text(num);
                            $("#availableUnitName_"+Stockdata.InventoryCode).text(Stockdata.UnitName);
                            $("#availableNum1_"+Stockdata.InventoryCode).text(num);
                            $("#availableUnitName1_"+Stockdata.InventoryCode).text(Stockdata.UnitName);
                            
                            
                        });
                        addproarr = JSON.parse(sessionStorage["addpro1"]);
                        $("#ShoppingCartNum").text(addproarr.length);
                        $(".addproduct").on("click", function () {
                            addproarr.push({
                                Name: $(this).data("name"),
                                Code: $(this).data("code"),
                                Specification: $(this).data("specification"),
                                num: 1,
                                Unit:$("#availableUnitName_" + $(this).data("code")).text()
                            });
                            console.log(addproarr);
                            sessionStorage.setItem("addpro1", JSON.stringify(addproarr));
                            $("#ShoppingCartNum").text(addproarr.length)
                        });

                        $("#addproduct").on("click", function () {
                            for (var i = 0; i < $(".inputNum").length; i++) {
                                console.log($($(".inputNum")[i]).val())
                                if ($($(".inputNum")[i]).val() !== "") {
                                    addproarr.push({
                                        Name: $($(".inputNum")[i]).next().data("name"),
                                        Code: $($(".inputNum")[i]).next().data("code"),
                                        Specification: $($(".inputNum")[i]).next().data("specification"),
                                        num: $($(".inputNum")[i]).val(),
                                        Unit:$("#availableUnitName_" + $($(".inputNum")[i]).next().data("code")).text()
                                    });
                                    console.log(addproarr);
                                    sessionStorage.setItem("addpro1", JSON.stringify(addproarr));
                                    $("#ShoppingCartNum").text(addproarr.length)
                                    $($(".inputNum")[i]).val("")
                                }
                            }
                        });
                    });
                }
            })
        })


        $("#addApplicationGoods").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $(".DetailCllick").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $("#addApplicationGoods_detail").on("click", function () {
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
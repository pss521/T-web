var tuihuo_saleslist_goodsFun = function () {
    layui.use(['laytpl', 'form','layer'], function () {
        var laytpl = layui.laytpl;
        var layer = layui.layer;
        var form = layui.form;
        var qujianum = 0;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var cusCode = sessionStorage["tuihuo_cuscode"];
        var cusName = sessionStorage["tuihuo_cusname"];
        var getTpl = tuihuo_saleslist_goodsTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });
        // $.get("/partner", function (data) {
        //     var list = data.data;

        //     list.forEach(function (item, index) {
        //         if (item.Code === cusCode) {
        //             var html = '<option value="' + item.Code + '" selected>' + item.Name + '</option>';
        //         } else {
        //             var html = '<option value="' + item.Code + '">' + item.Name + '</option>';
        //         }

        //         $('#tuihuo_customer_list').append(html);
        //     })
        // })
        var html = '<option value="0020000">移动和包用户</option>';
        $('#tuihuo_customer_list').append(html);

        $.get("/warehouse", function (data) {
            var warehouse = data.data;

            warehouse.forEach(function (ware, index) {
                var html = '<option value="' + ware.Code + '">' + ware.Name + '</option>';
                $('#tuihuo_warehouse').append(html);
                $('#tuihuo_warehouse').val(sessionStorage['tuihuowarehouse']);
            })

        })

        $.post('/Project', '', function (data) {
            var Project = data.data;
            console.log("Project",data);
            Project.forEach(function (pro, index) {
                var html = '<option value="' + pro.Code + '">' + pro.Name + '</option>';
                $('#tuihuo_project_list').append(html);
            })
        })

        $.post("/person", { code: cusCode, name: cusName }, function (data) {

            var person_list = data.data;
            person_list.forEach(function (per, index) {
                var html = '<option value="' + per.Code + '">' + per.Name + '</option>';
                $("#tuihuo_person").append(html);
            })
        })
        
        var one_price = JSON.parse(sessionStorage['tuihuo_addproduct']);
        $("#tuihuo_product_num").text(one_price.length);
        var total_num = 0;
        one_price.forEach(function (price, index) {
            console.log('单价:::', price);
            total_num += parseInt(price.num);
            var html = ""
            html += '<div class="weui-cell weui-cell_swiped swipeout-touching">'
            html += '<div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">'
            html += '<div class="weui-cell">'
            html += '<div class="weui-cell__bd">'
            html += '<div class="cell-item">'
            html += '<div class="cell-left"  style="display:block;width: 50%;">'
            html += '<div>'
            html += '<p style="color:#000;">' + index + '.' + price.Name + '(' + price.Specification + ')</p>'
            html += '<p>单价：<input type="number" style="width:72px;" id="tuihuo_goodsmoney_' + (price.Code + index) + '"></p>'
            html += '<p>金额：<span id="tuihuo_moneygoods_' + (price.Code + index) + '"></span></p>'
            html += '</div>'
            html += '</div>'
            html += '<div class="cell-right" style="display:block;margin-left: -1000px;">'
            html += '<div style="line-height:72px">'
            html += '<p>数量：<input type="number" style="width:72px;" class="tuihuo_pricenum"  value="' + (price.num * -1) + '"> 瓶</p>'
            html += '</div>'
            html += '</div>'
            html += '</div>'
            html += '</div>'
            html += '</div>'
            html += '</div>'
            html += '<div class="weui-cell__ft">'
            html += '<a data-index="'+index+'" class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" style="line-height:72px;">删除</a>'
            html += '</div>'
            html += '</div>'
            $("#tuihuo_one_price").append(html);

        });
        
        $("#tuihuo_total_num").text(total_num * -1);

        $('.weui-cell_swiped').swipeout()

        $(".tuihuo_pricenum").on("keyup",function(){
            if(!Number($(this).val())){
                $(this).val(0)
            }
            if(Number($(this).val()) > 0){
                $(this).val($(this).val() * -1);
            }
        });

        $('.delete-swipeout').on("click",function(){
            $deletedom = $(this);
            layer.confirm('您确认删除次存货?', {icon: 3, title:false}, function(index){
                //do something
                
                one_price.splice($deletedom.data("index"), 1);
                sessionStorage.setItem("tuihuo_addproduct",JSON.stringify(one_price))
                location.reload()
                layer.close(index);
              });
        });

        $("#order").on("click", function () {
            sessionStorage.setItem("tuihuo_addproduct",JSON.stringify([]))
            location.hash = this.id;
            pages();
        });
        //取价
        $("#tuihuo_qujia").on("click", function () {
            var total_money = 0.00;
            one_price.forEach(function (val, key) {
                $("#tuihuo_goodsmoney_" + val.Code + key).val(val.DiscountPrice);
                $("#tuihuo_moneygoods_" + val.Code + key).text(val.DiscountPrice * val.num);
                total_money += Number(val.DiscountPrice * val.num);
                qujianum = 1;
            });
            $("#tuihuo_total_money").text(total_money * -1);
        });

        $("#tuihuo_submit ").on("click", function () {
            var SaleDeliveryDetails = [];
            if (qujianum != 1) {
                alert("请取价");
                return false;
            }
            if ($("#tuihuo_customer_list").val() === "") {
                alert("请选择客户");
                return false;
            }
            if ($("#tuihuo_project_list").val() === "") {
                alert("请选择项目");
                return false;
            }
            console.log("asdfasfasfd'")
            layer.tab({
                area: '350px',
                btn: ['提交', '取消'],
                btnAlign: 'c',
                tab: [{
                  title: '现结', 
                  id:"asasas",
                  content:  '<div class="m-cell">'+
                            '    <div class="cell-item">'+
                            '        <div class="cell-left">总金额：</div>'+
                            '        <div class="cell-right"><input type="number" id="tuihuo_total_money1" pattern="[0-9]*" class="cell-input" value="" /></div>'+
                            '   </div>'+
                            '    <div class="cell-item">'+
                            '        <div class="cell-left">抹零：</div>'+
                            '        <div class="cell-right"><input type="number" pattern="[0-9]*" class="cell-input" placeholder="请输入" autocomplete="off" /></div>'+
                            '    </div>'+
                            '    <div class="cell-item">'+
                            '        <div class="cell-left">结算方式：</div>'+      
                            '        <label class="cell-right cell-arrow">'+
                            '            <select class="cell-select" id="tuihuo_SettleStyle1">'+
                            '            </select>'+
                            '        </label>'+
                            '    </div>'+
                            '    <div class="cell-item">'+
                            '        <div class="cell-left">账号：</div>'+
                            '        <label class="cell-right cell-arrow">'+
                            '            <select class="cell-select" id="tuihuo_BankAccount1">'+
                            '            </select>'+
                            '        </label>'+
                            '    </div>'+
                            '    <div class="cell-item">'+
                            '        <div class="cell-left">现结：</div>'+
                            '        <div class="cell-right"><input type="number" pattern="[0-9]*" class="cell-input" id="xianjieSettleStyle" placeholder="请输入" autocomplete="off" /></div>'+
                            '    </div>'+
                            '</div>'
                }, {
                  title: '赊账', 
                  content: '<div class="m-cell">'+
                  '    <div class="cell-item">'+
                  '        <div class="cell-left">总金额：</div>'+
                  '        <div class="cell-right"><input type="number" id="tuihuo_total_money2" pattern="[0-9]*" class="cell-input" value="" /></div>'+
                  '   </div>'+
                  '    <div class="cell-item">'+
                  '        <div class="cell-left">抹零：</div>'+
                  '        <div class="cell-right"><input type="number" pattern="[0-9]*" class="cell-input" placeholder="请输入" autocomplete="off" /></div>'+
                  '    </div>'+
                  '    <div class="cell-item">'+
                  '        <div class="cell-left">结算方式：</div>'+      
                  '        <label class="cell-right cell-arrow">'+
                  '            <select class="cell-select" id="tuihuo_SettleStyle">'+
                  '            </select>'+
                  '        </label>'+
                  '    </div>'+
                  '    <div class="cell-item">'+
                  '        <div class="cell-left">账号：</div>'+
                  '        <label class="cell-right cell-arrow">'+
                  '            <select class="cell-select" id="tuihuo_BankAccount">'+
                  '            </select>'+
                  '        </label>'+
                  '    </div>'+
                  '    <div class="cell-item">'+
                  '        <div class="cell-left">现结：</div>'+
                  '        <div class="cell-right"><input type="number" pattern="[0-9]*" class="cell-input" id="xianjieSettleStyle" placeholder="请输入" autocomplete="off" /></div>'+
                  '    </div>'+
                  '</div>'
                }],
                success:function(){
                    $(".layui-layer-content").css("overflow","unset");
                    $("#tuihuo_total_money1").val($("#tuihuo_total_money").text());
                    $("#tuihuo_total_money2").val($("#tuihuo_total_money").text());
                    $("#xianjieSettleStyle1").val($("#total_money").text());
                    $("#xianjieSettleStyle").val($("#total_money").text());

                    // //结算方式
                    // $.post("/SettleStyle",function(data){
                    //     console.log("结算方式:",data);
                    //     data.data.forEach(function(val){
                    //         $("#tuihuo_SettleStyle").append('<option value="'+val.Code+'">'+val.Name+'</option>');
                    //         $("#tuihuo_SettleStyle1").append('<option value="'+val.Code+'">'+val.Name+'</option>');
                    //     });
                    // });
                    $("#tuihuo_SettleStyle").append('<option value="0">和包支付卷</option>');
                    $("#tuihuo_SettleStyle1").append('<option value="0">和包支付卷</option>');

                    //银行账户
                    $.post("/BankAccount",function(data){
                        console.log("银行账户:",data);
                        data.data.forEach(function(val){
                            $("#tuihuo_BankAccount").append('<option value="'+val.Code+'">'+val.Name+'</option>');
                            $("#tuihuo_BankAccount1").append('<option value="'+val.Code+'">'+val.Name+'</option>');
                        });
                    });

                },yes: function(index, layero){
                    //按钮【按钮一】的回调
                    var index1 = layer.load();
                    for (var i = 0; i < one_price.length; i++) {
                        SaleDeliveryDetails.push({
                            inventory: { code: one_price[i].Code },
                            unit: { name: one_price[i].Unit },
                            quantity: String(one_price[i].num * -1),
                            origPrice: String(one_price[i].DiscountPrice * -1)
                        });
                    }
                    var jsondata = {
                        externalCode: "1",
                        customer: { code: $("#tuihuo_customer_list").val() },
                        invoiceType: { code: "02" },
                        warehouse:{code: $("#tuihuo_warehouse").val()},
                        memo: $("#tuihuo_Memo").val(),
                        project: { code: $("#tuihuo_project_list").val()},
                        saleDeliveryDetails: SaleDeliveryDetails,
                        // saleDeliverySettlements:[{
                        //     origAmount:"",
                        //     settleStyle:{code:""},
                        //     bankAccount:{name:""}
                        // }]
                    }
                    // if($(".layui-layer-title .layui-this").text() === "现结"){
                    //     jsondata.saleDeliverySettlements[0].origAmount = $("#tuihuo_total_money1").val();
                    //     jsondata.saleDeliverySettlements[0].settleStyle.code = $("#tuihuo_SettleStyle1").val();
                    //     jsondata.saleDeliverySettlements[0].bankAccount.name = $("#tuihuo_BankAccount1").val();
                    // }else{
                    //     jsondata.saleDeliverySettlements[0].origAmount = $("#tuihuo_total_money2").val();
                    //     jsondata.saleDeliverySettlements[0].settleStyle.code = $("#tuihuo_SettleStyle").val();
                    //     jsondata.saleDeliverySettlements[0].bankAccount.name = $("#tuihuo_BankAccount").val()
                    // }
                    console.log(jsondata);
                    $.post("/saleDeliveryCreate", {parameter:JSON.stringify(jsondata)}, function (data) {
                        console.log("saleDeliveryCreate::", data);
                        if(data.data == null){
                            sessionStorage.setItem("tuihuo_addproduct",JSON.stringify([]))
                            location.hash = "salesBill";
                            layer.close(index1); 
                            pages();
                            layer.close(index);
                        }else{
                            layer.msg(data.data.message);
                            layer.close(index1); 
                        }
                        
                        
                    });
                },
                cancel: function(){ 
                    //右上角关闭回调
                    
                    
                    //return false 开启该代码可禁止点击该按钮关闭
                },
                end: function(){
                    $(".layui-layer-content").css("overflow","");
                }
              });
            
        });
        $("#tuihuo_productList").on("click", function () {
            location.hash = this.id;
            pages();
        });

        $("#tuihuo_up_down").on("click", function () {
            if ($("#tuihuo_optiondisplay").css("display") === "none") {
                $("#tuihuo_up_down i").removeClass("layui-icon-down");
                $("#tuihuo_up_down i").addClass("layui-icon-up");
                $("#tuihuo_optiondisplay").css("display", "block");
            } else {
                $("#tuihuo_up_down i").removeClass("layui-icon-up");
                $("#tuihuo_up_down i").addClass("layui-icon-down");
                $("#tuihuo_optiondisplay").css("display", "none");
            }
        })
    });
};
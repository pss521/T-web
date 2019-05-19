var salesFun = function () {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = salesTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });

        form.render('select');
        var param = []; param.push();
        var now = new Date(); //当前日期
        var nowDayOfWeek = now.getDay(); //今天本周的第几天
        var nowDay = now.getDate(); //当前日
        var nowMonth = now.getMonth(); //当前月
        var nowYear = now.getYear(); //当前年
        form.on('select(daterange)', function (data) {
            var a=$("#daterange").val();
            var b=$("#approvestate").val();
            init(a,b);
        });
        function init(a,b){
            param=[];
            var oDate = new Date(),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth() + 1,
                oDay = oDate.getDate(),
                oHour = oDate.getHours(),
                oMin = oDate.getMinutes(),
                oSen = oDate.getSeconds();
        /*    param.push( {
                "whereName":"SaleDelivery_Customer.Code",
                "beginValue":"0020000"
            });*/
            if(a==1){
                param.push( {
                    "whereName":"SaleDelivery.Voucherdate",
                    "isBetween":"true",
                   "beginValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay),// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen),
                    "endValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen)
                });
            }else  if(a==2){
                param.push( {
                    "whereName":"SaleDelivery.Voucherdate",
                    "isBetween":"true",
                    "beginValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay-1),// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen),
                    "endValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay-1) + '  23:59:59'
                });
            }else  if(a==3){
                param.push( {
                    "whereName":"SaleDelivery.Voucherdate",
                    "isBetween":"true",
                    "beginValue":getWeekStartDate(),
                    "endValue":getWeekEndDate()
                });
            }else  if(a==4){
                param.push( {
                    "whereName":"SaleDelivery.Voucherdate",
                    "isBetween":"true",
                    "beginValue":oYear + '-' + getzf(oMonth) + '-01' ,// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen),
                    "endValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + '  23:59:59'
                });
            }else  if(a==5){
                param.push( {
                    "whereName":"SaleDelivery.Voucherdate",
                    "isBetween":"true",
                    "beginValue":oYear + '-01-01' ,// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen),
                    "endValue":oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + '  23:59:59'
                });
            }
            if(b=='00'){
                param.push( {
                    "whereName":"SaleDelivery.VoucherState",
                    "ValueType":"enum",
                    "enumName":"VoucherState",
                    "beginValue":"00"
                });
            }else  if(b=='01'){
                param.push( {
                    "whereName":"SaleDelivery.VoucherState",
                    "ValueType":"enum",
                    "enumName":"VoucherState",
                    "beginValue":"01"
                });
            }
            xiaohuogetlist();
        }

        form.on('select(approvestate)', function (data) {
            var a=$("#daterange").val();
            var b=$("#approvestate").val();
            init(a,b);



        });
        //格式化日期：yyyy-MM-dd
        function formatDate(date) {
            var myyear = date.getFullYear();
            var mymonth = date.getMonth()+1;
            var myweekday = date.getDate();

            if(mymonth < 10){
                mymonth = "0" + mymonth;
            }
            if(myweekday < 10){
                myweekday = "0" + myweekday;
            }
            return (myyear+"-"+mymonth + "-" + myweekday);
        }
        //获得本周的开始日期
        function getWeekStartDate() {
            var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
            return formatDate(weekStartDate);
        }
        //获得本周的结束日期
        function getWeekEndDate() {
            var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
            return formatDate(weekEndDate);
        }
        var aa=$("#daterange").val();
        var bb=$("#approvestate").val();
        init(aa,bb);
        function xiaohuogetlist() {
            $("#query_sales").empty();
            $("#quantitytext").text("0");
            $("#ExecutingList").text("0");
            $("#origTaxAmounttext").text("￥ 0");
            $("#zongshoukuan").text("￥ 0");
            $.post("/QueryExecuting", { "queryParam": JSON.stringify(param) }, function (data) {
                console.log("====》::",data);

                var list = data.data.Rows;

                console.log("rows::", list);

                var quantity = 0;
                var origTaxAmount = 0;
                list.forEach(function (item, index) {
                    quantity += Number(item.quantity);
                    origTaxAmount += Number(item.origTaxAmount);
                    var voucherdate = getMyDate(Number(((item.voucherdate).split("(")[1]).split(")")[0]));
                    var html = '';
                    console.log('index::', index + '-' + item.partnerName);
                    html += '<div class="cell-item"><div class="cell-left" style="display:block;width: 50%;">';
                    html += '<div style="margin:15px">';
                    html += '<p>' + item.partnerName + '</p><br />';
                    html += '<p>' + item.saleDeliveryCode + '</p>';
                    html += '</div></div>';

                    html += '<div class="cell-right" style="display:block;line-height: 25px;">';
                    html += '<div style="margin:15px">';
                    html += '<p style="color: red">未审</p>';
                    html += '<p>' + voucherdate + '</p>';
                    html += '<p>' + item.origTaxAmount + '元</p>';
                    html += '</div></div></div>';

                    $("#query_sales").append(html);

                    if(list.length-1 == index ){
                        $("#quantitytext").text(quantity);
                        $("#ExecutingList").text(list.length);
                        $("#origTaxAmounttext").text("￥"+origTaxAmount);
                        $("#zongshoukuan").text("￥"+origTaxAmount);
                    }
                })
            })
        }





        $("#order").on("click", function () {
            location.hash = this.id;
            pages();
        })

        $("#add_exit").on("click", function () {

            $.actions({
                title: "选择操作",
                onClose: function () {
                    console.log("close");
                },
                actions: [
                    {
                        text: "发布",
                        className: "color-primary",
                        onClick: function () {
                            $.alert("发布成功");
                        }
                    },
                    {
                        text: "编辑",
                        className: "color-warning",
                        onClick: function () {
                            $.alert("你选择了“编辑”");
                        }
                    },
                    {
                        text: "删除",
                        className: 'color-danger',
                        onClick: function () {
                            $.alert("你选择了“删除”");
                        }
                    }
                ]
            });

        })
        function getNow() {
            var oDate = new Date(),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth() + 1,
                oDay = oDate.getDate(),
                oHour = oDate.getHours(),
                oMin = oDate.getMinutes(),
                oSen = oDate.getSeconds(),
                oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay)// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen);//最后拼接时间
            return oTime;
        };

        function getMyDate(str) {
            var oDate = new Date(str),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth() + 1,
                oDay = oDate.getDate(),
                oHour = oDate.getHours(),
                oMin = oDate.getMinutes(),
                oSen = oDate.getSeconds(),
                oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay)// + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen);//最后拼接时间  
            return oTime;
        };
        //补0操作
        function getzf(num) {
            if (parseInt(num) < 10) {
                num = '0' + num;
            }
            return num;
        }

    });
};
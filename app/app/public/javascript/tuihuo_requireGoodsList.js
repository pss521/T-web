function tuihuo_requireGoodsListFun() {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;

        var getTpl = tuihuo_requireGoodsListTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });
        form.render('select');
        $("#pullSignal").on("click", function () {
            location.hash = this.id;
            pages();
        });

        form.on('select(daterange1)', function (data) {
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
            tuihuogetlist();
        });

        form.on('select(approvestate1)', function (data) {
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
            tuihuogetlist();
        });

        tuihuogetlist();
        function tuihuogetlist() {
            $("#StockRequestsList").empty();
            $.post('/GetStockRequestsList', {
                parameter: JSON.stringify({
                    "dto": {
                        "keyWord": "",
                        "pageIndex": "1",
                        "pageSize": "10000000",
                        "dateRange": $("#daterange").val(),
                        "beginDate": "",
                        "enddate": "",
                        "approveState": $("#approvestate").val(),
                        "idbusiType": "33"
                    }
                })
            }, function (data) {
                console.log(data);
                $("#TotalInventoryCount").text(data.data.TotalInventoryCount);
                $("#TotalVoucherCount").text(data.data.TotalVoucherCount);
                data.data.StockRequestList.forEach(function (val) {
                    var html = '<div class="cell-item">' +
                        '<div class="cell-left" style="display:block">' +
                        '<div>' +
                        '<br/><p>' + val.Code + '</p>' +
                        '<p>有1种1件商品</p>' +
                        '</div>' +

                        '</div>' +
                        '<div class="cell-right"  style="display:block;">' +
                        '<div>' +
                        '<p style="color: red">' + val.VoucherState.Name + '</p><br/>' +
                        '<p>' + val.VoucherDate + ' ' + val.DateOfweek + '</p>' +
                        '</div>' +
                        '</div>' +
                        '</div>';

                    $("#StockRequestsList").append(html);

                });
            });
        }

    })
}
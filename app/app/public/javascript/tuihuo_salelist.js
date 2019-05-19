var tuihuo_salelistFun = function () {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var cusCode = sessionStorage["tuihuo_cuscode"];
        var cusName = sessionStorage["tuihuo_cusname"];
        var getTpl = tuihuo_salelistTmp.innerHTML
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

        //         $('#customer_list').append(html);
        //     })
        // })
        var html = '<option value="0020000">移动和包用户</option>';
        $('#customer_list').append(html);

        $.get("/warehouse", function (data) {
            var warehouse = data.data;

            warehouse.forEach(function (ware, index) {
                var html = '<option value="' + ware.Code + '">' + ware.Name + '</option>';
                $('#warehouse').append(html);
            })
        })

        $.post('/Project', '', function (data) {
            var Project = data.data;

            Project.forEach(function (pro, index) {
                var html = '<option value="' + pro.Code + '">' + pro.Name + '</option>';
                $('#project_list').append(html);
            })
        })

        $.post("/person", { code: cusCode, name: cusName }, function (data) {

            var person_list = data.data;
            person_list.forEach(function (per, index) {
                var html = '<option value="' + per.Code + '">' + per.Name + '</option>';
                $("#person").append(html);
            })
        })
        $("#order").on("click", function () {
            location.hash = this.id;
            pages();
        })

        $("#tuihuo_productList").on("click", function () {
            sessionStorage.setItem("tuihuo_addproduct", JSON.stringify([]));

            var warehouse=$('#warehouse').val();

            sessionStorage.setItem("tuihuowarehouse", warehouse);
            location.hash = this.id;
            pages();
        })

        $("#up_down").on("click", function () {
            if ($("#optiondisplay").css("display") === "none") {
                $("#up_down i").removeClass("layui-icon-down");
                $("#up_down i").addClass("layui-icon-up");
                $("#optiondisplay").css("display", "block");
            } else {
                $("#up_down i").removeClass("layui-icon-up");
                $("#up_down i").addClass("layui-icon-down");
                $("#optiondisplay").css("display", "none");
            }
        })
    });
};
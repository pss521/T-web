var saleslistFun = function () {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var cusCode = sessionStorage["cuscode"];
        var cusName = sessionStorage["cusname"];
        var getTpl = saleslistTmp.innerHTML
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

        $.post("/person", {code: cusCode, name: cusName}, function (data) {

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

        $("#productList").on("click", function () {
            sessionStorage.setItem("addproduct", JSON.stringify([]));
            var warehouse = $('#warehouse').val();
            sessionStorage.setItem("warehouse", warehouse);
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
        var qr=GetQueryString("qrresult");
        if(qr){
            alert(qr);
            $("#result").html(qr);
        }
        function GetQueryString(name)
        {
            var reg = new RegExp("\\b"+ name +"=([^&]*)");
            var r = location.href.match(reg);
            if (r!=null) return unescape(r[1]);
        }

/*        $.ajax({
            type:"post",
            url:"http://t.zhcweb.com:3000/#saleslist",//自己填写请求地址
            data:{},
            success:function(result){
                alert(result);
                wx.config({
                    // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    debug: false,
                    // 必填，公众号的唯一标识
                    appId: result.appId,
                    // 必填，生成签名的时间戳
                    timestamp:""+result.timestamp,
                    // 必填，生成签名的随机串
                    nonceStr:result.noncestr,
                    // 必填，签名，见附录1
                    signature:result.signature,
                    // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                    jsApiList : [ 'checkJsApi', 'scanQRCode' ]
                });
            }
        })

        wx.error(function(res) {
            alert("出错了：" + res.errMsg);//这个地方的好处就是wx.config配置错误，会弹出窗口哪里错误，然后根据微信文档查询即可。
        });

        wx.ready(function() {
            wx.checkJsApi({
                jsApiList : ['scanQRCode'],
                success : function(res) {

                }
            });

            //点击按钮扫描二维码
            document.querySelector('#scanQRCode').onclick = function() {
                wx.scanQRCode({
                    needResult : 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                    scanType : [ "qrCode"], // 可以指定扫二维码还是一维码，默认二者都有
                    success : function(res) {
                        var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                        window.location.href = result;//因为我这边是扫描后有个链接，然后跳转到该页面
                    }
                });
            };

        });*/


    });
};
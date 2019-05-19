var tuihuo_selectcustomerFun = function () {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = tuihuo_selectcustomerTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });

        $("#order").on("click", function () {
            location.hash = this.id;
            pages();
        });
        
        // $.get("/partner",function(data){
        //     console.log('customer::',data);
        //     var customer = data.data;

        //     var html = '';

        //     customer.forEach(function(cus,index){
        //         console.log('cus::',cus + '===>' + index);
        //         html += '<a class="cell-item" href="javascript:;">';
        //         html += '<div data-cuscode="'+ cus.Code +'" data-cusname="'+ cus.Name +'" class="cell-left">';
        //         html += cus.Name;
        //         html += '</div>';
        //         html += '<div class="cell-right">';
        //         html += '<i class="layui-icon layui-icon-username"></i>';
        //         html += '</div></a>'

                
        //     });
        //     $('#customerlist').html(html);
            
        //     $(".cell-item").on("click",function(){
        //         $cusCode = $($(this).children(".cell-left")[0]);
        //         var cusCode= $cusCode.data("cuscode");
        //         var cusName= $cusCode.data("cusname");
        //         sessionStorage.setItem("tuihuo_cuscode",cusCode);
        //         sessionStorage.setItem("tuihuo_cusname",cusName);
        //         location.hash = 'tuihuo_salelist';
        //         pages();
        //     });
        // })
        var html="";
        html += '<a class="cell-item" href="javascript:;">';
        html += '<div data-cuscode="0020000" data-cusname="移动和包用户" class="cell-left">';
        html += '移动和包用户';
        html += '</div>';
        html += '<div class="cell-right">';
        html += '<i class="layui-icon layui-icon-username"></i>';
        html += '</div></a>'
        $('#customerlist').html(html);
        
        $(".cell-item").on("click",function(){
            $cusCode = $($(this).children(".cell-left")[0]);
            var cusCode= $cusCode.data("cuscode");
            var cusName= $cusCode.data("cusname");
            sessionStorage.setItem("cuscode",cusCode);
            sessionStorage.setItem("cusname",cusName);
            location.hash = 'tuihuo_salelist';
            pages();
        });

        
    });
};
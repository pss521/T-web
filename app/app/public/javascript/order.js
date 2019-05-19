var orderFun = function() {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        console.log("dsfsfds")
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = orderTmp.innerHTML
            ,view = document.getElementById('view');
        laytpl(getTpl).render({}, function(html){
            view.innerHTML = html;
        });

        $("#index1").on("click",function(){
            location.hash = "";
            pages();
        });
        $(".cell-item").on("click",function(){
            location.hash = this.id;
            pages();
        });

        $(".grids-item").on("click",function(){
            location.hash = this.id;
            pages();
        })
    });
};

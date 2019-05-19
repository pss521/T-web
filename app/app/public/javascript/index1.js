var index1Fun = function() {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = index1Tmp.innerHTML
            ,view = document.getElementById('view');
        laytpl(getTpl).render({}, function(html){
            view.innerHTML = html;
        });

        $(".grids-item").on("click",function(){
            location.hash = this.id;
            pages();
        });

        $("#logout").on('click',function(){
            layer.confirm('是否要退出登录?', {icon: 3, title:'提示'}, function(index){
                //do something
                $.post('/logout',function(data){
                    if(data === "success"){
                        window.location.href="/";
                    }
                });
                layer.close(index);
              });
        })
    });
};
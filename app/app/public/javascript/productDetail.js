var productDetailFun = function () {
    layui.use(['laytpl', 'form'], function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        /*var data = { //数据
            "title":"Layui常用模块"
            ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
        }*/
        var getTpl = productDetailTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });
        form.render('checkbox');
        form.render('select');
        $("#productList").on("click", function () {
            location.hash = this.id;
            pages();
        });
        
        $("#productListReturn").on("click", function () {
            location.hash = "productList";
            pages();
        })

    });
};
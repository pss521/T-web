function pullSignalFun() {
    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;


        var getTpl = pullSignalTmp.innerHTML
            , view = document.getElementById('view');
        laytpl(getTpl).render({}, function (html) {
            view.innerHTML = html;
        });

        $("#addApplicationGoods").on("click", function () {
            location.hash = this.id;
            pages();
        });
        $("#index1").on("click", function () {
            location.hash = "";
            pages();
        });
        $("#addReturnRequest").on("click", function () {
            location.hash = this.id;
            pages();
        });
        $("#requireGoodsList").on("click", function () {
            location.hash = this.id;
            pages();
        });
        $("#tuihuo_requireGoodsList").on("click", function () {
            location.hash = this.id;
            pages();
        });

        

        // $.post('/GetStockRequestsList',{parameter:JSON.stringify({"dto": {approveState:0,DateRange:1}})},function(data){
        //     console.log(data);
        // });
    })
}
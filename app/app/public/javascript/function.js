
layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;


    var javascript = [
        "./javascript/index1.js",
        "./javascript/order.js",
        "./javascript/sales.js",

        "./javascript/pullSignal.js",
        "./javascript/addApplicationGoods.js",
        "./javascript/addReturnRequest.js",
        "./javascript/requireGoodsList.js",
        "./javascript/tuihuo_requireGoodsList.js",
        "./javascript/saleslist.js",
        "./javascript/saleslist_goods.js",
        "./javascript/productList.js",
        "./javascript/selectCustomer.js",
        "./javascript/productDetail.js",
        "./javascript/tuihuo_productList.js",
        "./javascript/tuihuo_saleslist_goods.js",
        "./javascript/tuihuo_selectcustomer.js",
        "./javascript/tuihuo_salelist.js",
        "./javascript/addApplicationGoods_detail.js",
        "./javascript/selectproductlist.js",
        "./javascript/selectreturnlist.js",
        "./javascript/addReturnRequest_detail.js"
    ];


    var count = 0;

    var index = layer.load(2);
    isload(count, javascript);


    function isload(count, javascript) {
        setTimeout(function () {

            $.getScript(javascript[count], function (response, status) {
                if (status !== "success") {
                    layer.msg('加载[' + javascript[count] + ']失败，请刷新后重试!', { icon: 2 });
                }

                count++;

                if (count === javascript.length) {
                    layer.close(index);
                    pages();
                } else {
                    isload(count, javascript);
                }
            });
        }, 1)
    }

});
function pages() {
    var layid = location.hash.replace(/^#/, '');
    switch (layid) {
        case "":
            index1Fun();
            break;
        case "order":
            orderFun();
            break;
        case "salesBill":
            salesFun();
            break;
        case "pullSignal":
            pullSignalFun();
            break;
        case "addApplicationGoods":
            addApplicationGoodsFun();
            break;
        case "addReturnRequest":
            addReturnRequestFun();
            break;
        case "requireGoodsList":
            requireGoodsListFun();
            break;
        case "tuihuo_requireGoodsList":
            tuihuo_requireGoodsListFun();
            break;
        case "saleslist":
            saleslistFun();
            break;
        case "saleslist_goods":
            saleslist_goodsFun();
            break;
        case "productList":
            productListFun();
            break;
        case "selectCustomer":
            selectCustomerFun();
            break;
        case "productDetail"://商品详情未使用
            productDetailFun();
            break;
        case "tuihuo_productList":
            tuihuo_productListFun();
            break;
        case "tuihuo_saleslist_goods":
            tuihuo_saleslist_goodsFun();
            break;
        case "tuihuo_selectcustomer":
            tuihuo_selectcustomerFun();
            break;
        case "tuihuo_salelist":
            tuihuo_salelistFun();
            break;
        case "addApplicationGoods_detail":
            addApplicationGoods_detailFun();
            break;
        case "selectproductlist":
            selectproductlistFun();
            break;
        case "selectreturnlist":
            selectreturnlistFun();
            break;
        case "addReturnRequest_detail":
            addReturnRequest_detailFun();
            break;

    }
}
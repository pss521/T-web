function httpRoutes(app, Controlle, $, LogFile) {
    app.post('/Login', function (req, res) {
        Controlle.Login(req, res);
    });

    app.post("/warehouseQuery", function (req, res) {
        Controlle.warehouseQuery(req, res);
    });

    app.post("/QueryExecuting", function (req, res) {
        Controlle.QueryExecuting(req, res);
    });

    app.get("/warehouse", function (req, res) {
        Controlle.warehouse(req, res);
    })

    app.get("/voucherDraft", function (req, res) {
        Controlle.voucherDraft(req, res);
    })

    app.get("/brand", function (req, res) {
        Controlle.brand(req, res);
    })

    app.post("/inventoryClass", function (req, res) {
        Controlle.inventoryClass(req, res);
    });

    app.post("/logout", function (req, res) {
        Controlle.logout(req, res);
    });

    app.post("/freeItem", function (req, res) {
        Controlle.freeItem(req, res);
    });

    app.post("/inventory", function (req, res) {
        Controlle.inventory(req, res);
    });

    app.post("/QueryInventoryPrice", function (req, res) {
        Controlle.QueryInventoryPrice(req, res);
    });

    app.post("/Project", function (req, res) {
        Controlle.Project(req, res);
    });

    app.get("/partner", function (req, res) {
        Controlle.partner(req, res);
    });
    
    app.post("/person", function (req, res) {
        Controlle.person(req, res);
    });
    
    app.post("/saleDeliveryCreate", function (req, res) {
        Controlle.saleDeliveryCreate(req, res);
    });

    app.post("/SettleStyle", function (req, res) {
        Controlle.SettleStyle(req, res);
    });

    app.post("/BankAccount", function (req, res) {
        Controlle.BankAccount(req, res);
    });

    app.post("/StockRequestFind", function (req, res) {
        Controlle.StockRequestFind(req, res);
    });

    app.post('/GetStockRequest_InWarehouse',function(req, res){
        Controlle.GetStockRequest_InWarehouse(req, res);
    })

    app.post('/GetStockRequest_OutWarehouse',function(req, res){
        Controlle.GetStockRequest_OutWarehouse(req, res);
    })

    app.post("/GetStockRequestsList", function (req, res) {
        Controlle.GetStockRequestsList(req, res);
    });

    app.post("/currentStockQuery", function (req, res) {
        Controlle.currentStockQuery(req, res);
    });

    app.post("/StockRequestCreate", function (req, res) {
        Controlle.StockRequestCreate(req, res);
    });

}
module.exports = httpRoutes;
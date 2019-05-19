const uuidv1 = require('uuid/v1');
var fs = require('fs');

function httpControlle($) {
    this.Login = function (req, res) {
        var jsondata = req.body;
        var file = process.cwd() + "/config.json";
        console.log(file)
        var result=JSON.parse(fs.readFileSync(file));
        console.log(result);
        jsondata.account = result.account;
        //console.log("jsondata:",jsondata);
        $.post("login", JSON.stringify(jsondata), function (data) {
            //console.log("api/login/",data);
            //console.log("api/login:::",data.data);
            if (data.code == 200) {
                var token = { "token": data.data }
                var adminName = {
                    token: data.data,
                    username: jsondata.username,
                    password: jsondata.password,
                    account: jsondata.account
                };
                req.session.admin = adminName;
                //console.log("req.session.admin1::",req.session.admin);
                res.send("success");
            } else {
                res.send("error");
            }

        });
    }

    this.QueryExecuting = function (req, res) {
        //console.log("req.session.admin::",req.session);
        var  data = req.body["queryParam"];
console.log(data)
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("saleDelivery/QueryExecuting?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //仓库档案 
    // var data = {
    //     "address": "string",
    //     "code": "string",
    //     "id": "string",
    //     "memo": "string",
    //     "name": "string",
    //     "selectFields": "string",
    //     "ts": "string"
    //   }
    this.warehouse = function (req, res) {
        var data = JSON.stringify(req.body)
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("warehouse/Query?token=" + token, data, function (data) {
                    console.log(data)
                    res.send(data);
                });
            });
        }
    }

    //单据草稿查询
    // var data = {
    //     "code": "string",
    //     "id": "string",
    //     "idEnum": "string",
    //     "name": "string",
    //     "selectFields": "string",
    //     "ts": "string"
    //   }
    this.voucherDraft = function (req, res) {
        var data = JSON.stringify(req.body);

        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("voucherDraft/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }

    }

    //品牌相关
    // {
    //     "code": "string",
    //     "id": "string",
    //     "idEnum": "string",
    //     "name": "string",
    //     "selectFields": "string",
    //     "ts": "string"
    //   }
    this.brand = function (req, res) {
        var data = JSON.stringify(req.body);

        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("brand/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //存货分类查询 /inventoryClass/Query
    // var data = {
    //     "code": "string",
    //     "id": "string",
    //     "name": "string",
    //     "partneCode": "string",
    //     "selectFields": "string",
    //     "ts": "string"
    //   }
    this.inventoryClass = function (req, res) {
        var data = JSON.stringify(req.body);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("inventoryClass/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }

    };

    //登陆登出 /logout

    this.logout = function (req, res) {
        //$.post("logout?token=" + req.session.admin.adminName, "", function (data) {
        delete req.session.admin;
        res.send("success");
        //});
    };

    //自由项相关  /freeItem/Query
    // var data = {
    //     "code": "string",
    //     "id": "string",
    //     "idEnum": "string",
    //     "name": "string",
    //     "selectFields": "string",
    //     "ts": "string"
    //   }
    this.freeItem = function (req, res) {
        var data = JSON.stringify(req.body);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("freeItem/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }

    };

    //货物相关的  /inventory/Query
    // var data = {
    //     "avagCost": 0,
    //     "code": "string",
    //     "defaultBarCode": "string",
    //     "disabled": "string",
    //     "expired": 0,
    //     "expiredUnit": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "id": "string",
    //     "imageList": {
    //       "imageUrl": "string",
    //       "isDefault": "string"
    //     },
    //     "invSCost": 0,
    //     "inventoryClass": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "isLaborCost": "string",
    //     "isMadeSelf": "string",
    //     "isMaterial": "string",
    //     "isPurchase": "string",
    //     "isSale": "string",
    //     "isSuite": "string",
    //     "latestCost": 0,
    //     "name": "string",
    //     "pageSize": "string",
    //     "productInfo": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "selectFields": "string",
    //     "shorthand": "string",
    //     "specification": "string",
    //     "taxRate": "string",
    //     "ts": "string",
    //     "unit": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "unitByManufacture": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "unitByPurchase": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "unitByRetail": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "unitBySale": {
    //       "code": "string",
    //       "name": "string"
    //     },
    //     "unitByStock": {
    //       "code": "string",
    //       "name": "string"
    //     }
    //   }
    this.inventory = function (req, res) {
        var data;
        if (req.body === "") {
            data = "";
        } else {
            data = JSON.stringify(req.body);
        }
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("inventory/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }

    };

    //销售价格 /inventoryPrice/QueryInventoryPrice
    // var data = {
    //     "param": [
    //       {
    //         "businessDate": "string",
    //         "cashBackReturn": 0,
    //         "discountPrice": 0,
    //         "discountRate": 0,
    //         "inventory": {
    //           "avagCost": 0,
    //           "code": "string",
    //           "defaultBarCode": "string",
    //           "disabled": "string",
    //           "expired": 0,
    //           "expiredUnit": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "id": "string",
    //           "imageList": {
    //             "imageUrl": "string",
    //             "isDefault": "string"
    //           },
    //           "invSCost": 0,
    //           "inventoryClass": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "isLaborCost": "string",
    //           "isMadeSelf": "string",
    //           "isMaterial": "string",
    //           "isPurchase": "string",
    //           "isSale": "string",
    //           "isSuite": "string",
    //           "latestCost": 0,
    //           "name": "string",
    //           "pageSize": "string",
    //           "productInfo": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "selectFields": "string",
    //           "shorthand": "string",
    //           "specification": "string",
    //           "taxRate": "string",
    //           "ts": "string",
    //           "unit": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "unitByManufacture": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "unitByPurchase": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "unitByRetail": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "unitBySale": {
    //             "code": "string",
    //             "name": "string"
    //           },
    //           "unitByStock": {
    //             "code": "string",
    //             "name": "string"
    //           }
    //         },
    //         "partner": {},
    //         "price": 0,
    //         "quantity": "string",
    //         "rowID": "string",
    //         "selectFields": "string",
    //         "unit": {
    //           "code": "string",
    //           "name": "string"
    //         },
    //         "withTax": true
    //       }
    //     ]
    //   }
    this.QueryInventoryPrice = function (req, res) {
        var bodydata = {
            param: JSON.parse(req.body["param"])
        }
        var data = JSON.stringify(bodydata);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("inventoryPrice/QueryInventoryPrice?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }
    };

    //项目  /Project/Query
    // var data = {
    //     "code": "string"
    //   }
    this.Project = function (req, res) {
        var data = JSON.stringify(req.body);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("Project/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }

    };

    //客户
    this.partner = function (req, res) {
        var data = JSON.stringify(req.body);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("partner/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //人员{"code": "string","name": "string"}
    this.person = function (req, res) {
        var data = JSON.stringify(req.body);
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("person/Query?token=" + token, data, function (data) {
                    res.send(data);
                });
            });
        }
    }

    ///saleDelivery/Create
    this.saleDeliveryCreate = function (req, res) {
        var parameter = req.body.parameter;
        var jsondata = JSON.parse(parameter);
        jsondata.externalCode = uuidv1();
        console.log("saleDelivery/Create:", JSON.stringify(jsondata));
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("saleDelivery/Create?token=" + token, JSON.stringify(jsondata), function (data) {
                    res.send(data);
                });
            });
        }
    }

    //结算方式/SettleStyle/Query
    this.SettleStyle = function (req, res) {
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("SettleStyle/Query?token=" + token, "", function (data) {
                    res.send(data);
                });
            });
        }
    }

    //银行账户/BankAccount/Query
    this.BankAccount = function (req, res) {
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("BankAccount/Query?token=" + token, "", function (data) {
                    res.send(data);
                });
            });
        }
    }

    //要货单查询POST /StockRequest/Find
    this.StockRequestFind = function(req, res){
        var jsondata = req.body['parameter'];
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("StockRequest/Find?token=" + token, jsondata, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //要货单入库仓库列表POST /StockRequest/GetStockRequest_InWarehouse
    this.GetStockRequest_InWarehouse = function(req, res){
        var jsondata = req.body['parameter'];
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("StockRequest/GetStockRequest_InWarehouse?token=" + token, jsondata, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //要货单出库列表POST /StockRequest/GetStockRequest_OutWarehouse
    this.GetStockRequest_OutWarehouse = function(req, res){
        var jsondata = req.body['parameter'];
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("StockRequest/GetStockRequest_OutWarehouse?token=" + token, jsondata, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //要货单模糊查询接口POST /StockRequest/GetStockRequestsList
    this.GetStockRequestsList = function(req, res){
        var jsondata = req.body['parameter'];
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("StockRequest/GetStockRequestsList?token=" + token, jsondata, function (data) {
                    res.send(data);
                });
            });
        }
    }

    //现存量POST /currentStock/Query
    this.currentStockQuery = function(req, res){
        var jsondata = req.body['parameter'];
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("currentStock/Query?token=" + token, jsondata, function (data) {
                    res.send(data);
                });
            });
        }
    }

    ///StockRequest/Create

    this.StockRequestCreate = function(req, res){
        var jsondata = JSON.parse(req.body['parameter']);
        jsondata.dto.externalCode = uuidv1();
        jsondata.dto.code = uuidv1();
        if (!req.session.admin) {
            res.redirect('/');
        } else {
            var logindata = {
                username: req.session.admin.username,
                password: req.session.admin.password,
                account: req.session.admin.account
            }
            relogin($, logindata, function (token) {
                $.post("StockRequest/Create?token=" + token, JSON.stringify(jsondata), function (data) {
                    res.send(data);
                });
            });
        }
    }
}

function relogin($, data, callback) {
    var jsondata = {
        username: data.username,
        password: data.password,
        account: data.account
    }
    $.post("login", JSON.stringify(jsondata), function (data) {
        //console.log("api/login/",data);
        //console.log("api/login:::",data.data);
        callback(data.data);
    });
}
module.exports = httpControlle;
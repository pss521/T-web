function ajax($, config, reqlogger, reslogger, errlogger) {
    this.post = function (url, data, resultcallback, errorcallback) {
        reqlogger.info("[" + url + "][POST]:", data);
        ajaxFun($, config, url, "POST", data, reslogger, errlogger, function (data, status, headers) {
            resultcallback(data, status, headers);
        }, function (err, status, headers) {
            if (errorcallback) {
                errorcallback(err, status, headers);
            }
        });
    };
    this.get = function (url, data, resultcallback, errorcallback) {
        reqlogger.info("[" + url + "][GET]:", data);
        ajaxFun($, config, url, "GET", data, reslogger, errlogger, function (data, status, headers) {
            resultcallback(data, status, headers);
        }, function (err, status, headers) {
            if (errorcallback) {
                errorcallback(err, status, headers);
            }
        });
    };
    this.put = function (url, data, resultcallback, errorcallback) {
        reqlogger.info("[" + url + "][PUT]:", data);
        ajaxFun($, config, url, "PUT", data, reslogger, errlogger, function (data, status, headers) {
            resultcallback(data, status, headers);
        }, function (err, status, headers) {
            if (errorcallback) {
                errorcallback(err, status, headers);
            }
        });
    };
    this.delete = function (url, data, resultcallback, errorcallback) {
        reqlogger.info("[" + url + "][DELETE]:", data);
        ajaxFun($, config, url + data, "DELETE", '', reslogger, errlogger, function (data, status, headers) {
            resultcallback(data, status, headers);
        }, function (err, status, headers) {
            if (errorcallback) {
                errorcallback(err, status, headers);
            }
        });
    };
}

function ajaxFun($, config, url, method, data, reslogger, errlogger, resultcallbackFun, errorcallbackFun) {
    $.ajax({
        url: "http://" + config.HOST + ":" + config.POST + "/api/" + url,
        method: method,
        dataType: "json",
        data: data,
        timeout: config.TIMEOUT,
        headers:{"content-type":"application/json"},
        success: function (data, status, headers) {
            reslogger.info("[" + url + "][" + method + "][" + status + "]:", data);
            resultcallbackFun(data, status, headers);
        },
        error: function (err, status, headers) {
            errlogger.error("[" + url + "][" + method + "][" + status + "]:", err);
            errorcallbackFun(err, status, headers);
        }
    });
}

module.exports = ajax;
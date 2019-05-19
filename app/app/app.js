var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var morgan = require('morgan');

var ejs = require('ejs');
var $ = require('node-httpclient');
var session = require('express-session');

var config = require('./config/config');

var log4js = require('./App/Utility/logs');
var ajaxUtility = require('./App/Utility/ajax');
var log4js = require('./App/Utility/logs');

var httpControlle = require('./App/HttpController/index');
var httpRoutes = require('./routes/Http/index');

var indexRouter = require('./routes/index');

var app = express();

log4js.useLogger(app, logger);//这样会自动记录每次请求信息，放在其他use上面
// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.engine('html', ejs.renderFile);
app.engine('html', ejs.__express);
app.set('view engine', 'html');

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(session({
  secret: '12345',
  resave: true,
  saveUninitialized: false
}));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);

//初始化日志
var logger = log4js.getLogger();//根据需要获取logger
var othlogger = log4js.getLogger('oth');
var reqlogger = log4js.getLogger('httpclireq');
var reslogger = log4js.getLogger('httpclires');
var errlogger = log4js.getLogger('err');

//初始化http client
var ajax = new ajaxUtility($, config, reqlogger, reslogger, errlogger);

var httpControlle = new httpControlle(ajax);
httpRoutes(app, httpControlle, ajax);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});



module.exports = app;

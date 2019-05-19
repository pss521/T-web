var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  console.log("router.get::",req.session.admin);
  if (!req.session.admin) {
    res.render('login', { title: 'Express' });
  }else{
    res.render('index', { title: 'Express' });
  }
});

module.exports = router;

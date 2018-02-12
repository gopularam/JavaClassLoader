var express = require('express')
var app = express()
var bodyParser = require('body-parser')
var urlencodedParser = bodyParser.urlencoded({extended: false})

app.use(express.static('public'))
app.get('/index.htm*', function(req, res) {
    console.log(__dirname);
    res.sendFile(__dirname+"/"+"index.html")
})

app.get('/index.htm*', function(req, res) {
    console.log(__dirname);
    res.sendFile(__dirname+"/"+"index.html")
})


app.post('/userform', urlencodedParser, function(req,res) {
    response = {
       first_name:req.body.first_name,
       last_name: req.body.last_name
    };
    console.log(response);
    res.end(JSON.stringify(response));
})

app.get('/profile', function(req,res) {
    console.log("profile page")
    res.send("<h1>Profile information</h1>")
})


var server = app.listen(8800, function() {
    var host = server.address().address
    var port = server.address().port
    console.log("Server started %s:%s", host,port)
})

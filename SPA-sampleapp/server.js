var express = require('express')
var app = express()

app.use(express.static('pages'))

var server = app.listen(8800, function() {
    var host = server.address().address
    var port = server.address().port
    console.log("Server started %s:%s", host,port)
})

app.get('/index.htm*', function(req, res) {
    console.log(__dirname);
    res.sendFile(__dirname+"/pages/index.html")
})
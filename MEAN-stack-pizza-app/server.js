var express = require('express')
var app = express()
var bodyParser = require('body-parser')
var qs = require('querystring');

var urlencodedParser = bodyParser.urlencoded({extended: false})
//app.use(require('cors'))
app.use(express.static('public'))

app.get('/index.htm', function(req, res) {
    console.log("index.htm.. called:");
    res.sendFile(__dirname+"/public/"+"index.html")
})

app.get('/viewdata.htm', function(req, res) {
    console.log("viewdata called..:"+__dirname);
    res.sendFile(__dirname+"/public/"+"viewdata.html")
})

app.get('/adddata.htm', function(req, res) {
    console.log("adddata called..:"+__dirname);
    res.sendFile(__dirname+"/public/"+"adddata.html")
})

app.post('/adddata.htm', function(req, res){
    console.log('adddata POST /');
    console.dir(req.body);
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end('thanks');
});

var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/mean";

app.get('/getitems', function(req,res) {
    console.log("/getitems get called!")
    MongoClient.connect(url, function(err, db) {
      if (err) throw err;
      var dbo = db.db("mean");
      //var query = { address: "Park Lane 38" };
      var response;  
      dbo.collection("customers").find().toArray(function(err, result) {
        if (err) throw err;
        console.log("type:"+Object.prototype.toString.call(result));
        db.close();
        //console.log("res2:"+JSON.stringify(result))
        res.status(200);
        console.log("res:"+res.statusCode)
        return res.end(JSON.stringify(result));
      });
    });



})


app.post('/adddata', urlencodedParser, function(req,res) {
    console.log("add data called..");
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("mean");
        var response;  
        dbo.collection("customers").find().toArray(function(err, result) {
          if (err) throw err;
          console.log("type:"+Object.prototype.toString.call(result));
          db.close();
          console.log("res:"+res.statusCode)
          return res.end(JSON.stringify(result));
        });
      });
})

var server = app.listen(8000, function() {
    var host = server.address().address
    var port = server.address().port
    console.log("Server started %s:%s", host,port)
})
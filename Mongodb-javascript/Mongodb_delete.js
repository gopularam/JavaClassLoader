var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mean");
  var myquery = { name: 'aaa' };
  dbo.collection("products").deleteOne(myquery, function(err, res) {
    if (err) throw err;
    console.log(res.result);
    console.log(res.result.n+" document deleted");
    db.close();
  });
});
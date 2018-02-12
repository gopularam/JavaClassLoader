var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/mean";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mean");
  //var query = { address: "Park Lane 38" };

  dbo.collection("customers").find().toArray(function(err, result) {
    if (err) throw err;
    //Return the result object:
    console.log(result);
    db.close();
  });
});

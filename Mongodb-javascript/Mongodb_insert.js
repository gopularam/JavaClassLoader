var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/mean";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mean");
  //Insert 3 documents, with specified id values:
  var myobj = { _id: 154, name: 'Chocolate Heaven'};
  dbo.collection("products").insertOne(myobj, function(err, res) {
    if (err) throw err;
    //Return the result object:
    console.log("Inserted:"+res);
    db.close();
  });
});

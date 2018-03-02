console.log('starting function')

const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-1'});

exports.handle = function(e, ctx, cb) {

  console.log('processing event: %j', e); 
  console.log('processing operation: %j', e.userop); 

  //ADD User
  if(e.userop=="add") {
    var params = {
      Item: {
        userid:e.userid,
        joindate: e.joindate,
        message:e.message
      },
      TableName: 'kidsapp_users'
    };  
    docClient.put(params, function(err, data) {
      if(err) {
        cb(err, 'null');
      } else {
        cb(null,data);
      }
    });
  } else if (e.userop=="remove") {
    //Remove User
    var params = {
      TableName: 'kidsapp_users',
      Key:{
          "userid":e.userid,
          }
      };
    console.log("Attempting a conditional delete...");
    docClient.delete(params, function(err, data) {
        if (err) {
            console.error("Unable to delete item. Error JSON:"+err);
            cb(err, 'null');
        } else {
            console.log("DeleteItem succeeded:");
            cb(null, data);
        }
      });
  
  }  else if (e.userop=="update") {
    // Update User
    var params = {
      TableName: 'kidsapp_users',
      Key:{
          "userid":'222',
          }
      };
    docClient.delete(params, function(err, data) {
        if (err) {
            console.error("Unable to delete item. Error JSON");
            cb(err, 'null');
        } else {
            console.log("DeleteItem succeeded:");
            cb(null, data);
        }
      });
  } else {
    console.log("Invalid Request:"+e.userop);
  }
}

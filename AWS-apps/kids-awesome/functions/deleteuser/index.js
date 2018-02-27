console.log('starting function')

const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-1'});

exports.handle = function(e, ctx, cb) {
  console.log('processing event: %j', e);

  var params = {
    TableName: 'kidsapp_users',
    Key:{
        "userid":'222',
    }
};
  console.log("Attempting a conditional delete...");
  docClient.delete(params, function(err, data) {
      if (err) {
          console.error("Unable to delete item. Error JSON:", JSON.stringify(err, null, 2));
          cb(err, 'null');
      } else {
          console.log("DeleteItem succeeded:", JSON.stringify(data, null, 2));
          cb(null,data);
      }
    });
}

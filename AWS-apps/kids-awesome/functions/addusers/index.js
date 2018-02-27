console.log('starting function')

const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-1'});

exports.handle = function(e, ctx, cb) {
  console.log('processing event: %j', e);

   var params = {
    Item: {
      userid:e.userid,
      joindate: e.joindate,
      message:e.message
    },
    TableName: 'kidsapp_users'
  };  
  /*var params = {
    Item: {
      userid:"Bhanu",
      joindate:8080,
      message: "Hello"
    },
    TableName: 'kidsapp_users'
  };
 */

  docClient.put(params, function(err, data) {
    if(err) {
      cb(err, 'null');
    } else {
      cb(null,data);
    }
  });
}

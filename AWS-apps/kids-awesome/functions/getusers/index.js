console.log('starting function')

const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-1'});

exports.handle = function(e, ctx, cb) {
  console.log('processing event: %j', e)

  let scanningParameters = {
    TableName: 'kidsapp_users',
    Limit:100
  };

  docClient.scan(scanningParameters, function(err,data){
    if(err){
      cb(err,null);
    } else {
      cb(null,data);
    }
  });
}

const http = require('http')

http.createServer((request,response) => {
 let body = [];

 request.on('data', (chunk) => {
   console.log("chunk"+chunk)
   body.push(chunk);
 }).on('end', () => {
   body = Buffer.concat(body).toString();
   console.log("body:"+body)
   response.write("<H1>Hello</H1>")
   response.end(body);
 });
}).listen(8800); 

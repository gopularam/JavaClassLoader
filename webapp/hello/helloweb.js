var http = require('http')
var url = require('url')
var show = require('./show')

const server = http.createServer((request,response) => {
    console.log("server created");
    response.writeHead(200);
    console.log("calling showPage..");
    show.showPage(request, response)
}).listen(8800);

console.log("Server started port:8800");


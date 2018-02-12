var url = require('url')
var content = require('./content')

function showPage(request, response) {
  var pathname = url.parse(request.url).pathname;

 if(content.contentMap[pathname]) {
   response.writeHead(200, {'Content-Type': 'text/html'})
   response.write(content.contentMap[pathname])
   response.end()
  } else {
   response.writeHead(404, {'Content-Type': 'text/html'})
   response.write('404 use correct URL')
   response.end()
 }
}
exports.showPage = showPage;

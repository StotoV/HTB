const http = require('http');

module.exports = {
	HttpGet(url) {
        console.log('\nHTTP Get URL: ' + url);
		return new Promise((resolve, reject) => {
			http.get(url, res => {
				let body = '';
				res.on('data', chunk => body += chunk);
				res.on('end', () => {
					try {
                        console.log('\nHTTP get response body');
                        console.log(body);
						resolve(JSON.parse(body));
					} catch(e) {
                        console.log('Error parsing body to JSON');
                        console.log(e);
						resolve(false);
					}
				});
			}).on('error', reject);
		});
	}
}

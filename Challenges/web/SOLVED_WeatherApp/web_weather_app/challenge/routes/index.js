const path              = require('path');
const fs                = require('fs');
const express           = require('express');
const router            = express.Router();
const WeatherHelper     = require('../helpers/WeatherHelper');

let db;

const response = data => ({ message: data });

router.get('/', (req, res) => {
	return res.sendFile(path.resolve('views/index.html'));
});

router.get('/register', (req, res) => {
	return res.sendFile(path.resolve('views/register.html'));
});

router.post('/register', (req, res) => {
    console.log('\nRegister call');
    console.log(req.headers);
    console.log(req.body);
    console.log(req.socket.remoteAddress);

	if (req.socket.remoteAddress.replace(/^.*:/, '') != '127.0.0.1') {
		return res.status(401).end();
	}

    console.log('Passed check');

	let { username, password } = req.body;

    console.log(username, password)

	if (username && password) {
		return db.register(username, password)
			.then(()  => {
                console.log('Successfully registered');
                res.send(response('Successfully registered'))
            })
			.catch(() => {
                console.log('Something went wrong');
                res.send(response('Something went wrong'))
            });
	}

	return res.send(response('Missing parameters'));
});

router.get('/login', (req, res) => {
    console.log('Login get call');
	return res.sendFile(path.resolve('views/login.html'));
});

router.post('/login', (req, res) => {
    console.log('Login attempt');
    console.log(req.headers);
    console.log(req.body);

	let { username, password } = req.body;

	if (username && password) {
		return db.isAdmin(username, password)
			.then(admin => {
				if (admin) return res.send(fs.readFileSync('/app/flag').toString());
				return res.send(response('You are not admin'));
			})
			.catch(() => res.send(response('Something went wrong')));
	}
	
	return re.send(response('Missing parameters'));
});

router.post('/api/weather', (req, res) => {
    console.log('Body of API request');
    console.log(req.body);
	let { endpoint, city, country } = req.body;

	if (endpoint && city && country) {
		return WeatherHelper.getWeather(res, endpoint, city, country);
	}

	return res.send(response('Missing parameters'));
});	

module.exports = database => { 
	db = database;
	return router;
};

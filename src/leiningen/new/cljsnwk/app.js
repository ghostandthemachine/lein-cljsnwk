var connect = require('connect'),
        http = require('http');

connect().use(connect.static('public')).listen(3000);

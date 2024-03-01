 const { faker } = require('@faker-js/faker');
 const express = require('express');

 const app = express();
 const port = 3000;

//  app.get('/user/:id', (req, res) => {
//    req.params.id;
//    req.body;    
//     const user = {
//         name: faker.person.fullName(),
//         gender: faker.person.sex(),
//         email: faker.internet.email()
//     };
//     res.json(user);
//  });

app.use((req, res, next) => {

    const authHeader = req.headers.authorizationHeader;

    if(!authHeader  || authHeader.indexOf('Basic ') !== 0) {
        return res.status(401).json({ message: 'Unauthorized' });
    }

    const base64Credintials = authHeader.split(' ')[1];
    const credintials = Buffer.from(base64Credintials, 'base64').toString();
    const [username, password] = credintials.split(':');

    if(username !== 'admin' || password !== 'password') {
        return res.status(401).json({ message: 'Unauthorized' });
    }

    req.user = {
        username: 'admin',
        email: 'admin@example.com'
    };

    next();
})
 
app.get('/user', (req, res) => {
    const name = req.query.name;
    if (!name) {
        return res.json(generateUsers(5));
    }
    const user = generateUsers(1, name);
    res.json(user);
});

app.get('/product', (req, res) => {
    res.json(Product)
  })

  app.get('/order', (req, res) => {
    res.json(Order)
  })

app.listen(port, () => {
    console.log(`Server Starts at ${port}`)
})
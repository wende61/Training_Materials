const { faker } = require('@faker-js/faker');

const Product = {
 name: faker.commerce.productName(),
 description: faker.commerce.productDescription(),
 price: faker.commerce.price({ min: 100, max: 200, dec: 0, symbol: '$' }),
 category: faker.commerce.department()
}

module.exports = Product;

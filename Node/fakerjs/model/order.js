const { faker } = require('@faker-js/faker');

const Order = {
 id: faker.string.uuid(),
 userId: faker.string.uuid(),
 productId: faker.string.uuid(),
 quantity: faker.string.numeric({ length: { min: 2, max: 10 } }),
 totalPrice: faker.commerce.price(),
 date: faker.date.past(),
 status: faker.helpers.arrayElement(['Processing', 'Shipped', 'Delivered', 'Cancelled'])
}

module.exports = Order;

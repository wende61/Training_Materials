const { faker } = require('@faker-js/faker');

// Function to generate a single user
const generateUser = (name) => {
    let fullNameOptions;
    if (name) {
        fullNameOptions = { firstName: name };
    }
    const user = {
        name: faker.person.fullName(fullNameOptions),
        email: faker.internet.email(),
        website: faker.internet.url(),
        address: faker.location.buildingNumber() + " " + faker.location.cardinalDirection() + ", " + faker.location.city() + ", " + faker.location.country(),
        bio: faker.person.bio(),
        image: faker.image.avatar(),
        prefix: faker.person.prefix(),
        sex: faker.person.sex()
    };
    return user;
};

// Function to generate a list of users
const generateUsers = (count, name) => {
    const users = [];
    if (count === 1){ return generateUser(name); }
    for (let i = 0; i < count; i++) {
        const user = generateUser(name);
        users.push(user);
    }
    return users;
};

// Export the generateUsers function
module.exports = {
    generateUsers
};

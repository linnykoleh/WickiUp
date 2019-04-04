const user = {
  id: 1,
  name: "Oleh",
  lastName: "Linnyk"
};

// ES5
let idN = user.id;
let nameN = user.name;

console.log(idN, nameN); // 1 'Oleh'

// ES6
const { lastName } = user;
console.log(lastName); // Linnyk

function foo({name, lastName}) {
  console.log(name, lastName); // Oleh Linnyk
}

foo(user);

console.log("-------------------------------------");

const array = [1, 2, 3, 4];

// ES5
const one = array[0];
const two = array[1];
console.log(one, two); // 1 2

// ES6
const [one1, two2,, four] = array;
console.log(one1, two2, four); // 1 2 4


console.log("-------------------------------------");

const objUser = {
  id: 1,
  name: "Oleh",
  lastName: "Linnyk",
  address: {
    city: 'Kiev',
    country: 'Ukraine'
  }
};

// ES5
const firstNameobjUser = objUser.name;
const idobjUser = objUser.id;
const cityobjUser = objUser.address.city;

console.log(firstNameobjUser, idobjUser, cityobjUser); // Oleh Kiev

// ES5
const { name: newName, id, address: { city, country } } = objUser;

console.log(newName, id, city, country); // Oleh 1 Kiev Ukraine

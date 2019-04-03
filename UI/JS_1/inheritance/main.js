const obj = {
  name: "Стол"
};

obj.__proto__ = window;

console.log(" #### obj : ", obj); //eslint-disable-line no-console

const Foo = function () {
    this.name = "Fuu";
};

const boo = new Foo();

console.log(" #### boo : ", boo); // Foo {name: "Fuu"} name: "Fuu"
console.log(" #### boo.__proto__ : ", boo.__proto__ === Foo.__proto__);

const objNew = {
  value: "Стол",
  test: function f() {
    return 6;
  }
};

Foo.prototype = objNew;

const boo1 = new Foo();

console.log(" #### boo1 : ", boo1); //Foo {name: "Fuu"} name: "Fuu"__proto__: test: ƒ f() value: "Стол"




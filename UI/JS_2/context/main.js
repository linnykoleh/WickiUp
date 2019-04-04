let user = {
  firstName: "Ivan",
  lastName: "Petrov",

  print: function () {
    console.log(this);
    console.log(firstName + " " + lastName); // error variables not defined
  },

  printTimeout: function () {
    let self = this;
    setTimeout(function () {
      console.log(self);
    }, 2000)
  }
};

// console.log("user.print: ", user.print()); error variables not defined
console.log("user.printTimeout: ", user.printTimeout());

function foo() {
  console.log(this); // Window
}foo();

let obj = {
  foo: function () {
    console.log(this); // Object obj
  }
};

obj.foo();

console.log("-----------------Привязка контекста-------------------------");

let car = {
  model: 'bmw',
  mark: 'x6',
  color: 'black',
};

function printCar() {
  console.log(this.model + " " + this.mark + " " + this.color)
}

printCar(); //undefined undefined undefined

// Привязка контекста примеры

printCar.bind(car)(); //bmw x6 black
printCar.apply(car, []); //bmw x6 black
printCar.call(car); //bmw x6 black



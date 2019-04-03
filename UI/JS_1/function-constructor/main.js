// Функция - конструктор, должна быть с большой буквы
let Man = function (name) {
  this.name = name;
  this.canSpeak = true;

  let privateVar = "34";

  this.sayHello = function () {
    return "Hello: " + this.name + ' age: ' + privateVar;
  }
};

let Oleh = new Man("Oleh");
console.log(" #### Oleh : ", Oleh); //Man {name: "Oleh", canSpeak: true}canSpeak: true name: "Oleh" __proto__: Object
console.log(" #### sayHello : ", Oleh.sayHello()); //  #### sayHello :  Hello: Oleh age: 34

console.log('----------------------------------------------------');

Man.prototype.sayHello = function () {
  return "Hello: " + this.name;
};

let Mike = new Man("Mike");

console.log("Mike: ", Mike.sayHello()); // Hello: Mike age: 34

console.log('----------------------------------------------------');

let MyApp = {

  Man: function (name) {
    this.name = name;
    this.canSpeak = true;
  }

};

let Alan = new MyApp.Man("Alan");
console.log("Alan: ", Alan); // Hello: Mike age: 34

console.log('----------------------------------------------------');

console.log("instanceof Alan: ", Alan instanceof MyApp.Man); // true
console.log("instanceof Oleh: ", Oleh instanceof Man); // true

console.log('----------------------------------------------------');

console.log(Oleh.constructor);
console.log(Alan.constructor);






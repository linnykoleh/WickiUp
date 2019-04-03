const func = function (a, b) {
  console.log("func: ", this); // Global Window
  return a + b;
};
console.log(func(1, 3));

console.log('----------------------------------------------------');


let MYAPP = {
  func: function (a, b) {
    console.log("MYAPP.func: ", this); // func
    return a + b;
  }
};
console.log(MYAPP.func(2, 4));

console.log('----------------------------------------------------');

let MYAPP1 = (function () {

  let funcPrivate = function () {
    console.log("funcPrivate this: ", this); //func funcPublic
  };

  return {
    func: function (a, b) {
      console.log("MYAPP1.func: ", this); // func

      let that = this;

      let helperFunc = function (c, d) {
        console.log("MYAPP1.func.helperFunc that: ", that); // func
        that.multiply = c * d;
      };

      helperFunc(2, 6);

      return a + b;
    },

    funcPublic: funcPrivate

  }
})();

console.log("MYAPP1.func(): ", MYAPP1.func());
// console.log(MYAPP1.funcPrivate()); Error private function
console.log("MYAPP1.funcPublic(): ", MYAPP1.funcPublic());
console.log("MYAPP1.multiply: ",  MYAPP1.multiply); //12

console.log('----------------------------------------------------');

const add = function (a, b) {
  console.log("add" , this); // Window
  return a + b;
};
let sum = add.apply(null, [3, 5]); //Первый параметр - это контекст, если null, то это Window,
let sum1 = add.apply(MYAPP, [6, 5]); //Первый параметр - это контекст, если класс(MYAPP), то будет его контекст

console.log('sum: ', sum);
console.log('sum1: ', sum1);

console.log('----------------------------------------------------');



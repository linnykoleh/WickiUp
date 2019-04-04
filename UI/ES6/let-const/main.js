/** Hoisting */

// console.log(b); Uncaught ReferenceError: b is not defined
let b = 5;

/** Block Scoping */

// IIFE
(function () {
  let b = 5;
})();

{
  let a  = 5;
}
// console.log(a); a is not defined

/** Переопределение переменных*/
var a = 5;
var a = 10;
console.log(a); //10

let x = 5;
// let x = 10; Identifier 'x' has already been declared

/** const */
const c = 5;
// const cx;  Missing initializer in const declaration
// c = 10; Assignment to constant variable.










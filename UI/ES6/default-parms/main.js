/** Параметры по умолчанию */
function summ(a, b) {
  return a + b;
}
console.log(summ()); //NaN

// ES5
function summOld(a , b) {
  a = a || 10;
  b = b || 5;
  return a + b;
}
console.log(summOld(1, 3)); //4
console.log(summOld()); //15

// ES6
function summNew(a = 4 , b = 3) {
  return a + b;
}
console.log(summNew(1, 3)); //4
console.log(summNew()); //7
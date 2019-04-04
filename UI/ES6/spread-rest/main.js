/** Spread */

function foo(a, b, c) {
  console.log(a, b, c);
}

foo(1, 2, 3); //1 2 3

const numbers = [1, 2, 3];

foo(numbers); //[ 1, 2, 3 ] undefined undefined
foo(...numbers); //1 2 3

/** Rest */

function func(a, ...rest) {
  console.log(a);
  console.log(rest);
}

func(1, 2, 3); // 1 [ 2, 3 ]

let fooc = (...rest) => {
  console.log(rest);
};

fooc(1, 2, 3); // [ 1, 2, 3 ]
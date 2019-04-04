/** Arrow functions*/

function summ(a, b) {
  return a + b;
}

console.log(summ(1, 4)); //5


const arrowFunc = (a, b) => {
  return a + b;
};
console.log(arrowFunc(4, 7)); //11


const arrowFunc1 = (a, b) => a + b;
console.log(arrowFunc1(4, 7)); // 11


const arrowFunc2 = () => "data";
console.log(arrowFunc2()); // data

console.log("--------------Arrow function state---------------");

const obj = {
  name: "Oleh",
  getName: function() {
    setTimeout(() => {
      console.log(this.name); // Oleh
    }, 2000);
  }
};

obj.getName();



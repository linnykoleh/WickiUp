function counter(name) {
  //LexicalEnvironment {
    //count = 1
  //}

  let count = 1;

  return function () {
    //LexicalEnvironment {
        //count = 2
    //}

    count++;
    console.log(count);
    console.log(name);
  }
}

let counter1 = counter();
// новое замыкание, мы вызываем функицю заново
// counter1 это новая функция, которая имеет доступ с своему LexicalEnvironment и к родительскому LexicalEnvironment

console.log(counter1()); // 2
console.log(counter1()); // 3


let counter2 = counter("Oleh");
// новое замыкание, мы вызываем функицю заново
// counter2 это новая функция, которая имеет доступ с своему LexicalEnvironment и к родительскому LexicalEnvironment

console.log(counter2()); // 2
console.log(counter2()); // 3
console.log(counter2()); // 4
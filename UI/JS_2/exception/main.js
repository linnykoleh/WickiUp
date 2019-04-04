console.log("-----------------try/catch/finally--------------------");
let user = {
  sendMessage() {
    console.log("sendMessage");
  }
};

try {
  console.log("Before method");
  user.senMessage();
  console.log("After method");
} catch (e) {
  console.log("Catch Error: ", e);
} finally {
  console.log("Finally");
}

console.log("After error");

// Before method
// Catch Error: TypeError: user.senMessage is not a function
// Finally
// After error

console.log("-----------------Throw--------------------");

function sum(a, b) {
  let newVar = a + b;
  if(newVar === 0){
    throw new Error("/ 0");
  }
  return newVar;
}

console.log(sum(1, 2)); // 3
console.log(sum(0, 0)); // Uncaught Error: / 0
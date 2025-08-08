// 02_basic/10_logical.js
console.log(4 || undefined);
console.log(undefined || 4);

console.log(4 && undefined);
console.log(undefined && 4);

// 함수 매개변수 기본값
function greet(name, greeting) {
  //TODO: 01. 파라미터가 전달되지 않으면 hello, John Doe라고 출력되도록 해보자.

  // END
  return `${greeting}, ${name}!`;
}

console.log(greet("hong", "hi"));
console.log(greet("hong"));
console.log(greet());

// Basic Functions

// function greet(){
//     document.writeln("Hello, Welcome")
// }
// greet()

// Functions with Parameters
function greet(name){
    console.log("Hello "+ name);
}
greet("Binty");
greet("Chinna");

// Function with Multiple Parameters

function addition(a,b){
    console.log(`Addition of ${a} and ${b} is ${a+b}`);
}
addition(2,3)

// Returning Values
// Instead of printing the result, return it.
function multiply(a,b){
    return `Multiplication of ${a} and ${b} is ${a*b}`
}
let result = multiply(2,3);
console.log(result)

// Function Expression
// Functions can be stored in variables.
const sub = function(a,b){
    console.log(`Subtraction of ${a} and ${b} is ${a-b}`);
}
sub(5,4);

// 8. Arrow Function (ES6)
const arrowExp = () => {
    console.log("This is Arrow Function");
}
arrowExp();

// With parameters:
const div = (a,b) => {
    return `Division of ${a} and ${b} is ${a/b}`;
}
console.log(div(6,3));

// Short form:
const add = (a,b) => `Addition of ${a} and ${b} is ${a+b}`;
console.log(add(2,3))

// 9. Anonymous Function
// setTimeout(function(){
//     console.log("Executed");
// }, 1000);

// 10. Callback Function
// A function passed as an argument to another function.
const greetEx = (callback) =>{
    console.log("Hello!");
    callback();

}
const goodbye = () =>{
    console.log("Good Bye");
}

const leave = () =>{
    console.log("Leave!");
}

greetEx(leave);

// Ex 2
const greeting = (callback,name) =>{
    console.log(`Hello ${name}`);
    callback(); 
}
const bye = () =>{
    console.log(`Don't come again`);
}
function come(){
    console.log(`Please come back!!!`);
}

greeting(come,"Binty")

// Practice
// Find the largest of two numbers.
const largest = function(a,b){
    if(a>b){
        console.log(`${a} is greater than ${b}`);
    }else{
        console.log(`${b} is greater than ${a}`);
    }
}
largest(34,45);

// Check whether a number is even or odd.
const evenOrOdd = (a) => {
    if(a%2 == 0){
        console.log(`${a} is Even Number`);
    }else{
        console.log(`${a} is Odd Number`);
    }
}
evenOrOdd(5);

//Reverse a string.
const reverseStr = (str) => {
    return str.split('').reverse('').join('');
}
console.log(reverseStr("Chinna"));

// Count the number of vowels in a string.
const countVowels = (str) => {
    let count = 0;
    const vowels = "aeiouAEIOU";

    for (let char of str) {
        if (vowels.includes(char)) {
            count++;
        }
    }

    return count;
};

console.log(countVowels("Hello World"));


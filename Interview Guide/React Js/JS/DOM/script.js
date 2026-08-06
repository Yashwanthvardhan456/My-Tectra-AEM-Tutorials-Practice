
// Selecting Elements
const input = document.getElementById("taskInput");
const inputButton = document.getElementById("addBtn");
const inputList = document.getElementById("taskList");

//Add function

inputButton.addEventListener(click,function(){
    const inputValue = input.taskInput;
    if(inputValue === ""){
        alert("Enter the value");
        return;
    }

})
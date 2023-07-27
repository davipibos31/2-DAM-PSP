function add(num1, num2) {
    return num1 + num2;
}

function substract(num1, num2) {
    return num1 - num2;
}

let substract1 = (num1, num2) => {
    return num1 - num2;
}

let substract2 = (num1, num2) => num1 - num2;

module.exports={
    add:add,
    substract:substract,
}
   
const fileUtil = require('../fileUtil')  
const data = fileUtil.syncReadFile('./input.txt');

let elfs = [];
let calorieSum = 0;

data.forEach((line) => {
    if (line !== '') {
        calorieSum += parseInt(line);
    } else {
        elfs.push(calorieSum);
        calorieSum = 0;
    }
});

console.log('Max number of calories: ' + Math.max(...elfs));
console.log('Index of max number of calories: ' + elfs.indexOf(Math.max(...elfs)));
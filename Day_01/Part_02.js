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

elfs.sort((a, b) => b - a);
const topThree = elfs.slice(0, 3);
const topThreeSum = topThree.reduce((a, b) => a + b, 0);
console.log("Top 3 elves calorie total: " + topThreeSum);
  
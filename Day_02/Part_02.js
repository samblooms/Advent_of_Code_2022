const fileUtil = require('../fileUtil')  
const data = fileUtil.syncReadFile('./input.txt');

let totalScore = 0;

let myMove = 0;
let oppMove = 0;

var hash = {
    "A Z" : 8,
    "B X" : 1,
    "C Y" : 6,
    "A X" : 3,
    "B Y" : 5,
    "C Z" : 7,
    "A Y" : 4,
    "B Z" : 9,
    "C X" : 2,
};

data.forEach((line) => {
    if (line !== '') {
        totalScore += hash[line];
    }
});

console.log('Total score: ' + totalScore);
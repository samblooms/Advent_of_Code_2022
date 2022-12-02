const fileUtil = require('../fileUtil')  
const data = fileUtil.syncReadFile('./input.txt');

let totalScore = 0;

let myMove = 0;
let oppMove = 0;

var hash = {
    "A Z" : 3,
    "B X" : 1,
    "C Y" : 2,
    "A X" : 4,
    "B Y" : 5,
    "C Z" : 6,
    "A Y" : 8,
    "B Z" : 9,
    "C X" : 7,
};

data.forEach((line) => {
    if (line !== '') {
        totalScore += hash[line];
    }
});

console.log('Total score: ' + totalScore);
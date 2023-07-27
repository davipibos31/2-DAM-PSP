const path = 'C://Users//Richy//IdeaProjects//FlightsFX';
const fs = require('fs');
fs.readdirSync(path).forEach(file => {console.log(file);});


let message=" kk"
console.log("Hola mundo");




const math=require('./math')
console.log(math.add(2,5))


const lodash = require('lodash');
console.log(lodash.difference([1, 2, 3], [1]));
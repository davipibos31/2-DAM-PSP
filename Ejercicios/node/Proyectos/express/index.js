const express = require('express')
const mongoose = require('mongoose');
const bodyparser = require('body-parser');
const jwt = require('jsonwebtoken');
const fs = require('fs');



let app = express();
app.use(bodyparser.json());

app.get('/test', (req, res) => {
    res.send('Hello from test URI');
});



mongoose.set('strictQuery', false);
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://127.0.0.1:27017/school');


var db = mongoose.connection;
db.on('error', (err) =>{
    console.log("Error de conexion al mongodb: " + err)
});

db.on('open', ()=>{
    console.log("Conectado al mongodb.")
});
let contactShema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    telephone: {
        type: String,
        required: true,
        trim: true,
        match: /^\d{9}$/
    },
    age: {
        type: Number,
        min: 18,
        max: 120
    }
});

let StudentModel = mongoose.model('students', contactShema);

let student = new StudentModel({
    name: "Javier",
    telephone: "966112233",
    age: 19
});

// Funcion añadir / guarda elemento
student.save();


app.get('/students', (req, res) => {

    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        StudentModel.find()
        .then(result => {
            console.log("Contact find:", result);
            res.send(result);
        })
        .catch (error => {
            console.log("ERROR: ", error);
            res.send({code: 400, message:error});
        })
    } else {
        res.send({code: 402, message:"token is not valid"});
    }
});

app.post('/students', (req, res) => {
    let student = new StudentModel({
        name: req.body.name,
        telephone: req.body.telephone,
        age: req.body.age
    });
    
    // Funcion añadir / guarda elemento
    student.save()
    .then(result => {
        res.send(result);
    })
    .catch (error => {
        console.log("ERROR: ", error);
        res.send({code: 400, message:error});
    })
});




app.post('/students', (req, res) => {
    let student = new StudentModel({
        name: req.body.name,
        telephone: req.body.telephone,
        age: req.body.age
    });
    
    // Funcion añadir / guarda elemento
    student.save()
    .then(result => {
        res.send({code:200, id:result._id});
    })
    .catch (error => {
        console.log("ERROR: ", error);
        res.send({code: 400, message:error});
    })
});

app.get('/students/:id', (req, res) => {
    StudentModel.findById(req.params.id)
    .then(result => {
        res.send(result);
    })
    .catch (error => {
        console.log("ERROR: ", error);
        res.send({code: 400, message:error});
    })

});

app.delete('/students/:id', (req, res) => {
    StudentModel.findByIdAndDelete(req.params.id)
    .then(result => {
        res.send(result);
    })
    .catch (error => {
        console.log("ERROR: ", error);
        res.send({code: 400, error:error});
    })

});

const secretWord = "uoiwioqiwrioquwieuqiwueqwuoqweuqwueoquwoequweuqowueoqwueoquweqoweuqowueoqwueoquweoquwoe";

let generateToken = name => {
    let token = jwt.sign({name: name}, secretWord,
    {expiresIn:"1111111111111111111130 minutes"});
    return token;
   }

   let validateToken = token => {
    try {
    let result = jwt.verify(token, secretWord);
    return result;
    } catch (e) {

    }
   }
   
app.post('/login', (req, res) => {
        let name = req.body.name;
        let password = req.body.password;

        if (name==="david" && password==="demo1234") {
            res.send({token:generateToken(name)});
        }
        else {
            res.send({code: 401, message:"user invalid"});
        }
    });

    app.post('/registers', (req, res) => {
        let name = req.body.name;
        let password = req.body.password;
        let image = req.body.image;
        const filePath = `img/${Date.now()}.jpg`;
        console.log("imagen:"+image);
        console.log("password:"+password);
        console.log("name:"+name);
        fs.writeFileSync(filePath, Buffer.from(image, 'base64'));

        res.send({ok:true});
    });
    app.use(express.static('public'));
    app.use('use'); // no copiado entero


   // app.get('/services/sum/:n1/:n2', (req, res) => {
    //    let result = parseInt(req.params.n1) + parseInt(req.params.n2);
    //    res.send("" + result);
   // });

       
    
   

app.listen(8080);
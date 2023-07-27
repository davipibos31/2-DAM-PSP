const mongoose = require('mongoose');
const express = require('express')
const bodyparser = require('body-parser');
const jwt = require('jsonwebtoken');
const fs = require('fs');

//Recurso de Json a libreria express

let app = express();
app.use(bodyparser.json());


// NodeJ pueda acceder a recursos estaticos

app.use(express.static('public'));
app.use('/img', express.static(__dirname + '/img'));

// Mongoose y la conexión

mongoose.set('strictQuery', false);
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://127.0.0.1:27017/practica3');

//Conexión mongoose

var db = mongoose.connection;

// Error de la conexión

db.on('error', (err) =>{
    console.log("Error de conexion al mongodb: " + err)
});

// Conexión establecida

db.on('open', ()=>{
    console.log("Conectado al mongodb.")
});

// ------------------------------------------------------------------------------------------>>>> Conexión MongoDB

//Creación tabla users

let contactShema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    password: {
        type: String,
        required: true,
        minlength: 4,
    },
    image: {
        type: String,
        required: true,
    }
});

//Asignación tabla users a Schema

let StudentModel = mongoose.model('users', contactShema);

// Creación tabla Messages

let contactShema2 = new mongoose.Schema({
    from: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'users',
        required: true,
    },
    to: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'users',
        required: true
    },
    message: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    image: {
        type: String,
        required: false
    },
    sent: {
        type: String,
        required: true,
        minlength: 10,
        trim: true
    }
});

// Asignación tabla messages a Schema

let StudentModel2 = mongoose.model('message', contactShema2);

// Creación de un usuario

// ----------------------------------------------------------------------------------------------->>>> Creación Esctructura BBDD

// Generamos un token para la autorización

const secretWord = "uoiwioqiwrioquwieuqiwueqwuoqweuqwueoquwoequweuqowueoqwueoquweqoweuqowueoqwueoquweoquwoe";

let generateToken = name => {
    let token = jwt.sign({name: name}, secretWord,
    {expiresIn:"1111111111111111111130 minutes"});
    return token;
}

// Validamos el token para la autorización

let validateToken = token => {
    try {
        let result = jwt.verify(token, secretWord);
        return result;
    } catch (e) {

    }
}

// ----------------------------------------------------------------------------------------->>>>> Generación Token

// Post para el login
   
app.post('/login', (req, res) => {   // Funciona correctamente
    let name = req.body.name;
    let password = req.body.password;

    StudentModel.find({name:name})
    .then(result=> {
        if (result[0].password === password) {
            res.send({"ok": true,token:generateToken(name), name: name, image: result[0].image});
        }
        else {
            res.send({"ok": false, code: 401, message:"User or password incorrect"});
        }
    })
    .catch (error => {
        console.log("ERROR:", error);
        res.send({"ok": false, code: 401, message:"Error user or password"});
    });
});

// Post para el registro

app.post('/register', (req, res) => {   // Funciona correctamente
    
    // Creación de un usuario
        let name = req.body.name;
        let password = req.body.password;
        let image = req.body.image;
    let user1 = new StudentModel({
        name: req.body.name,
        password: req.body.password,
        image: req.body.image
    });

    // Guardar el usuario
    user1.save();
    //Creación fichero .jpg de base64 de nombre único
        const filePath = `img/${Date.now()}.jpg`;
        fs.writeFileSync(filePath, Buffer.from(image, 'base64'));

    if (user1.name === req.body.name && user1.password === req.body.password && user1.image === req.body.image) {
        res.send({"ok": true});
        
        
    }
    else {
        res.send({"ok": false, code: 401, message:"User couldn't be registered"});
    }
});


// Get para listar los usuarios

app.get('/users', (req, res) => {  // Funciona correctamente

    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        StudentModel.find()
        .then(result => {
            console.log("\"ok\": true,\n\"users\":", result);
            res.send({"ok": true, "users": result});
        })
        .catch (error => {
            console.log("ERROR: ", error);
            res.send({code: 400, message:error});
        })
    } else {
        res.send({code: 401, message:"token is not valid"});
    }
});

// Put para actualizar la imagen

app.put('/users', (req, res) => {  // Funciona correctamente

    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        StudentModel.findByIdAndUpdate('63d7c26ef874c4d20e0b6d7e',
        {$set: {image: "urlnueva.jpg"}},
        {new:true})
        .then(result => {
            console.log("Contact updated:", result);
            res.send(result);
        })
        .catch (error => {
            console.log("ERROR:", error);
            res.send({"ok": false, code: 401, message:"Error updating user: 63d7c26ef874c4d20e0b6d7e"});
        });
    } else {
        res.send({"ok": false, code: 401, message:"Error updating user: 63d7c26ef874c4d20e0b6d7e"});
    }
});


// hasta aqui el servicio de usuarios -------------------------------------------------------------------->>>> users

// Get para listar los mensajes

app.get('/messages', (req, res) => {    // Funciona correctamente
    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        StudentModel2.find()
        .then(result => {
        console.log("ok: true", result);
        res.send({"ok": true, "messages": result});
        })
        .catch (error => {
            console.log("ERROR: ", error);
            res.send({code: 400, message:"Error getting messages"});
        })
    } else {
        res.send({"ok": false, code: 401, message:"Error getting messages"});
    }
});

// mensaje para un usuario en concreto por ID

app.post('/messages/:to', (req, res) => { // Funciona correctamente
    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        let studentMesage = new StudentModel2({  
            from: '63d8348906faf1c3ad0cb36b' ,
            to: req.params.to,
            message: req.body.message,
            image: req.body.image,
            sent: req.body.sent
        });
        studentMesage.save()
        .then(result => {
            console.log("ok: true", result);
            res.send({"ok": true, "messages": result});
            })
            .catch (error => {
                console.log("ERROR: ", error);
                res.send({code: 400, message:"Error postting messages"});
            })
    } else {
        res.send({"ok": false, code: 401, message:"Error message user: " + req.params.to});
    }
});

// Delete para eliminar un mensaje por id de usuario

app.delete('/messages/:id', (req, res) => { // Funciona correctamente
    let token = req.headers['authorization'];
    let result = validateToken(token);

    if (result) {
        StudentModel2.findByIdAndDelete(req.params.id)
        .then(result => {
            res.send({"ok": true, "Delete": result});
        })
        .catch (error => {
            console.log("ERROR: ", error);
            res.send({code: 400, message:"Error deleting messages"});
        })
    } else {
        res.send({"ok": false, code: 401, message:"Error deleting messages"});
    }
});

// hasta aqui el servicio de mensajes ----------------------------------------------------------------->>>> messages

// Puerto de escucha del API

app.listen(8081);
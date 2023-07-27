var mongoose = require('mongoose');
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


// Funcion elimina elemento (uno solo)
//StudentModel.deleteOne({
//   name:"Javier"
//}).then(result => {
 //   console.log("Contact removed:", result);
//}).catch (error => {
//    console.log("ERROR:", error)
//});


//Funcion eliminar todos los elementos
//StudentModel.deleteMany({
 //   name:"Javier"
 //}).then(result => {
 //    console.log("Contact removed:", result);
 //}).catch (error => {
//     console.log("ERROR:", error)
 //});


// Funcion buscar y mostrar
StudentModel.find({
    name:"Javier"
 }).then(result => {
     console.log("Contact find:", result);
 }).catch (error => {
     console.log("ERROR:", error)
 });


 //Funcion actualizar y mostrar

 StudentModel.findByIdAndUpdate('63cac2c5e373c4f94ef58ec4',
    {$set: {name:'Javi', age: 39}},
    {new:true}).then(result => {
        console.log("Contact updated:", result);
 }).catch (error => {
    console.log("ERROR:", error);
 });
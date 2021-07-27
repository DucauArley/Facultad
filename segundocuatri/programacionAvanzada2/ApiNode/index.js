const express = require('express');
const app = express();
const direcciones = require('./routes/direcciones');
const cors = require('cors');

//header('Access-Control-Allow-Origin: *');
//header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');


app.use('/direcciones', direcciones);
//Asi puedo diferenciar las rutas dependiendo en que tabla este haciendo que cosa

app.listen(3100, ()=>{
    console.log('Servidor iniciando...');
});

app.use(cors(
    {
        origin: "*",
        credentials: true
    }
  ));































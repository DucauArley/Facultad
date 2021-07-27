var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'pps'
});
// En donde dice database pone el nombre de tu db que creo que era pps2 

connection.connect();

function getAll()
{
    return new Promise((resolve, reject)=>{
        connection.query('SELECT * from direcciones', function (error, results, fields) {
        if (error)
        {
            return reject(error);
        }

        resolve(results);

        });
    })
}

function getOne(id)
{
    return new Promise((resolve, reject)=>{
        connection.query('SELECT * from direcciones WHERE idDireccion = ' + id, function (error, results, fields) {
        if (error)
        {
            return reject(error);
        }

        resolve(results);

        });
    })
}

function insert()
{
    return new Promise((resolve, reject)=>{
        connection.query('INSERT INTO direcciones SET ?', {idDireccion: 3, Calle: "Calle falsa", Ciudad: "BSAS", Departamento: "Necochea", Provincia: "BSAS", CP: 1870, Numeracion: 200, InfoExtra: 0}, function (error, results, fields) {
        if (error)
        {
            return reject(error);
        }

        resolve(results);

        });
    })
}

function borrarUno(id)
{
    return new Promise((resolve, reject)=>{
        connection.query('DELETE FROM direcciones WHERE idDireccion =' + id, function (error, results, fields) {
        if (error)
        {
            return reject(error);
        }

        resolve(results);

        });
    })
}

function update(id)
{
    return new Promise((resolve, reject)=>{
        connection.query('UPDATE direcciones SET calle = ?, ciudad = ? WHERE idDireccion =' + id,["San Martin", "Lanus"], function (error, results, fields) {
        if (error)
        {
            return reject(error);
        }

        resolve(results);

        });
    })
}


//connection.end();

module.exports.getAll = getAll;
module.exports.getOne = getOne;
module.exports.insert = insert;
module.exports.borrarUno = borrarUno;
module.exports.update = update;
const fs = require('fs');
const {writeFile} = require('fs');// Para incluir solamente el metodo
const {readFile} = require('fs');
const http = require('http');
const server = http.createServer((req, res)=>
{
    console.log("Entra");

    res.write("Hola http server");

    var date = new Date();
    var dateAct = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    console.log(dateAct);
    switch(req.method)
    {
        case 'POST':
            if(req.url == "/logs")
            {
                writeFile("Readme.md", "Fecha: " + dateAct, error=>
                {
                    if(error)
                    {
                        return console.log(error);
                    }
                    console.log("Exito");
                });
            }
            else
            {
                res.write("Url desconocida");
            }
            break;
        case 'GET':
            if(req.url == "/logs")
            {
                readFile("Readme.md", (error, data)=>
                {
                    if(error)
                    {
                        return console.log(error);
                    }

                    //res.write(data); No se porque no me deja escribirlo en el res, supongo que es por el <buffer>

                    console.log(data);

                    console.log("Exito");
                });
            }
            else
            {
                res.write("Url desconocida");
            }

            break;
        default:
            res.write("Metodo no permitido");
    }

    res.end();
});


server.listen(3333, ()=>
{
    console.log("Servidor escuchando en puerto 3333");
})
//fs.writeFileSync("Readme.md", "Hellow there");


//console.log(process);
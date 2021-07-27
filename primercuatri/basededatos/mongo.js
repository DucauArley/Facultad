const { count } = require("console");

var conn = new Mongo('localhost:27017');
db = conn.getDB('miDb');

/*var maximo = db.guia1.find().sort({edad:-1}).limit(1).toArray();
db.guia1.update({edad: maximo[0].edad}, {$set: {name: "Sin datos"}});*/
//db.guia1.update({name: "Sin datos"}, {$set: {name: "Jose", apellido: "Sanchez", edad: 33, legajo: 123}});

//db.guia1.updateMany({}, {$inc: {edad: -1}});

//db.guia1.updateMany({}, {$unset: {legajo: 1}});

//db.guia1.remove({edad:29});

//db.personas.find({}, {_id: 0, email: 0, sexo: 0, ciudad_nacimiento: 0, departamento: 0}).sort({sueldo: -1}).pretty();
//db.personas.find({sueldo:{$gt: 50000}, departamento:{$ne: "Research and Development"}}, {nombre: 1, apellido: 1, departamento: 1, sueldo: 1}).sort({sueldo: -1}).pretty();

//db.personas.find({sueldo:{$gt: 15000,$lt: 25000}}).sort({nombre: 1}).pretty()

//db.personas.find({sueldo:{$gt: 15000,$lt: 25000}, "empresa.facturacion": {$gt: 50000000}}).pretty()

//db.personas.find({"empresa.fundacion": 1982}).pretty()

//db.personas.find({$or: [{sueldo:{$gt: 39000}}, {"empresa.facturacion": {$lt: 10000000}}]}).pretty()
//db.personas.find({ciudad_nacimiento: {$ne: "Florida"}}).count()

//db.banks.find({mjtheme: ["Public sector governance"]}, {mjtheme: 1}).pretty()
//db.banks.find({mjtheme: "Public sector governance"}, {mjtheme: 1}).pretty()

//db.banks.find({id: "P086592"}, {sector: 1}).pretty()

//db.personas.createIndex({nombre: 1, apellido: 1}, {name: "Persona"})
//db.personas.getIndexes()
//db.personas.dropIndexes()
//db.personas.dropIndex("Persona")

//db.films.createIndex({overview: 'text',original_title: 'text',title: 'text', "cast.character": 'text', "cast.name": 'text'}, {weights:{overview: 3,original_title: 10,title: 10, "cast.character": 5, "cast.name": 5}})
//db.films.find({$text: {$search: "alien"}}).pretty()
//db.films.find({$text:{$search:"duval -nikki"}}).pretty()  
//db.films.findOne({$text:{$search:"duro de matar"}})
//db.films.findOne({$text:{$search:"duro de matar"}}, {score: {$meta: 'textScore'}})

//load("C:/Users/ArleyZohan/Desktop/mongo.js")

//Agregation framework
//1db.films.aggregate([{$match:{original_language: "it"}}]).pretty()
//2db.films.aggregate([{$match:{original_language: "it", vote_average:{$gt: 7} }}]).pretty()
//3db.films.aggregate([{$match:{original_language: "it", vote_average:{$gt: 12}}}, {$project:{_id: 1, title: 1, vote_average: 1, cast: 1}}]).pretty();
//4db.films.aggregate([{$match:{original_language: "it", vote_average:{$gt: 7}}}, {$project:{_id: 1, title: 1, vote_average: 1, cast: 1, "votos":"$vote_count"}}]).pretty()
//5db.films.aggregate([{$match:{original_language: "it", vote_average:{$gt: 7}}}, {$project:{_id: 1, title: 1, vote_average: 1, cast:{$slice:["$cast", 3]}, "votos":"$vote_count"}}]).pretty()
//6db.films.aggregate([{$match:{original_language: "it", vote_average:{$gt: 7}}}, {$project:{_id: 1, title: 1, vote_average: 1, cast:{$slice:["$cast", 3, 4]}, "votos":"$vote_count"}}]).pretty() No toma la tercera posicion
//7db.films.aggregate([{$match:{original_language: "es"}}, {$project:{_id: 0,title: 1, "comentario":{$substrCP:["$overview",0,100]}}}]).pretty();
//8db.films.aggregate([{$match:{original_language: "es"}}, {$project:{title: 1, "cantidad":{$size: "$cast"}}}]).pretty()
//9db.films.aggregate([{$match:{_id: ObjectId("58fa4a7999315a42d17d2b78")}}, {$project:{_id: 0, title: 1, original_title: 1, "actor":"$cast.name", "personaje":"$cast.character"}}]).pretty()
//10db.films.aggregate([{$match:{"cast.character": {$regex : ".*Stormtrooper.*"}}}, {$project:{_id: 0, title: 1, original_title: 1, "actor":"$cast.name", "personaje":"$cast.character"}}]).pretty() No funca bien

//Agregation framework 2

//1db.zips.aggregate([{$group: {_id: "$state"}}])
//2db.zips.aggregate([{$group: {_id: "$state", count:{$sum: 1}}}])
//3db.zips.aggregate([{$group: {_id: "$state", count:{$sum: 1}}}, {$sort:{count: -1}}])
//4db.zips.aggregate([{$group: {_id:{ciudad:"$city", estado:"$state"}}}, {$sort:{estado: 1}}]) No funca el ordenamiento
//5db.zips.aggregate([{$group: {_id: "$city", count:{$sum: 1}}}, {$sort:{count: -1}}])
//6db.zips.aggregate([{$group: {_id:{ciudad:"$city"}, poblacion:{$sum:"$pop"}, count:{$sum: 1}}}, {$project:{ciudad: "$_id.ciudad", poblacion:1,  count: 1, _id: 0}}, {$sort:{count: -1}}])
//7db.zips.aggregate([{$group: {_id:{estado:"$state", ciudad:"$city"}, poblacion:{$sum:"$pop"}, promedioPoblacion:{$avg: "$poblacion"}}}, {$project:{estado:"$_id.estado", poblacion: 1, _id:0}}]) no funca


//Agreggation framework 3
//1db.barcos.aggregate({$lookup: {from: "containers", as:'containers', foreignField: 'shipName', localField: 'Name'}}).pretty()

//2db.barcos.aggregate({$lookup:{from:'containers', as:'containers', let:{ship: "$Name"}, pipeline:[{$match:{$expr:{$and:[{$eq:["$$ship", "MSC Zoe"]}, {$eq: ["$shipName", "$$ship"]}]}}}, {$project: {Tons: 1, location: 1, cargo: 1}}]}}).pretty()



//db.barcos.aggregate({$lookup:{from:'containers', as:'containers', let:{ship: "$Name"}, pipeline:[{$match:{$expr:{$and:[{$eq: ["shipName", "$$ship"]}, {$gte:["$Tons", 38]}]}}}, {$project: {Tons: 1, location: 1, cargo: 1}}]}}).pretty()

//Usuarios y roles

//1mongod --auth
//2mongo -u 'usuario' -p'Contraseña' --authenticationDatabase 'La db a usar'
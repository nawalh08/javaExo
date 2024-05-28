const redis = require("redis");
const host = "127.0.0.1";
const port = "6379"

const client = redis.createClient(port,host);

client.on("connect" , (err)=>{
    console.log(err);
    console.log("Connected to redis server");
})
.connect
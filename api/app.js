const express = require("express")
const usersrouter = require("./routes/usersrouter") 

class App
{
    constructor()
    {
        this.express = express()
        this.routes()
    }

    routes()
    {
        this.express.use("/user", usersrouter)



        this.express.use('*', (req,res) => {
            res.send("Request invalido");
        });
    }
}

module.exports = App;
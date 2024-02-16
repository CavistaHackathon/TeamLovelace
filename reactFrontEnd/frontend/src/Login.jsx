import 'bootstrap/dist/css/bootstrap.css';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useState } from 'react';


const port = process.env.REACT_APP_PORT_NO;
const serverIp = process.env.REACT_APP_SERVER_IP;

function Login(){
    const [username, setUsername] = useState("");
    const [pass, setPass] = useState("");
    const onUsernameChange = (e)=>{
        setUsername(e.target.value);
    }

    const onPassChange =(e)=>{
        setPass(e.target.value);
    }


    // const sendLoginDetails =()=>{
    //     const payload = {"username":username, "pass":pass}
    //     axios.post(serverUrl + "/user/login", payload);
    // }


    return(
        <>
            <div style={{"textAlign": "center"}} className="container">
                <div className=" borderStyle" style={{"marginTop":"8%"}} >
                <p className="logoFont" style={{ "fontSize": "50px"}}>Login to </p>
                <input className="searchBox" value={username} type="text" name="username" placeholder="Email" onChange={onUsernameChange}/>
                <br></br>
                <input className="searchBox" type="password" value={pass} name="pass" placeholder="Password" onChange={onPassChange} />
                <br></br>
                <button className="LinkedInFreeTrail" onClick={()=>{
                    const payload={"username":username ,"pass":pass}
                    axios.post("http://localhost:8080/user/login",payload).then(Response.redirect("/Home")).catch(Response.redirect("/Login"));
                }} >Login</button>
                <br></br>
                <p className="myfont greyText"> Haven't registered with us yet?{" "}
                    <Link to="/Register">
                    <br></br>
                        Register now
                    </Link></p>
                </div>
            </div>
        </>
    )
}

export default Login;
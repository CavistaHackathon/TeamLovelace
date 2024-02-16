import 'bootstrap/dist/css/bootstrap.css';
import { useState } from 'react';
import axios from 'axios';


function Dashboard(){
    const serverIp = "http://localhost:8080";
    const [userData, setUserData] = useState({});
    axios.get(serverIp + "/user/getCurrentSession").then((resp)=>{
        setUserData(resp.data);
    })
    return(
        <>
            <div>{userData}</div>
            <div style={{"textAlign":"center"}}>
                <h1 className='logoFont'>Welcome, </h1>
            </div>
        </>
    )
}

export default Dashboard;
import 'bootstrap/dist/css/bootstrap.css';
import { useState } from 'react';
import axios from 'axios';
import { useEffect } from 'react';

function Dashboard(){
    const serverIp = "http://localhost:8080";
    const [userData, setUserData] = useState("");
    const getData = ()=>{
        axios.get(serverIp + "/user/getCurrentSession").then((resp)=>{
            setUserData(resp.data);
        });
    }
    // useEffect(()=>{
    //     axios.get(serverIp + "/user/getCurrentSession").then((resp)=>{
    //         setUserData(resp.data);
    //     });
    // },[])

    

    return(
        <>
            <button onClick={getData}> CLICK</button>
            <div>{userData}</div>
            <div style={{"textAlign":"center"}}>
                <h1 className='logoFont'>Welcome, </h1>
            </div>
        </>
    )
}

export default Dashboard;
import 'bootstrap/dist/css/bootstrap.css';
import { useState } from 'react';


function Dashboard(){
    const [username, setUsername] = useState("");
    return(
        <>
            <div style={{"textAlign":"center"}}>
                <h1 className='logoFont'>Welcome, </h1>
            </div>
        </>
    )
}

export default Dashboard;
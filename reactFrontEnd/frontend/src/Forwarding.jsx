import {Routes, Route} from 'react-router-dom'
// import Login from './Login'
import Home from './Home';
import Login from './Login';
function Forwarding(){
    return (
        <>
            <nav className="navbar navbar-expand-lg ">
                <a className="navbar-brand logoFont" href="#">Navbar</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div className="navbar-nav">
                    <a className="nav-item nav-link active" href="#">Home <span className="sr-only">(current)</span></a>
                    <a className="nav-item nav-link" href="#">Features</a>
                    <a className="nav-item nav-link" href="#">Pricing</a>
                    <a className="nav-item nav-link disabled" href="#">Disabled</a>
                </div>
                </div>
            </nav>
            <Routes>
                <Route path="/" element={<Login/>}/>
            </Routes>
        </>
    )
}

export default Forwarding;
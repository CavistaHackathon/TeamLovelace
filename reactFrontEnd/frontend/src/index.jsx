import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './Home';
import 'bootstrap/dist/css/bootstrap.css';
import { BrowserRouter } from 'react-router-dom';
import Forwarding from './Forwarding';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Forwarding></Forwarding>
    </BrowserRouter>
  </React.StrictMode>
);
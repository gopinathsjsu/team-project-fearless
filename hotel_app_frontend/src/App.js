//import logo from './logo.svg';
import './App.css';
import React from 'react';
import LandingPage from "./components/Home/LandingPage";
//import {Container, Row, Col, Navbar} from 'react-bootstrap';
import {Link, BrowserRouter} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <LandingPage/>
      </div>
    </BrowserRouter>
  );
}

export default App;
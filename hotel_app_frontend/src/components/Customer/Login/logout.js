import React, { useState } from 'react';
import { Button } from "react-bootstrap"
import { useNavigate } from 'react-router-dom';

function Logout(props){
    const navigate = useNavigate();
    
    const handleLogout=()=>{
        localStorage.clear();
        props.setLogout(true)
        alert("Logged out succesfully!!"); 
        navigate('/');
    }

    return (
        <div>
            <Button variant = "success" onClick={handleLogout}>Logout</Button>  
        </div>
    )
}

export default Logout;
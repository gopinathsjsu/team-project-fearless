import React, { useState } from 'react';
import { Button } from "react-bootstrap"
import { useNavigate } from 'react-router-dom';

function Logout(props){
    const navigate = useNavigate();
    //const [user,setUser]=useState();
    //const loggedInuser=localStorage.getItem("user");
    //setUser(loggedInuser);

    //const [msg, setMsg]=useState("");
    
    const handleLogout=()=>{
        //setUser({});
        localStorage.clear();
        props.setLogout(true)
        alert("Logged out succesfully!!"); 
        //setMsg ("Logged out successfully");
        navigate('/');
    }

    return (
        <div>
            <Button onClick={handleLogout}>Logout</Button>  
        </div>
    )
}

export default Logout;
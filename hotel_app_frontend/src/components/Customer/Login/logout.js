import React, { useState } from 'react';
import { Button } from "react-bootstrap"
import { useNavigate } from 'react-router-dom';

export default function Logout(){
    const navigate = useNavigate();
    const [user,setUser]=useState();
    const loggedInuser=localStorage.getItem("user");
    setUser(loggedInuser);

    const [msg, setMsg]=useState("");

    const handleLogout=()=>{
        setUser({});
        localStorage.clear();
        
        setMsg ("Logged out successfully");
        //navigate('/');
    }

    return (
        <div>
            <Button onClick={handleLogout}>Logout</Button>
            <p>{msg}</p>
        </div>
    )
}

//export default logout;
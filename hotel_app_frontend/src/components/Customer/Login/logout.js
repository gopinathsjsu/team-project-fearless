import {React, useState} from 'react';
import { Button } from 'semantic-ui-react';

export default function logout({setUser}){
    // const [user,setUser]=useState();
    const loggedInuser=localStorage.getItem("user");
    setUser(loggedInuser);

    const [msg, setMsg]=useState("");

    const handleLogout=()=>{
        setUser({});
        
        localStorage.clear();
        setMsg ("Logged out successfully")


    }


    return (
        <div>
            <Button onClick={handleLogout}>Logout</Button>
            <p>{msg} </p>
        </div>
    

    )
}
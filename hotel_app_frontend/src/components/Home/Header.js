import React from "react";
import { Link } from "react-router-dom";
import utilObj  from "../Utils/utils";
import Logout from "../Customer/Login/logout";

function Header() {
  /*const data = JSON.parse(localStorage.getItem("user"));

  try {
      let data = JSON.parse(localStorage.getItem("user"));
        if(data)
          return data
    }catch(err) {
      console.log('Error: ', err.message);
}*/
  //console.log(data);
  /*return (
    <div>
      <Link to="/register">Signup</Link>
      <br/>
      <Link to="/profile">My Profile</Link>
      <br/>
      if(data != null ? <Link to="/">Logout</Link>:<Link to="/login">SignIn</Link> )
    </div>
  )*/
  const isUserLoggedIn = () =>{
    let customerId = utilObj.getCustomerId()
    return (customerId != null)
   // return false
  }

  return(
    <nav className="navbar navbar-dark bg-dark">
       <Link to="/register">Signup</Link>
      <br/>
      <Link to="/profile">My Profile</Link>
      <br/>
      <Link to ="/">Home</Link>
      <br/>
      {isUserLoggedIn()? <Logout></Logout>:<Link to="/login">SignIn</Link> }
    </nav>
  )
};

export default Header;


import React , {useState} from "react";
import { Link } from "react-router-dom";
import utilObj  from "../Utils/utils";
import Logout from "../Customer/Login/logout";
import LoginForm from "../Customer/Login/loginForm";
import'./Styles/HotelSearch.css';

function Header() {
  const [login, setLogin] = useState(false);
  const [logout, setLogout] = useState(false);
  const isUserLoggedIn = () =>{
    let customerId = utilObj.getCustomerId()
    return (customerId != null)
  }

  return(
    <nav className="navbar navbar-dark bg-dark">
       <Link className="header" to="/employee/login">Employee View</Link>  
      <br/>
      <Link className="header" to ="/">Home</Link>
      <br/>
      <Link className="header" to="/profile">My Profile</Link>
      <br/>
      {isUserLoggedIn()? <Logout setLogout={setLogout}/>:<Link className="header" to="/login">SignIn</Link> }      
    </nav>
  )
};

export default Header;


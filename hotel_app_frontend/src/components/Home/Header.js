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
       <Link to="/register">Signup</Link>
      <br/>
      <Link to="/profile">My Profile</Link>
      <br/>
      <Link to ="/">Home</Link>
      <br/>
      {isUserLoggedIn()? <Logout setLogout={setLogout}/>:<Link to="/login">SignIn</Link> }
    </nav>
  )
};

export default Header;


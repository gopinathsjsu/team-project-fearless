import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <div>
      <Link to="/login">SignIn or SignUp</Link>
      <br/>
      <Link to="/profile">My Profile</Link>
    </div>
  )
};

export default Header;
import React,{useState} from "react";
import { Link} from "react-router-dom";
import { Card, Form, Row,Col, Button } from "react-bootstrap";
import logout from "./logout";


import axios from "axios";

export default function LoginForm(){
    const [email,setEmail]=useState("")
    const [password,setPassword]=useState("")

    const [user, setUser]=useState({
        email :"",
        password :""
    })
    

    // const handleChange=(event)=>{
    //     // console.log(event.target.value);
    //     setUser({...user,[event.target.name]:event.target.value})
    // }
    const handleSubmit=(event)=>{

        event.preventDefault();
        console.log(user);
        const user={email,password};
        console.log(user);
        axios.post("http://localhost:8081/login",user).then(res=>{
            if (res.status==200){
                //set state of user
                setUser(res.data)

                // store the user in localStorage
                localStorage.setItem('user', "Customer1");
             
                console.log(res.data)

                // navigate(-1);
                console.log("logged in");
            }
            else{
                console.log("wrong user");
            }
            
        });
        // setUser({email:"",password:""})
        }


//check if user is already logged in        
    const loggedInUser = localStorage.getItem("user");
    if (loggedInUser) {
      const foundUser = JSON.parse(loggedInUser);
      setUser(foundUser);
      window.alert("Already logged in");
    //   navigate(-1);

    }

//If not then return this login form      
    return(
        <React.Fragment>
    
         <Row>
         <Col>
         <Card style={{ width: '35rem', marginLeft:'25rem', marginTop:'5rem' }} >
         {/* <Card.Img variant="top" src="" /> */}
             <Card.Header style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Login</Card.Header>
             <Card.Body>
             <form onSubmit={handleSubmit} >
        
             <Form.Group as={Row} className="mb-3" controlId="1" >
                 {/* <Form.Label column sm="6"><div><h6>Login</h6></div></Form.Label> */}
                 
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email"   id="Email" name="email" placeholder="Email" onChange={({target})=>setEmail(target.value)} required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                

                 <Form.Floating className="mb-3">
                 <Form.Control type="password"  id="Password" name="password" placeholder="Password" onChange={({target})=>setPassword(target.value)} required/>
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 
             </Form.Group>
             <Row>
                 <Col>
                 <Button type="submit" variant="success" size="md" active>Login</Button>
                 </Col>
                 <Col> <Link to="/register"style={{color:"green", fontStyle:"italic"}}>New User? Register</Link>
                 </Col>
             </Row>
            
             
             </form>
             </Card.Body>
         </Card>
         </Col>
        
         </Row>
  
        
         <logout setUser={setUser}></logout>
     
     
</React.Fragment>
        
        
    )
}

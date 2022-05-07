import React,{useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card, Form, Row,Col, Button } from "react-bootstrap";
import logout from "./logout";


import axios from "axios";

export default function LoginForm(){
    const navigate = useNavigate();
    const [custEmail,setEmail]=useState("")
    const [custPassword,setPassword]=useState("")

    const [user, setUser]=useState({
        custEmail:"",
        custPassword :""
    })
    

    // const handleChange=(event)=>{
    //     // console.log(event.target.value);
    //     setUser({...user,[event.target.name]:event.target.value})
    // }
    const handleSubmit=(event)=>{

        event.preventDefault();
        //console.log(user);
        const user={custEmail,custPassword};
        console.log(user);
        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/customer/login",user).then(res=>{
            if (res.status==200){


                console.log("res data ",res.data.object);
                localStorage.setItem("customer",JSON.stringify(res.data.object));
                localStorage.setItem("custName",JSON.stringify(res.data.object.custFirstName));
                localStorage.setItem("custId",JSON.stringify(res.data.object.customerId));
                localStorage.setItem("custLP",JSON.stringify(res.data.object.loyaltyPoints));
                console.log("LP",localStorage.getItem("custLP"));
                console.log("setting customer Id in local storage",localStorage.getItem("custId")); //output = 13


                //set state of user
                setUser(res.data.object);
                navigate('/');
              
            }
            else{
                console.log("wrong user");
            }
            
        });
        setUser({custEmail:"",custPassword:""})
    }


//check if user is already logged in        
    // const loggedInUser = localStorage.getItem("user");
    // if (loggedInUser) {
    //     try {
    //         const foundUser = JSON.parse(loggedInUser);
    //         //window.alert("Already logged in");
    //         setUser(foundUser); 
    //     }catch(err) {
    //         console.log('Error: ', err.message);
    //     }
        

    // }
    

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
                 <Form.Control type="email"   id="Email" name="custEmail" placeholder="Email" onChange={({target})=>setEmail(target.value)} required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                

                 <Form.Floating className="mb-3">
                 <Form.Control type="password"  id="Password" name="custPassword" placeholder="Password" onChange={({target})=>setPassword(target.value)} required/>
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 
             </Form.Group>
             <Row>
                 <Col>
                 <Button type="submit" variant="success" size="md" active >Login</Button>
                 </Col>
                 <Col> <Link to="/register"style={{color:"green", fontStyle:"italic"}}>New User? Register</Link>
                 </Col>
             </Row>
            
             
             </form>
             </Card.Body>
         </Card>
         </Col>
        
         </Row>
  
        
         {/* <logout setUser={setUser}></logout>
      */}
     
</React.Fragment>
        
        
    )
}

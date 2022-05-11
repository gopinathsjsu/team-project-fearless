import React,{useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card, Form, Row,Col, Button } from "react-bootstrap";



import axios from "axios";

export default function EmployeeLogin(){
    const navigate = useNavigate();
    const [empEmail,setEmail]=useState("")
    const [empPassword,setPassword]=useState("")
    
    const handleSubmit=(event)=>{

        event.preventDefault();
       
        const emp={empEmail,empPassword};
        console.log(emp);
        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/employee/empLogin",emp).then(res=>{
            if (res.status==200){
                console.log("res data ",res.data.object);
                navigate('/employee/homepage');
              
            }
            else{
                console.log("wrong user");
            }
            
        });
        // setUser({custEmail:"",custPassword:""})
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
             <Card.Header style={{textAlign:'center', color:'green', fontStyle:"italic"}}> Employee Login</Card.Header>
             <Card.Body>
             <form onSubmit={handleSubmit} >
        
             <Form.Group as={Row} className="mb-3" controlId="1" >
                 {/* <Form.Label column sm="6"><div><h6>Login</h6></div></Form.Label> */}
                 
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email"   id="Email" name="empEmail" placeholder="Email" onChange={({target})=>setEmail(target.value)} required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                

                 <Form.Floating className="mb-3">
                 <Form.Control type="password"  id="Password" name="empPassword" placeholder="Password" onChange={({target})=>setPassword(target.value)} required/>
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 
             </Form.Group>
             <Row>
                 <Col>
                 <Button type="submit" variant="success" size="md" active >Login</Button>
                 </Col>
                 <Col> <Link to="/employee/register"style={{color:"green", fontStyle:"italic"}}>New Employee? Register</Link>
                 </Col>
             </Row>
            
             
             </form>
             </Card.Body>
         </Card>
         </Col>
        
         </Row>
  
</React.Fragment>
        
        
    )


}
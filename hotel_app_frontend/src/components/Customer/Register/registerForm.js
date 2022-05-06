import React,{useState} from "react";
import { Button, Card, Form, Row , Col} from "react-bootstrap";

import { Link } from "react-router-dom";
import axios from "axios";

import {useLocation,useNavigate} from 'react-router-dom';


export default function RegisterUser(){
    const [regUserdata, setRegUserdata]=useState({custFirstName:"",custLastName:"",  custPassword:"",custEmail:"",custAddress:"",  loyaltyPoints:"", contactNumber:"", bookingCount:""});
   
    const location = useLocation();
    const nav=useNavigate();

    const handleChange=(event)=>{
        // console.log(event.target.value);
        setRegUserdata({...regUserdata,[event.target.name]:event.target.value})
    }
    const handleSubmit=(event)=>{
        event.preventDefault();
        console.log(regUserdata);
 

        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/customer/register",regUserdata)
    
        .then(res=>{
            if (res.status==200){
                console.log(res.data)
                nav('/login');

       
                console.log("registration successful");
            }
            else{
                console.log("registration unsuccessful");
            }
            
        });
     
       
        setRegUserdata({custFirstName:"",custLastName:"",  custPassword:"",custEmail:"",custAddress:"",  loyaltyPoints:"", contactNumber:"",bookingCount:""})
        

       
    }

return(
  <React.Fragment>

      <Card style={{ width: '35rem', marginLeft:'25rem', marginTop:'2rem' }}>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Create New Account</Card.Header>
          <Card.Body>
          <form onSubmit={handleSubmit} onChange={handleChange}>
              <Form.Group>
              <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Limeka" id="first_name" name="custFirstName" required />
                 <label htmlFor="first_name" style={{marginLeft:10}} > First Name</label>
                 </Form.Floating>
                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Dabre" id="last_name" name="custLastName" required/>
                 <label htmlFor="last_name" style={{marginLeft:10}} > Last Name</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="22 W 3rd st" id="address" name="custAddress" />
                 <label htmlFor="address" style={{marginLeft:10}} > Address (Optional)</label>
                 </Form.Floating>
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email"  placeholder="email" id="email" name="custEmail" required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="password" placeholder="Password" id="Password" name="custPassword" required />
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="66944554687" id="contact" name="contactNumber" required/>
                 <label htmlFor="contact" style={{marginLeft:10}} > Contact Number</label>
                 </Form.Floating> 
                 
              </Form.Group>
              <Row>
                  <Col>
                  <Button type="submit" variant="success" size="md" active>Register</Button>
                  </Col>
                  <Col>
                  <Link to="/login" style={{color:"green", fontStyle:"italic"}}>Already a user ? Login </Link>

                  </Col>
              </Row>



              </form>
          </Card.Body>
      </Card>
  </React.Fragment>

    
)

}

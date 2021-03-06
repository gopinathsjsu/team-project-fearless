import React,{useState} from "react";
import { Link, useNavigate,useLocation} from "react-router-dom";
import { Card, Form, Row,Col, Button } from "react-bootstrap";



import axios from "axios";

export default function EmployeeRegister(){
    const [regEmpdata, setRegEmpdata]=useState({});
   
    const location = useLocation();
    const nav=useNavigate();

    const handleChange=(event)=>{
        // console.log(event.target.value);
        setRegEmpdata({...regEmpdata,[event.target.name]:event.target.value})
    }
    const handleSubmit=(event)=>{
        event.preventDefault();
        console.log(regEmpdata);
 

        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/employee/empRegister",regEmpdata)
    
        .then(res=>{
            if (res.status==200){
                console.log("res data of registartion api ",res.data)
                nav('/employee/login');

       
                console.log("registration successful");
            }
            else{
                console.log("registration unsuccessful");
            }
            
        });
     
       
        setRegEmpdata({empFirstName:"",empLastName:"",  empPassword:"",empEmail:"", empContactNumber:""})
        

       
    }

return(
  <React.Fragment>

      <Card style={{ width: '35rem', marginLeft:'25rem', marginTop:'2rem' }}>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Create New Account</Card.Header>
          <Card.Body>
          <form onSubmit={handleSubmit} onChange={handleChange}>
              <Form.Group>
              <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Limeka" id="first_name" name="empFirstName" required />
                 <label htmlFor="first_name" style={{marginLeft:10}} > First Name</label>
                 </Form.Floating>
                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Dabre" id="last_name" name="empLastName" required/>
                 <label htmlFor="last_name" style={{marginLeft:10}} > Last Name</label>
                 </Form.Floating>
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email"  placeholder="email" id="email" name="empEmail" required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="password" placeholder="Password" id="Password" name="empPassword" required />
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="66944554687" id="contact" name="empContactNumber" required/>
                 <label htmlFor="contact" style={{marginLeft:10}} > Contact Number</label>
                 </Form.Floating> 
                 
              </Form.Group>
              <Row>
                  <Col>
                  <Button type="submit" variant="success" size="md" active>Register</Button>
                  </Col>
                  <Col>
                  <Link to="/employee/login" style={{color:"green", fontStyle:"italic"}}>Already registered ? Login </Link>

                  </Col>
              </Row>



              </form>
          </Card.Body>
      </Card>
  </React.Fragment>

    
)

}
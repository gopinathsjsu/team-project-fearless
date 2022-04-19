import React,{useState} from "react";
import { Button, Card, Form, Row , Col} from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";




export default function RegisterUser(){
    const [regUserdata, setRegUserdata]=useState({first_name:"",last_name:"", address:"", email:"", password:"",  contact:""});
    const history=useHistory()

    const handleChange=(event)=>{
        // console.log(event.target.value);
        setRegUserdata({...regUserdata,[event.target.name]:event.target.value})
    }
    const handleSubmit=(event)=>{
        event.preventDefault();
        console.log(regUserdata);
       
        setRegUserdata({first_name:"",last_name:"", address:"", email:"", password:"",  contact:""})
        history.push("/login");
    }

return(
  <React.Fragment>
      <Card style={{ width: '35rem', marginLeft:'25rem', marginTop:'2rem' }}>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Create New Account</Card.Header>
          <Card.Body>
          <form onSubmit={handleSubmit} onChange={handleChange}>
              <Form.Group>
              <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Limeka" id="first_name" name="first_name" required />
                 <label htmlFor="first_name" style={{marginLeft:10}} > First Name</label>
                 </Form.Floating>
                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="Dabre" id="last_name" name="last_name" required/>
                 <label htmlFor="last_name" style={{marginLeft:10}} > Last Name</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="22 W 3rd st" id="address" name="address" />
                 <label htmlFor="address" style={{marginLeft:10}} > Address (Optional)</label>
                 </Form.Floating>
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email"  placeholder="email" id="email" name="email" required/>
                 <label htmlFor="Email" style={{marginLeft:10}} > Email</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="password" placeholder="Password" id="Password" name="password" required />
                 <label htmlFor="Password" style={{marginLeft:10}}> Password</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  placeholder="66944554687" id="contact" name="contact" required/>
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

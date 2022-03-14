import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import { Card } from 'react-bootstrap';
import { Form } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';


import axios from 'axios';
import CustomerPage from './CustomerPage';

class CustomerSignUp extends Component{
    constructor(props){
        super(props);
        this.state={
            custFirstName:'',
            custLastName : '',
            custEmail :''	,
            custPassword :'',
            custcontactNo : '',
            isValid:false
        }

    }

    handlecustFnameChange=(e)=>{
        this.setState({ custFirstName: e.target.value });
    }
    handlecustLnameChange=(e)=>{
        this.setState({ custLastName: e.target.value });
    }

    handlecustEmailChange=(e)=>{
        this.setState({ custEmail: e.target.value });
    }

    handlecustPassowrdChange=(e)=>{
        this.setState({ custPassword: e.target.value });
    }

    handlecustContactNoChange=(e)=>{
        this.setState({ custcontactNo: e.target.value });
    }
    
    createCustomer=(event)=>{
        event.preventDefault();

        const CustomerData={
            custFirstName:this.state.custFirstName,
            custLastName : this.state.custLastName,
            custEmail :this.state.custEmail,
            custPassword :this.state.custPassword,
            custcontactNo :this.state.custcontactNo
        }

        axios.post('http://localhost:3000//customer/signup',CustomerData).then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });

    }
    render() {
        return (<React.Fragment>
        
            <Container fluid>
            <Row>
             <Col><div >
             <Card bg={'Primary'.toLowerCase()}
                border="light"
                text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
                className="mb-2">
              <Card.Body><h5>SignUp</h5></Card.Body>
            </Card>
           </div></Col>
        </Row>
         {this.state.isValid===false?(
             <Row >
             <Col>
             <Card style={{ width: '30rem' }} >
                 <Card.Body>
                 <form onSubmit={this.createCustomer}>
            
                 <Form.Group as={Row} className="mb-3" controlId="1" >
                     {/* <Form.Label column sm="6"><div><h6>Create Account</h6></div></Form.Label> */}
                     
                     <Form.Floating className="mb-3">
                     <Form.Control type="text" placeholder="FirstName" id="FirstName" value={this.state.custFirstName} onChange={this.handlecustFnameChange}/>
                     <label className="" htmlFor="FirstName" column sm="2"> First Name</label>
                     </Form.Floating>
                     
                     <Form.Floating className="mb-3">
                     <Form.Control type="text" placeholder="LastName" id="LastName" value={this.state.custLastName} onChange={this.handlecustLnameChange}/>
                     <label htmlFor="LastName" column sm="2"> Last Name</label>
                     </Form.Floating>

                     <Form.Floating className="mb-3">
                     <Form.Control type="email" placeholder="Email" id="Email" value={this.state.custEmail} onChange={this.handlecustEmailChange}/>
                     <label htmlFor="Email" > Email</label>
                     </Form.Floating>

                     <Form.Floating className="mb-3">
                     <Form.Control type="password" placeholder="Password" id="Password" value={this.state.custPassword} onChange={this.handlecustPassowrdChange}/>
                     <label htmlFor="Password" > Password</label>
                     </Form.Floating>

                     <Form.Floating className="mb-3">
                     <Form.Control type="text" placeholder="ContactNo" id="ContactNo" value={this.state.custcontactNo} onChange={this.handlecustContactNoChange}/>
                     <label htmlFor='ContactNo' > Contact No</label>
                     </Form.Floating>

                 </Form.Group>

                 <Button type="submit" variant="primary" size="md"  active>Sign Up</Button>
                 </form>
                 </Card.Body>
             </Card>
             </Col>
         </Row> ):(
            <CustomerPage myPropEmail={this.state.custEmail} 
                          myPropFname={this.state.custFirstName}
                          myPropLname={this.state.custLastName}></CustomerPage>
         )}
         </Container>
    </React.Fragment>)
         }

}

export default CustomerSignUp;
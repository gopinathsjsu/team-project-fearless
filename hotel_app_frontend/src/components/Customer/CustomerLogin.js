import React, { Component } from 'react'
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import { Card } from 'react-bootstrap';
import { Form } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import axios from 'axios';
import CustomerPage from './CustomerPage';

class CustomerLogin extends Component {

  constructor(props){
    super(props);
    this.state =  { custEmail: '',
                    custPassword: '',
                    custFirstName: '',
                    custLastName: '',
                    isValid:false};
}

handleCustEmailChange = (e) => {
    this.setState({ custEmail: e.target.value });
}

handleCustPasswordChange = (e) => {
    this.setState({ custPassword: e.target.value });
}

loginCustomer=(event)=>{
    event.preventDefault();

    const postData = {
      custEmail: this.state.custEmail,
      custPassword: this.state.custPassword
    }
    
    // axios.post('http://localhost:3000//Customer/authenticate', postData).then(response => response.data)
    //  .then((data) => {
    //    console.log(data)

    //    this.setState({
    //        isValid: true
    //    })

    //     this.setState({
    //         custFirstName: data.custFirstName
    //     })
    //     this.setState({
    //         custLastName: data.custLastName
    //     })

    //     console.log(this.state.custFirstName)
    //     console.log(this.state.custLastName)
    // });
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
          <Card.Body><h5>Login</h5></Card.Body>
        </Card>
       </div></Col>
    </Row>
     {this.state.isValid===false?(
         <Row >
         <Col>
         <Card style={{ width: '30rem' }} >
             <Card.Body>
             <form onSubmit={this.loginCustomer}>
        
             <Form.Group as={Row} className="mb-3" controlId="1" >
                 {/* <Form.Label column sm="6"><div><h6>Login</h6></div></Form.Label> */}
                 
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="email" placeholder="Email" id="Email" value={this.state.custEmail} onChange={this.handlecustEmailChange}/>
                 <label htmlFor="Email" > Email</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="password" placeholder="Password" id="Password" value={this.state.custPassword} onChange={this.handlecustPassowrdChange}/>
                 <label htmlFor="Password" > Password</label>
                 </Form.Floating>

                 
             </Form.Group>

             <Button type="submit" variant="primary" size="md"  active>Login</Button>
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
export default CustomerLogin;



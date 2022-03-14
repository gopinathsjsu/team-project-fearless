import React from 'react';
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
// import { Stack } from 'react-bootstrap';
// import { Button } from 'react-bootstrap';
import { Nav } from 'react-bootstrap';
import { Card } from 'react-bootstrap';

import CustomerLogin from './CustomerLogin';
import CustomerSignUp from './CustomerSignUp';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

const CustomerHome = () => (
    <Container fluid  >
     <Row >
       <Col><div >
          <Card bg={'Primary'.toLowerCase()}
                border="light"
                text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
                className="mb-2">
              <Card.Body><h5>Customer</h5></Card.Body>
          </Card>
           </div></Col>
     </Row>
      <Row>
       <Router>
        <div>        
          <Nav fill variant="tabs" >
          <Nav.Item>
              <Nav.Link  href="/customerlogin">Login </Nav.Link>
          </Nav.Item>

          <Nav.Item>
              <Nav.Link eventKey="/customerSignup" href="/customerSignup">Create New Account</Nav.Link>
          </Nav.Item>
          </Nav>
          {/* <Col><Link to="/customerSignup"> <Button  variant="light">Create New account</Button></Link>
          </Col>
          

         <Col> <Link to="/customerlogin"> <Button variant="light">Login</Button></Link></Col> */}

          <Switch>
          <Route path="/customerlogin">
              <CustomerLogin/>
            </Route>
            <Route path="/customerSignup">
              <CustomerSignUp/>
            </Route>
          </Switch>
        </div>
      </Router>
      </Row>
      </Container>);

export default CustomerHome;
import React from 'react';
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import { Card } from 'react-bootstrap';

import Button from 'react-bootstrap/Button';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import CustomerSignUp from './components/Customer/CustomerSignUp';
import CustomerLogin from './components/Customer/CustomerLogin';
import CustomerPage from './components/Customer/CustomerPage';
import CustomerHome from './components/Customer/CustomerHome';
function App() {
  return (<React.Fragment>    
    <Container fluid>
    <Router> 
      <Row>
        <Col><div >
        <Card bg={'Primary'.toLowerCase()}
              border="light"
              text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
              className="mb-2">
              <Card.Body>
              <Row>
              <Col>
              <h4>Hotel Booking Application</h4>
               </Col>
              <Col>
               
               
              <Link to="/customerhome"> <Button  variant="light">Are you a Customer?</Button></Link>
              <Link to="/adminhome"> <Button variant="light">Are you a Hotel ?</Button></Link>
              <Link to="/"> <Button variant="light">Logout</Button></Link>
              </Col>
              </Row>
            </Card.Body>
        </Card>
        </div></Col>
      
      </Row>
                 <Switch>
                    <Route path="/customerhome" component={CustomerHome}/>
                    <Route path='/customerSignup' component={CustomerSignUp} />
                    <Route path='/customerpage' component={CustomerPage} />
                    <Route path='/customerlogin' component={CustomerLogin} />
                    

              </Switch>
              </Router>
      </Container>
    </React.Fragment>
    );
  }
export default App;
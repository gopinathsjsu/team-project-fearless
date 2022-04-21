import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
import RegisterUser from './components/Customer/Register/registerForm';
import LoginForm from './components/Customer/Login/loginForm';
import BookingsPage from './components/Customer/Bookings/bookings';
import DisplayHotels from './components/Customer/DisplayHotels/displayHotels';
import BookRoom from './components/Customer/Bookings/bookroom';
// import Amenities from './components/Customer/Bookings/amenities';

function App(){
  return(
    
      <Router>
        <div>
        <Switch>
          <Route path="/register">
          <RegisterUser/>
          </Route>
        
        <Route path="/login">
          <LoginForm/>
          </Route>

          {/* <Route path="/test">
            <Amenities></Amenities>
          </Route> */}

          {/* <Route path="/bookings/{url}">
          <BookingsPage/>
          </Route> */}
         <Route path = "/user/:id"  component = {BookingsPage} />

          

          <Route path="/displayhotels">
          <DisplayHotels/>
          </Route>

        </Switch>
        </div>
      </Router>

      
    
  )

}
export default App;
// import { Container, Tabs } from 'react-bootstrap';
// import { Row } from 'react-bootstrap';
// import { Col } from 'react-bootstrap';
// import { Card } from 'react-bootstrap';

// import Button from 'react-bootstrap/Button';

// import {
//   BrowserRouter as Router,
//   Switch,
//   Route,
//   Link
// } from "react-router-dom";
// import CustomerSignUp from './components/Customer/CustomerSignUp';
// import CustomerLogin from './components/Customer/CustomerLogin';
// import CustomerPage from './components/Customer/CustomerPage';
// import CustomerHome from './components/Customer/CustomerHome';
// function App() {
//   return (<React.Fragment>    
//     <Container fluid>
//     <Router> 
//       <Row>
//         <Col><div >
//         <Card bg={'Primary'.toLowerCase()}
//               border="light"
//               text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
             
//               className="mb-2">
//               <Card.Body>
//               <Row>
//               <Col>
//               <h4>Hotel Booking Application</h4>
//                </Col>
//               <Col md={1}>
//               {/* <Link to="/customerhome"> <Button  variant="light">Are you a Customer?</Button></Link>
//               <Link to="/adminhome"> <Button variant="light">Are you a Hotel ?</Button></Link> */}
//               <Link to="/"> <Button variant="light">Logout</Button></Link>
//               </Col>
//               </Row>
//             </Card.Body>
//             </Card>
           
//             <Card bg={'Primary'.toLowerCase()}
//               border="light"
//               text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
             
//               className="mb-2">
//             <Row>
//                 <Col className="px-3">
//                 <Link to="/customerhome"> <Button className="my-2"  variant="light">Are you a Customer?</Button></Link>
//                 </Col>
//                 <Col md={3}>
//                 <Link to="/adminhome"> <Button className="my-2" variant="light">Are you a Hotel ?</Button></Link>
//                 </Col>
//               </Row>

//             </Card>
              
            

//              {/* <Card bg={'Primary'.toLowerCase()}
//               border="dark"
//               text={'Primary'.toLowerCase() === 'light' ? 'dark' : 'white'}
//               className="mb-6">
//               <Link to="/adminhome"> <Button variant="light">Are you a Hotel ?</Button></Link>
//               </Card> */}
            
        
//         </div></Col>
      
//       </Row>
//                  <Switch>
//                     <Route path="/customerhome" component={CustomerHome}/>
//                     <Route path='/customerSignup' component={CustomerSignUp} />
//                     <Route path='/customerpage' component={CustomerPage} />
//                     <Route path='/customerlogin' component={CustomerLogin} />
                    

//               </Switch>
//               </Router>
//       </Container>
//     </React.Fragment>
//     );
//   }
// export default App;
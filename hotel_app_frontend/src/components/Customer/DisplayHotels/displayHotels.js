import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import { Card, Form, Row,Col, Button,ListGroup } from "react-bootstrap";
import { FormButton } from 'semantic-ui-react';
import BookRoom from '../Bookings/bookroom';
import { hotels } from './hotels';

export default function DisplayHotels() {


    const [users, setUsers] = useState([]);
    // const [url,setUrl]=useState("");

    const navigate=useNavigate();
    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/users')
            .then((response) => {
                console.log(response.data);
                setUsers(hotels);
                console.log(hotels[0].hotel);
            })
            .catch((error)=>{
                console.log(error);

            })
    }, [])

    
    // const alertClicked=(val)=>{
      
    //     setUrl(val);
   
    //     console.log({url});
        
    //     history.push("/bookings/${url}");

        
    // }

    return (
        
        <React.Fragment>
           
            <Card>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Displaying Search Results</Card.Header>
          <Card.Body>
              
        <ListGroup >
           
            
                {hotels.map(hotel=>{
                    return(
                        
                        <ListGroup.Item key={hotel.hotel.hotelId} >
                    
                            <Row >
                            
                            <Col>{hotel.hotel.hotelname} 
                            </Col>
                            <Col>
                            {hotel.hotel.hotelLocation}
                            </Col>

                            <Col>
                            <Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`user/${hotel.hotel.hotelId}`, state:hotel  }} > Select</Link>
                            
                            </Col>
                            </Row>
                            <Row>
                                <Col>
                                Description of the Hotel
                                </Col> 
                            </Row>
                            
                            </ListGroup.Item>

                                                   
                        );
                    
                })}
        </ListGroup>
        </Card.Body>
  
        </Card>
        </React.Fragment>
)
       

}


import { margin } from '@mui/system';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';

export default function BookRoom(props) {
    const {id}=useParams();

    const nav=useNavigate();
    
  const [hotel,setHotel]=useState({});
  const [roomdata, setRoomData]=useState({ });
  const price=300;
//   hotelid:id, SR:"", DR:"", noOfguests:""
  const amenities=
    [
        {
            "amenityId": 1,
            "amenityCode": "CB",
            "amenityType": "Daily Continental Breakfast",
            "amenityCost": 25
        },
        {
            "amenityId": 2,
            "amenityCode": "FR",
            "amenityType": "Access to fitness room",
            "amenityCost": 25
        },
        {
            "amenityId": 3,
            "amenityCode": "SJ",
            "amenityType": "Access to Swimming Pool/Jacuzzi",
            "amenityCost": 25
        },
        {
            "amenityId": 4,
            "amenityCode": "DP",
            "amenityType": "Daily Parking",
            "amenityCost": 10
        },
        {
            "amenityId": 5,
            "amenityCode": "BF",
            "amenityType": "Breakfast",
            "amenityCost": 10
        },
        {
            "amenityId": 6,
            "amenityCode": "LN",
            "amenityType": "Lunch",
            "amenityCost": 10
        },
        {
            "amenityId": 7,
            "amenityCode": "DN",
            "amenityType": "Dinner",
            "amenityCost": 10
        }
    ]
  
 

//   useEffect(()=>{
//     axios.get('http://localhost:8081/hotel/'+id)
//     .then(response => response.data)
//     .then((data) => {
//       setHotel(data);
//       console.log(data);
//    })
//    .catch((error)=>{
//        console.log(error);
//    })

//   })



const handleChange=(event)=>{
    setRoomData({...roomdata,[event.target.name]:event.target.value});
    console.log(" on change :");
    // console.log(roomdata);
}

  const handleSubmit=()=>{
      console.log(" after handle submit");
      console.log(roomdata);
    
  axios.post('http://localhost:8081/api/calculateprice',roomdata)
  .then(response => response.data).then((data) => {
    console.log(data);
 });
      nav('/payment',{state:roomdata});

  } 

    if(hotel){
        return (
        
           
            <React.Fragment>
<Card border="success">
    <Card.Header style={{textAlign:'center', color:'green', fontStyle:"italic", fontSize:"40px"}}>HOTEL {id}</Card.Header>
    <Card.Body>
        Hotel Name : {hotel.hotelName}
        Hotel address:

</Card.Body>
</Card>

<Card border="success">
    <Card.Body>
        <form onSubmit={handleSubmit} onChange={handleChange}>
            <Form.Group>
            <Form.Label style={{ color:'green', fontStyle:"italic"}}>Select from Available Rooms</Form.Label>
            <ListGroup.Item>
                            <Row>
                            <Col> Single Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" style={{width:100}} name="SR" />
                            </Col>
                            </Row>             
            </ListGroup.Item>
            <ListGroup.Item>
                            <Row>
                            <Col> Deluxe Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" style={{width:100}} name="DR"/>
                            </Col>
                            </Row>             
            </ListGroup.Item>
            </Form.Group>
          <br></br>
            <Form.Group>
                <Row>
                    <Col> <Form.Label style={{ color:'green', fontStyle:"italic"}} >Enter No of Guests</Form.Label>
                    </Col>
                    <Col>            <Form.Control type="number" placeholder="Enter guests" name="noOfguests" />
                    </Col>
                </Row>
            </Form.Group>
        <br></br>

            <Form.Group>
            <Form.Label style={{ color:'green', fontStyle:"italic"}}>Add amenities</Form.Label>

            {amenities.map((amenity) => (
    <div key={amenity.amenityId} className="mb-3">
      <Form.Check type="checkbox" >
        <Form.Check.Input type="checkbox"  name={amenity.amenityCode}  isValid />
        
        <Form.Check.Label>{amenity.amenityType}</Form.Check.Label>
        
      </Form.Check>
    </div>
  ))}
            {/* <ListGroup.Item>
                        {amenities?.map(amenity=>{
                    return(
                        <ListGroup.Item key={amenity.amenityId} >
                            <Row >
                            <Col>{amenity.amenityType} 
                            </Col>
                            <Col>
                            {amenity.amenityCost}$
                            </Col>
                            <Col> 
                            <input type="checkbox" name={amenity.amenityType}   />
                         
                            </Col>
                            </Row>
                            
                            </ListGroup.Item>                     
                        );
                })}
                        </ListGroup.Item> */}
            </Form.Group>
            <br></br>
            <Button variant="success" type="submit" style={{marginLeft:350}}>Checkout</Button>
          </form>
        
      
    </Card.Body>
</Card>
            </React.Fragment>
            
        );

    }
    
}
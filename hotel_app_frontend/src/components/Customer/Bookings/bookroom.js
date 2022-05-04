import { margin } from '@mui/system';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';
import hotelimg from './hotel.jpg';

var dr = "DR";
var sr = "SR";

var amenity = "";
var cb = "CB";
var fr = "FR";
var sj = "SJ";
var dp = "DP";
var bf = "BF";
var ln = "LN";
var dn = "DN";
var room;

export default function BookRoom(props) {
  const {id}=useParams();
 
  const nav=useNavigate();
//    const [ratingdata, setRatingData]=useState({}); 
  const [hotel,setHotel]=useState({});
  const [roomdata, setRoomData]=useState({ customerId:"",hotelId:"",fromDate:"",toDate:"",room:"",amenity:"",noOfGuest:"",cost:""});
  


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



const amenities=JSON.parse(localStorage.getItem('amenities'));

const noGuestHandler=(e)=>{
    setRoomData({...roomdata,[e.target.name]:e.target.value});
}

const handleChange=(event)=>{
    //    console.log(event.target.checked.value)
     
        if (event.target.name == 'DR')
            dr = "DR" + event.target.value
        if (event.target.name == 'SR')
            sr = "SR" + event.target.value

        if (event.target.name == 'CB' && (event.target.value=='on' || amenity.includes("CB")))
            amenity = amenity + "CB" + "-"
        
        if (event.target.name == 'FR' && event.target.value=='on')
            amenity = amenity + "FR" + "-"
        
        if (event.target.name == 'SJ' && event.target.value=='on')
            amenity = amenity + "SJ" + "-"
        
        if (event.target.name == 'DP' && event.target.value=='on')
            amenity = amenity + "DP" + "-"
        
        if (event.target.name == 'BF' && event.target.value=='on')
            amenity = amenity + "BF" + "-"
        
        if (event.target.name == 'LN' && event.target.value=='on')
            amenity = amenity + "LN" + "-"
        
        if (event.target.name == 'DN' && event.target.value=='on')
            amenity = amenity + "DN" + "-"

        room = dr+"-"+sr
     
        console.log("Room Value",room)

        console.log("Amenity Value",amenity);
}

const onCheckPrice=()=>{
    room = dr+"-"+sr
    
    setRoomData({...roomdata,[room]:room});
  
      console.log(" after check price");
      console.log(roomdata);
    //   setPrice(10000);
      
    
  axios.post('http://localhost:8081/api/calculateprice',roomdata)
  .then(response => response.data).then((data) => {
    console.log(data);
    // setPrice(10000);
 });
    

  } 

  const NavtoPayment=()=>{
   nav('/payment',{state:roomdata});
  }

   
        return (
        
           
            <React.Fragment>
<Card border="success" style={{backgroundImage: `url(${hotelimg})`}} >
    <Card.Header style={{textAlign:'center',  color:'green', fontStyle:"italic", fontSize:"40px"}}>HOTEL {id}</Card.Header>
    <Card.Body>
        {/* Hotel Name : {hotel.hotelName} */}
        Hotel address:

</Card.Body>
</Card>

<Card border="success">
    <Card.Body>
        <form  onChange={handleChange}>
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
            <Form.Group style={{marginLeft:'20rem'}}>   
                     <Form.Label style={{ color:'green', fontStyle:"italic"}} >Enter No of Guests</Form.Label>
                     <Form.Control type="number" placeholder="Enter guests" name="noOfGuest" style={{ width: '10rem' }} onChange={noGuestHandler} />
            </Form.Group>
        <br></br>
            <Form.Group>
            <Form.Label style={{ color:'green', fontStyle:"italic"}}>Add amenities</Form.Label>

            {/* {amenities.map((amenity) => (
    <div key={amenity.amenityId} className="mb-3">
      <Form.Check type="checkbox" >
        <Form.Check.Input type="checkbox"  name={amenity.amenityCode}  isValid />
        
        <Form.Check.Label>
            
            </Form.Check.Label>
        
      </Form.Check>
    </div>
  ))} */}   
                        {amenities?.map(amenity=>{
                    return(
                        <ListGroup.Item key={amenity.amenityId} >
                            <Form.Check type="checkbox" >
                            <Row >
                            
                            <Col> <Form.Check.Input type="checkbox" style={{marginLeft:'1rem'}} name={amenity.amenityCode}  isValid />
                            </Col>
                            <Col style={{marginLeft:'-20rem'}}>{amenity.amenityType} 
                            </Col>
                            <Col>
                            {amenity.amenityCost}$
                            </Col>
                            </Row>
                            </Form.Check>
                            </ListGroup.Item>                     
                        );
                })}
                       
            </Form.Group>
            <br></br>
            <Row>
                <Col> <Button variant="success" style={{marginLeft:"20rem"}} onClick={onCheckPrice}> Check Price </Button>
                </Col>
                <Col style={{ color:"#E75480", fontSize:"25px", fontWeight:"bolder"}} > Total Price :  $
                </Col>
            </Row>
       
          </form>
        
      
    </Card.Body>

    <Card.Body>
        <Button  variant="outline-warning"   onClick={NavtoPayment}>PAY $</Button>
    </Card.Body>
</Card>
            </React.Fragment>
            
        );

    }
    

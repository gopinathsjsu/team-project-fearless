import { margin } from '@mui/system';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import Image from 'react-bootstrap/Image'
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';
import hotelimg from './hotel.jpg';
import SRimg from './singleRoom.jpg';
import DRimg from './deluxeRoom.jpg';
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
    // {
    //     "customerId": 1,
    //     "hotelId": 1,
    //     "fromDate": "2022-04-27",
    //     "toDate": "2022-05-02",
    //     "room": "DR3-SR3",
    //     "amenity": "CB-DP",
    //     "noOfGuest": 2,
    //     "cost": 0.0,
    //     "description": "",
    //     "loyaltyPointsUsed":20
    // }
    
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


//     let year = "2020";
// let iyear = parseInt(year, 10);
// console.log(iyear);//2020

  const {id}=useParams();
  const hotel=JSON.parse(localStorage.getItem('hotel'));  //get from local storage 
//   const amenities=JSON.parse(localStorage.getItem('amenities'));
  console.log("local storage hotel is ",hotel);
 
//   const customerId=JSON.parse(localStorage.getItem("user"));
  let hotelId=parseInt(id,10);
  console.log("hotel id in int",hotelId);
  const fromDate=localStorage.getItem("from");
  const toDate=localStorage.getItem("to");
    
const [noOfGuest,setNoOfGuest]=useState({});
const [roomdata,setRoomData]=useState({room:"",noOfGuest:"",amenity:"",hotelId:"", price:""});

localStorage.setItem('bookingDetails',JSON.stringify(roomdata));

const [price,setPrice]=useState({});
  const nav=useNavigate();
//    const [ratingdata, setRatingData]=useState({}); 

//   const [data, setData]=useState({ customerId:"",hotelId:"",fromDate:"",toDate:"",room:"",amenity:"",noOfGuest:"",cost:""});
  const [data,setData]=useState({hotelId:id});
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

const noGuestHandler=(e)=>{
    setNoOfGuest(e.target.value);
}



const handleChange=(event)=>{
     setData({...data,[event.target.name]:event.target.value});   // setting data to pass to payment page



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
     
        

        setRoomData({...roomdata,customerId:1,hotelId:hotelId,fromDate,toDate,room,amenity,noOfGuest:parseInt(noOfGuest), loyaltyPointsUsed:20,description:""});     //setting data for api
        
        
}

const onCheckPrice=()=>{
 

    console.log("Room Value",room)
    console.log("Amenity Value",amenity);
    room = dr+"-"+sr
    
    // setRoomData({...roomdata,noOfGuest:noOfGuest,hotelId:hotelId});
      console.log(" after check price");
      console.log(roomdata);
    //   setPrice(10000);
      
    
  axios.post('http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/rates/amount',roomdata)
  .then(response => response.data).then((data) => {
    console.log("Total cost for the room",data.object.cost);

    //get cost value from response and set it to price 
   setPrice(data.object.cost);
  
 });
    

  } 

  const NavtoPayment=()=>{
   nav('/payment',{state:data});
  }

  const ColoredLine = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
            height: 5
        }}
    />
);

   
        return (
        
           
           
            <React.Fragment>
          
                <Card>
            {/* <Card border="success" style={{backgroundImage: `url(${hotelimg})`}} > */}
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
                                <Image src={SRimg} width={200} height={150}></Image>
                                </Col> 
                            <Col>
                            <Form.Text >$$</Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" min="1" max="10" style={{width:100}} name="SR"  />
                            </Col>
                          </Row> 
                            {/* <Row>
                                <Col>
                                <Image src={SRimg} width={200} height={150}></Image>
                                </Col> 
                            </Row>           */} 
            </ListGroup.Item>
            <ColoredLine color="red" />
            <ListGroup.Item>
                            <Row>
                            <Col> Deluxe Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                                <Image src={DRimg} width={200} height={150}></Image>
                                </Col> 
                            <Col>
                            <Form.Text >$$</Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" min="1" max="10" style={{width:100}} name="DR" />
                            </Col>
                            </Row>
                            {/* <Row>
                                <Col>
                                <Image src={DRimg} width={200} height={150}></Image>
                                </Col> 
                            </Row>                  */}
            </ListGroup.Item>
            </Form.Group>
          <br></br>
            <Form.Group style={{marginLeft:'20rem'}}>   
                     <Form.Label style={{ color:'green', fontStyle:"italic"}} >Enter No of Guests</Form.Label>
                     <Form.Control type="number" placeholder="Enter guests" name="noOfGuest" style={{ width: '10rem' }} onChange={noGuestHandler} required/>
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
              
                


                <Col style={{ color:"#E75480", fontSize:"25px", fontWeight:"bolder"}} > Total Price  $
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
    

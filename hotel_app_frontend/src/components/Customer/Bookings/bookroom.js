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
    const {id}=useParams();
   
    
useEffect=()=>{
    const HotelList=JSON.parse(localStorage.getItem("HotelList"))
    for (let i=0;i<HotelList.length;i++){
        if (HotelList[i].hotel.hotelId==id){
            localStorage.setItem("selectedHotel",JSON.stringify(HotelList[i]))
        }
    }
    console.log("selected hotel obj in bookroom data", JSON.parse(localStorage.getItem("selectedHotel")));
}













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
    const amenities=(JSON.parse(localStorage.getItem("selectedHotel"))).amenities;
    const hotel=JSON.parse(localStorage.getItem("selectedHotel")); 
    console.log("hotel from local storage ",hotel); //get from local storage 
    const totalSR=hotel.availability.SR;
    const totalDR=hotel.availability.DR;
    console.log("available rooms for SR",totalSR);
    console.log("available rooms for Dr", totalDR);
    const hotelId=hotel.hotel.hotelId;
    const customerId=JSON.parse(localStorage.getItem("custId"));
    const loyaltyPoints=JSON.parse(localStorage.getItem("custLP")); 
    const fromDate=localStorage.getItem("from");
    const toDate=localStorage.getItem("to");
    const [priceOfRoom,setpriceOfRoom]=useState("");
    // const amenities=
    // [
    //     {
    //         "amenityId": 1,
    //         "amenityCode": "CB",
    //         "amenityType": "Daily Continental Breakfast",
    //         "amenityCost": 25
    //     },
    //     {
    //         "amenityId": 2,
    //         "amenityCode": "FR",
    //         "amenityType": "Access to fitness room",
    //         "amenityCost": 25
    //     },
    //     {
    //         "amenityId": 3,
    //         "amenityCode": "SJ",
    //         "amenityType": "Access to Swimming Pool/Jacuzzi",
    //         "amenityCost": 25
    //     },
    //     {
    //         "amenityId": 4,
    //         "amenityCode": "DP",
    //         "amenityType": "Daily Parking",
    //         "amenityCost": 10
    //     },
    //     {
    //         "amenityId": 5,
    //         "amenityCode": "BF",
    //         "amenityType": "Breakfast",
    //         "amenityCost": 10
    //     },
    //     {
    //         "amenityId": 6,
    //         "amenityCode": "LN",
    //         "amenityType": "Lunch",
    //         "amenityCost": 10
    //     },
    //     {
    //         "amenityId": 7,
    //         "amenityCode": "DN",
    //         "amenityType": "Dinner",
    //         "amenityCost": 10
    //     }
    // ]

//   const {id}=useParams();

//   let hotelId=parseInt(id,10);
  console.log("hotel id in int",hotelId);
  
 
const [noOfGuest,setNoOfGuest]=useState({});
const [roomdata,setRoomData]=useState({room:"",noOfGuest:"",amenity:"",hotelId:"", price:"",loyaltyPointsUsed:""});

localStorage.setItem('bookingDetails',JSON.stringify(roomdata));


var loyaltyPointsUsed;
const nav=useNavigate();
//    const [ratingdata, setRatingData]=useState({}); 

//   const [data, setData]=useState({ customerId:"",hotelId:"",fromDate:"",toDate:"",room:"",amenity:"",noOfGuest:"",cost:""});
  const [data,setData]=useState({hotelId:hotelId});


//   useEffect(()=>{
//     axios.get('http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/customer/loyalty',2)
//     .then(response => response.data)
//     .then((data) => {
//     //   setLpts(data);

//       console.log(data);
//    })
//    .catch((error)=>{
//        console.log(error);
//    })

//   })


// validate room availability
const validateSRooms=(event)=>{
    console.log(event.target.value);
    if (event.target.value > totalSR ){
       window.alert("Oops! Requested rooms not available. Please enter a lesser value");
       document.getElementById('SR').value = "";
    }
}
const validateDRooms=(event)=>{
    // console.log(event.target.value);
    if (event.target.value > totalDR ){
       window.alert("Oops! Requested rooms not available. Please enter a lesser value");
       document.getElementById('DR').value = "";
    }    
}


const noGuestHandler=(e)=>{
    setNoOfGuest(e.target.value);
}
const lptsHandler=(e)=>{
    if((e.target.value)>loyaltyPoints){
        window.alert("OOpsss !!! You have only"+loyaltyPoints+"Points");
        document.getElementById('loyaltyPointsUsed').value = "";

    }
    else{
        loyaltyPointsUsed=e.target.value;
    }
    
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
     
        

        setRoomData({...roomdata,customerId:customerId,hotelId:hotelId,fromDate,toDate,room,amenity,noOfGuest:parseInt(noOfGuest), loyaltyPointsUsed:parseInt(loyaltyPointsUsed),description:""});     //setting data for api
        
        
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
    console.log("Total cost for the room",data.object);

    //get cost value from response and set it to price 
   localStorage.setItem('price',JSON.stringify(data.object.cost));
   setpriceOfRoom(data.object.cost);
  console.log("cost =",localStorage.getItem('price'));
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
            <Card.Header style={{textAlign:'center',  color:'green', fontStyle:"italic", fontSize:"40px"}}>HOTEL {hotel.hotel.hotelname}</Card.Header>
            <Card.Body>
            Hotel Address : {hotel.hotel.hotel_address} , {hotel.hotel.hotelLocation} , {hotel.hotel.hotelZipCode}<br></br>
            Hotel Contact : {hotel.hotel.hotelContact} <br></br>

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
                            <Form.Text ><b>{hotel.costsOfRooms.SR}$ per Room</b></Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" min="0" style={{width:100}} name="SR" id="SR" onChange={validateSRooms} />
                            </Col>
                          </Row>  
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
                            <Form.Text><b>{hotel.costsOfRooms.DR}$ per Room</b></Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" min="0" style={{width:100}} name="DR" id="DR" onChange={validateDRooms} />
                            </Col>
                            </Row>
                           
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
            <ColoredLine color={"blue"}></ColoredLine>

            <Row>
                <Col> You have {loyaltyPoints} Loyalty Points  <br>
                </br>
                <Form.Label htmlFor="loyaltyPointsUsed" > Enter number of loyalty points to be used</Form.Label> 
                </Col>
                <Col>
               
                <Form.Control type="number" step="10" min="0"   style={{width:100}} name="loyaltyPointsUsed" id="loyaltyPointsUsed" onChange={lptsHandler}/>
                </Col>
            </Row>
            <Row>
                <Col> <Button variant="success"  onClick={onCheckPrice}> Check Price </Button>
                </Col>
            
                {priceOfRoom.length !==0 && <Col style={{ color:"#E75480", fontSize:"25px", fontWeight:"bolder"}} > Total Price  $ {priceOfRoom}
                </Col>}
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
    

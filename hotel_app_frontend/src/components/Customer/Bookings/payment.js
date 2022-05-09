import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {useLocation,useNavigate} from 'react-router-dom';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { setDate } from 'date-fns';
import hotelimg from './hotel.jpg';
export  default function Payment(){

    const hotel=JSON.parse(localStorage.getItem("selectedHotel"));
    const loyaltyPoints=JSON.parse(localStorage.getItem("custLP")); 
    const fromDate=localStorage.getItem("from");
    const toDate=localStorage.getItem("to");
    const custName=localStorage.getItem("custName");
    const custId=localStorage.getItem("custId");
    const nav=useNavigate();
    const location = useLocation();
    const [data,setData]=useState({});
    const [payment,setPayment]=useState({});
    const roomdata=JSON.parse(localStorage.getItem('bookingDetails'));
    console.log("roomdata",roomdata.room);
    const price=localStorage.getItem('price');
    
    const bookData={hotelId:hotel.hotel.hotelId,customerId:custId,room:roomdata.room,amenity:roomdata.amenity,bookingDateFrom:fromDate,bookingDateTo:toDate,noOfGuest:roomdata.noOfGuest,bookingStatus:"booked",amount:price,totalAmount:"",paymentMethod:payment,roomNumbers:"",loyaltyPointsUsed:roomdata.loyaltyPointsUsed};
  
    useEffect(()=>{ 
      
        setData(location.state);
     


    })
    
    const handleChange=(e)=>{
        setPayment(e.target.value);

    }

    const handleClick=()=>{
     
        console.log("data to be sent to api",bookData);

   


        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/hotel//book",bookData)
    
        .then(res=>{
            if (res.status==200){
                console.log(res.data)

                nav('/exit');
                console.log("booking successful");
            }
            else{
                nav('/error');
                console.log("booking unsuccessful");
            }
            
        });


    }

    return(

        <React.Fragment>
            <div style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Payments Page</div>
            <br>
            </br><br>
            </br>
             
            <div class="container">
  <div class="card-columns d-flex justify-content-center">
  <Card >
                <Card.Title  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>
                </Card.Title>
                <ListGroup>
                <ListGroup.Item style={{textAlign:'center', color:'green', fontStyle:"italic"}}>
                       {custName}'s  Bookings     
                    </ListGroup.Item>
                <ListGroup.Item>
                        Hotel : {hotel.hotel.hotelname} , {hotel.hotel.hotelLocation}
                    </ListGroup.Item>
                        <ListGroup.Item>
                        Total Single Rooms Booked : {data.SR}
                    </ListGroup.Item>
                    

                    
                    <ListGroup.Item>
                        Total Deluxe Rooms Booked : {data.DR}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        Total Guests : {data.noOfGuest}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        From : {fromDate}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        To : {toDate}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        Loyalty Points Used : {roomdata.loyaltyPointsUsed}
                    </ListGroup.Item>

                    <ListGroup.Item>
                        Total Cost : $ {price} 
                     
                    </ListGroup.Item>
        
            
                </ListGroup>
               

                {/* <Card.Body>
                   
                </Card.Body> */}
                </Card>
                <Card>
                <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Enter Payment details</Card.Header>
                <Card.Body>
                  
                        
                        <Form.Label htmlFor="payment" > Enter credit card Number </Form.Label> {" "}
                    <Form.Control type="text"   name="payment" onChange={handleChange} />
                    
                   

                       
                
                       
                </Card.Body>
                </Card>
               
  </div>
  <Card>
      <Row>
          <Col><b style={{color:"blue"}}><i>{custName} , Are you ready to Book ?</i></b>
          </Col>
          <Col>
          </Col>
          <Col><Button variant="outline-warning" onClick={handleClick}  style={{marginBottom:"1rem", marginTop:"1rem"}}>Book Now !</Button></Col>
    
      </Row>
       
                </Card>

</div>

          
          
        </React.Fragment>


      
    )
}
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {useLocation,useNavigate} from 'react-router-dom';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { setDate } from 'date-fns';
import hotelimg from './hotel.jpg';
export  default function Payment(){
    const nav=useNavigate();
    const location = useLocation();
    const [data,setData]=useState({});
    const [payment,setPayment]=useState({});
    
  
    useEffect(()=>{ 
      
        setData(location.state);


    })
    
    const handleChange=(e)=>{
        setPayment(e.target.value);

    }

    const handleClick=()=>{
     
        console.log("data to be sent to api",{data,payment});

    nav('/exit');


        axios.post("http://localhost:8081//hotel//book",{data,payment})
    
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
  <Card style={{backgroundImage: `url(${hotelimg})`}}>
                <Card.Title  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>
           
                    .................
                    .................
                    ................
                </Card.Title>
                <ListGroup>
                <ListGroup.Item style={{textAlign:'center', color:'green', fontStyle:"italic"}}>
                       Your Bookings     
                    </ListGroup.Item>
                <ListGroup.Item>
                        Hotel ID : {data.hotelId}
                    </ListGroup.Item>
                    
                    if({data.SR}){
                        <ListGroup.Item>
                        Total Single Rooms Booked : {data.SR}
                    </ListGroup.Item>
                    }

                    
                    <ListGroup.Item>
                        Total Deluxe Rooms Booked : {data.DR}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        Total Guests : {data.noOfGuest}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        Total Cost : 700$
                     
                    </ListGroup.Item>
        
            
                </ListGroup>
               

                <Card.Body>
                   

                </Card.Body>
                </Card>
                <Card>
                <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Enter Payment details</Card.Header>
                <Card.Body>
                <Form.Label htmlFor="payment" > Enter credit card Number </Form.Label> {" "}
                            <Form.Control type="text"   name="payment" onChange={handleChange} />
                       
                </Card.Body>
                </Card>
  </div>
</div>
<br></br>
           <Button variant="outline-warning" style={{marginLeft:"30rem"}} onClick={handleClick} >Book Now !</Button>
          
        </React.Fragment>


      
    )
}
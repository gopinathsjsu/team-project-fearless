import React,{useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card,CardGroup, Form, Row,Col, Button } from "react-bootstrap";
import { CardActionArea, filledInputClasses } from "@mui/material";
import hotelimg from '../Customer/Bookings/hotel.jpg';
import DRimg from '../Customer/Bookings/singleRoom.jpg';
export default function EmpHomePage(){
    const navigate = useNavigate();
     const onClickAddHotel=()=>{
         navigate('/addhotel');
     }
     const onClickUpdateCost=()=>{
         navigate('/updateRoomCost');
     }


    return(
        <CardGroup>
            <Card>
               <b>Welcome to Hotel Employee HomePage
                   </b> 
            </Card>
        <Card>
          <Card.Img variant="top" src={DRimg} />
          <Card.Body>
            <Card.Title>Do you want to update Room Cost ??</Card.Title>
          </Card.Body>
          <Card.Footer>
            <Button onClick={onClickUpdateCost}>UPDATE COST</Button>
          </Card.Footer>
        </Card>
        <Card>
          <Card.Img variant="top" src={hotelimg}/>
          <Card.Body>
            <Card.Title>Do You want to add Hotel ??</Card.Title>
          </Card.Body>
          <Card.Footer>
            <Button onClick={onClickAddHotel}>ADD HOTEL</Button>
          </Card.Footer>
        </Card>
        
      </CardGroup>
    )
}
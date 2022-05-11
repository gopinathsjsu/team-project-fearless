import React,{useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card,CardGroup, Form, Row,Col, Button } from "react-bootstrap";
import { CardActionArea, filledInputClasses } from "@mui/material";
import hotelimg from '../Customer/Bookings/hotel.jpg';
import DRimg from '../Customer/Bookings/singleRoom.jpg';
import Logout from "../Customer/Login/logout";
export default function EmpHomePage(){
    const navigate = useNavigate();


    const [logout, setLogout] = useState(false);
     const onClickAddHotel=()=>{
         navigate('/addhotel');
     }
     const onClickUpdateCost=()=>{
         navigate('/updateRoomCosts');
     }


    return(
      <React.Fragment>

    
        <CardGroup>
            <Card>
               <div><b>Welcome to Hotel Employee HomePage</b></div> 
                   <br>
                   </br>
                  <div><Logout setLogout={setLogout}/>
                    </div> 
                   
            </Card>
        <Card>
          <Card.Img variant="top" src={DRimg}  height="80%" />
          <Card.Body>
            <Card.Title>Do you want to update Room Cost ??</Card.Title>
          </Card.Body>
          <Card.Footer>
            <Button variant="success" onClick={onClickUpdateCost}>UPDATE COST</Button>
          </Card.Footer>
        </Card>
        <Card>
          <Card.Img variant="top" src={hotelimg}/>
          <Card.Body>
            <Card.Title>Do You want to add Hotel ??</Card.Title>
          </Card.Body>
          <Card.Footer>
            <Button variant="success" onClick={onClickAddHotel}>ADD HOTEL</Button>
          </Card.Footer>
        
         
        </Card>
   
      
      </CardGroup>
     
      </React.Fragment>
    )
}
import React, { useState } from "react";
import {Button, Card, Col} from 'react-bootstrap';
import { Link ,useNavigate} from 'react-router-dom';
import utilObj  from "../Utils/utils";
import './Styles/HotelList.css';
import Image from 'react-bootstrap/Image'
import img from '../Customer/Bookings/deluxeRoom.jpg';

function HotelList(props) {
    const navigate = useNavigate();
     

    //limeka 
   const handleSelectClick=(id)=>{
        const HotelList=JSON.parse(localStorage.getItem("hotelList"))
        for (let i=0;i<HotelList.length;i++){
        if (HotelList[i].hotel.hotelId==id){
            localStorage.setItem("selectedHotel",JSON.stringify(HotelList[i]))
        }
    }
    console.log("selected hotel obj in bookroom data", JSON.parse(localStorage.getItem("selectedHotel")));

    }
    //limeka
 

    const isUserLoggedIn = () =>{
        let customerId = utilObj.getCustomerId()
        return (customerId != null)
       // return false
      }
    let markup = [];
    if(typeof(props.hotelList) != "undefined" && props.hotelList){
        for(let i=0; i< props.hotelList.length; i++){
            let currHotel = props.hotelList[i].hotel;
                markup.push(
                <Card className="hotellist" key={i}>
                    <Col>
                        <Image src={img} width={220} height={160} alt="thumbnail"></Image>
                    </Col>
                    <Col className="description">
                        <Col className="hoteltitle">
                        <Card.Title>
                            {currHotel.hotelname}
                        </Card.Title>
                        </Col>
                        <Card.Body>
                            <Col className="hoteladd">
                            <Card.Text>
                              {currHotel.hotel_address}, {currHotel.hotelZipCode}
                            </Card.Text>
                            </Col>
                            <Col className= "selects">
                            <Card.Text>
                                {/*<Link  to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel}} ><Button style={{backgroundColor:`#044831`}} className="select-hotel">Select</Button></Link>*/}
                                {isUserLoggedIn()?<Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel}} ><Button style={{backgroundColor:`#044831`}} className="select-hotel" onClick={()=>handleSelectClick(currHotel.hotelId)}>Select</Button></Link> :<Link to="/login"><Button style={{backgroundColor:`#044831`}} className="select-hotel">Select</Button></Link>}
                            </Card.Text>
                            </Col>
                        </Card.Body>
                    {/*isUserLoggedIn()?<Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel  }} > Select</Link> :<Link to="/login">Select</Link>*/}
                    </Col>
                </Card>
            )
        }
    } else {
        markup = <div></div>
    }

    return (
        <div>{markup}</div>
    )

}

export default HotelList;


import React, { useState } from "react";
import {Button, Card} from 'react-bootstrap';
import { Link ,useNavigate} from 'react-router-dom';
import utilObj  from "../Utils/utils";
import './Styles/HotelList.css';
import img from './Styles/new.jpg'


function HotelList(props) {
    const navigate = useNavigate();
     

    //limeka 
    const handleClick=(id)=>{
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
            localStorage.setItem("currentHotel",JSON.stringify(currHotel));
            console.log(currHotel);
            markup.push(
                <Card className="hotellist" key={i}>
                        
                        <Card.Title>
                            {currHotel.hotelname}
                        </Card.Title>
                        <Card.Body>
                            <Card.Text>
                              {currHotel.hotel_address}
                            </Card.Text>
                            <Card.Text>
                                {/*<Link  to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel}} ><Button style={{backgroundColor:`#044831`}} className="select-hotel">Select</Button></Link>*/}
                                {isUserLoggedIn()?<Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel}} ><Button style={{backgroundColor:`#044831`}} className="select-hotel" onClick={handleClick(currHotel.hotelId)}>Select</Button></Link> :<Link to="/login"><Button style={{backgroundColor:`#044831`}} className="select-hotel">Select</Button></Link>}
                            </Card.Text>
                        </Card.Body>
                    {/*isUserLoggedIn()?<Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel  }} > Select</Link> :<Link to="/login">Select</Link>*/}
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
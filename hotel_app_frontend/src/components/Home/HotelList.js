import React, { useState } from "react";
import {Button, Card} from 'react-bootstrap';
import { useHistory,Link ,useNavigate} from 'react-router-dom';
import './HotelSearch.css';


function HotelList(props) {
    let markup = []
    if(typeof(props.hotelList) != "undefined" && props.hotelList){
        for(let i=0; i< props.hotelList.length; i++){
            let currHotel = props.hotelList[i].hotel;
            markup.push(
                <Card key={i}>
                    {currHotel.hotelname}
                    {currHotel.hotel_address}
                    <Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel  }} > Select</Link>
                </Card>
            )
        }
    } else {
        markup = <div></div>
    }
        
    return (
        <div>{markup}</div>
        //displays list of cards
    )

}

export default HotelList;
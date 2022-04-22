import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {Button, Card} from 'react-bootstrap';
import './HotelSearch.css';


function HotelList(props) {
    let markup = []
    if(typeof(props.hotelList) != "undefined" && props.hotelList){
        for(let i=0; i< props.hotelList.length; i++){
            let currHotel = props.hotelList[i]
            markup.push(
                <Card>
                    {currHotel.hotelname}
                    {currHotel.hotel_address}
                    <Button className = "button">Select</Button>
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
import React, { useState } from "react";
import {Button, Card} from 'react-bootstrap';
import { useHistory,Link ,useNavigate} from 'react-router-dom';
import utilObj  from "../Utils/utils";
import './Styles/HotelList.css';
import img from './Styles/new.jpg'


function HotelList(props) {

    const isUserLoggedIn = () =>{
        let customerId = utilObj.getCustomerId()
        return (customerId != null)
       // return false

      }

    let markup = []
    if(typeof(props.hotelList) != "undefined" && props.hotelList){
        for(let i=0; i< props.hotelList.length; i++){
            let currHotel = props.hotelList[i].hotel;
            markup.push(
                <Card border="success"  className="hotellist" key={i}>
                        <Card.Img variant="left" src=""/>
                        <Card.Title>
                            {currHotel.hotelname}
                        </Card.Title>
                        <Card.Body>
                            <Card.Text>
                              {currHotel.hotel_address}
                            </Card.Text>
                            <Card.Text>
                                <Link  to={{pathname :`displayhotels/hotel/${currHotel.hotelId}`, state:currHotel}} ><Button style={{backgroundColor:`#044831`}} className="select-hotel">Select</Button></Link>
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
        //displays list of cards
    )

}

export default HotelList;
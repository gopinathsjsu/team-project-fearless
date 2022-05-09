import React, { Component, useState } from "react";
import {  Container, Card } from "react-bootstrap";
import {getBookings} from './Fetchjson.js'
import {getUserFirstName,getUserLastName} from './genericUtils.js'
import UpdateBooking from './UpdateBooking';
import CancelBooking from './CancelBooking';
import utilObj from '../Utils/utils';
import axios from "axios";
import './Styles/Profile.css';

class PastBookings extends Component{
    state={
        "bookings" : ""
    }
    
    componentDidMount(){
        const id = utilObj.getCustomerId();

        axios({
            method: "get",
            url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/hotel/viewBookings/"+id,
         
          //   url: utilObj.urls.backendURL+"/hotel/viewBookings"+{id},
            headers: {
            "Content-Type": "application/json",
          }}).then(res=>{
            if (res.status==200){
                console.log(res.data);
                this.setState({
                    bookings:res.data.object
                })  
            }
            else{
                console.log("Bad response from server");
            }
            
        })
    }

    render(){
        if(this.state.bookings && this.state.bookings.length>0){
            return(
                <Container>
                    {this.displayBookings()}
                </Container>
                )
        } else {
            return (
                <div>No Bookings</div>
            )
        }
    }

    displayBookings(){
        let markup = []
        const bookings = this.state.bookings
        const currDate = new Date().toISOString().substring(0,10);
        for(let i=0; i<bookings.length; i++){
            let currBooking = bookings[i]
            console.log("current booking",currBooking);
            localStorage.setItem("currBooking",JSON.stringify(currBooking));
            let isPast = (utilObj.getDays(currBooking.bookingDateTo, currDate) > 0)
            console.log("past",isPast);
            if((isPast)&&(currBooking.bookingStatus!="Cancelled")){
                markup.push(
                    <Card border="success" key={i} className="past-upcoming" >
                        <Card.Body>
                            <Card.Text>
                            Hotel Name: {currBooking.hotelName}
                            </Card.Text>
                            <Card.Text>
                            Check In: {new Date(currBooking.bookingDateFrom).toISOString().substring(0,10)}
                            </Card.Text>
                            <Card.Text>
                            Check Out: {new Date(currBooking.bookingDateTo).toISOString().substring(0,10)}
                            </Card.Text>
                            <Card.Text>
                            Guest Count: {currBooking.noOfGuest}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                )
            }
        }
        if(markup.length==0){
            markup.push(<Card border="success" style={{width:"50%", left:"23%", margin:"20px"}}><h3 style={{textAlign:`center`}}>No Previous Bookings to show</h3></Card>)
        }
        return markup
            
        
    }
}
export default PastBookings
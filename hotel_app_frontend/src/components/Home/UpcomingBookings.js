import React, { Component, useState } from "react";
import {  Container, Card } from "react-bootstrap";
import {getBookings} from './Fetchjson.js'
import {getUserEmail,getUserFirstName,getUserLastName,getRewardPoints} from './genericUtils.js'
import UpdateBooking from './UpdateBooking'
import CancelBooking from './CancelBooking'
import utilObj from '../Utils/utils';
import axios from "axios";
import './Styles/Profile.css';

class UpcomingBookings extends Component{
    state={
        "bookings" : ""
    }

    componentDidMount(){
        const username = getUserFirstName()+" "+getUserLastName()
        const email = getUserEmail()
        const id = utilObj.getCustomerId();
        //const id = JSON.parse(localStorage.getItem("custId"));
        const rewards = getRewardPoints()
        console.log("cust id", id);

        axios({
              method: "get",
              url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/hotel/viewBookings/"+id,
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
        if(this.state.bookings){
            return(
                <Container>
                    {this.displayBookings()}
                </Container>
                )
        } else {
            return (
                <div>
                    No bookings
                </div>
            )
        }
    }

    displayBookings(){
        let markup = []
        const bookings = this.state.bookings
        const currDate = new Date().toISOString().substring(0,10);
        for(let i=0; i<bookings.length; i++){
            let currBooking = bookings[i];
            console.log("curr booking",currBooking);
            localStorage.setItem("currBooking",JSON.stringify(currBooking));
            let isUpcoming = (utilObj.getDays(currDate, currBooking.bookingDateFrom) > 0)
            console.log("upcoming",isUpcoming);
            if(isUpcoming&&(currBooking.bookingStatus!="Cancelled")){
                markup.push(
                    <Card border="success" key={i} className="past-upcoming">
                        <Card.Body>
                        <Card.Text>
                        Hotel Name: {currBooking.hotelName}
                        </Card.Text>
                        <Card.Text>  
                        CheckIn: {new Date(currBooking.bookingDateFrom).toISOString().substring(0,10)}
                        </Card.Text> 
                        <Card.Text> 
                        Check Out: {new Date(currBooking.bookingDateTo).toISOString().substring(0,10)}
                        </Card.Text>  
                        <Card.Text>
                        Guest Count: {currBooking.noOfGuest}
                        </Card.Text>
                        <div className="update-cancel">                  
                        <UpdateBooking currBooking={currBooking}/>
                        </div>
                        <br/>
                        <div className="update-cancel">
                       <CancelBooking currBooking={currBooking}/>
                       </div>
                       </Card.Body>  
                    </Card>
                )
            }else {
                 <div><h3 style={{color:`aliceblue`}}>No Upcoming Bookings to show</h3></div>
            }
        }
        return markup   
    }
}
export default UpcomingBookings
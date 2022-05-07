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
        // const id = utilObj.getCustomerId;
        const username = getUserFirstName()+" "+getUserLastName()
        const email = getUserEmail()
        // const id = utilObj.getCustomerId;
        const user=JSON.parse(localStorage.getItem("custId"));
        const id = user.customerId

        const rewards = getRewardPoints()
        //TODO: Comment it later
        // const bookings = getBookings(username, email, rewards)
        // this.setState({
        //     bookings: bookings
        // })
        console.log("cust id", id);

        //TODO: uncomment below after backend api implementation
        //TODO: Send username or userid to backend API, and get upcoming books of current user
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
            if(isUpcoming&&currBooking.bookingStatus!="Cancelled"){
                markup.push(
                    <Card border="success" key={i} className="past-upcoming">
                        <Card.Body>
                        <Card.Text>
                        Hotel Name: {currBooking.hotelName}
                        </Card.Text>
                        <Card.Text>  
                        CheckIn: {new Date(currBooking.bookingDateFrom).toDateString()}
                        </Card.Text> 
                        <Card.Text> 
                        Check Out: {new Date(currBooking.bookingDateTo).toDateString()}
                        </Card.Text>  
                        <Card.Text>
                        Guest Count: {currBooking.noOfGuest}
                        </Card.Text>
                        <div className="update-cancel">                  
                        <UpdateBooking currBooking={currBooking}/>
                        </div>
                        <br/>
                        <div className="update-cancel">
                       <CancelBooking bookingId= {currBooking.bookingId} checkIn={currBooking.bookingDateFrom}/>
                       </div>
                       </Card.Body>  
                    </Card>
                    
                )
            }
        }
        return markup
        
    }
}
export default UpcomingBookings
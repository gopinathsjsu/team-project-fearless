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
        const user=JSON.parse(localStorage.getItem("custId"));
        const id = user.customerId
        const username = getUserFirstName()+" "+getUserLastName()
        //TODO: Comment it later
   
        // const bookings = getBookings(username)
        // this.setState({
        //     bookings
        // })

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

        //TODO: uncomment below after backend api implementation
        //TODO: Send username or userid to backend API, and get upcoming books of current user
        /*await axios({
            method:'get',
            //TODO: update backend URL
            url:"/upcomingBookings",
            data:{user},
            config: {headers: { 'Content-Type': 'multipart/form-data'}} 
          }).then((response)=>{
            if(response.status >= 500){
              throw new Error("Bad response from server")
            }
            return response.data;
          }).then((responseData)=>{
            this.setState({
                bookings: responseData
            })
          })*/
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
                <div styles={{backgroundColor:`white`}}>
                   <h1> No previous bookings to show</h1>
                </div>
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
                            Check In: {new Date(currBooking.bookingDateFrom).toDateString()}
                            </Card.Text>
                            <Card.Text>
                            Check Out: {new Date(currBooking.bookingDateTo).toDateString()}
                            </Card.Text>
                            <Card.Text>
                            Guest Count: {currBooking.noOfGuest}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                )
            }
            else{
                <div><h3 style={{color:`aliceblue`}}>No Previous Bookings to show</h3></div>
            }
        }
        return markup
        
    }
}
export default PastBookings
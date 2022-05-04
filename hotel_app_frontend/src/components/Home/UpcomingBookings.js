import React, { Component, useState } from "react";
import {  Container, Card } from "react-bootstrap";
import {getBookings} from './Fetchjson.js'
import {getUserEmail,getUserFirstName,getUserLastName,getRewardPoints} from './genericUtils.js'
import UpdateBooking from './UpdateBooking'
import CancelBooking from './CancelBooking'
import utilObj from '../Utils/utils'

class UpcomingBookings extends Component{
    state={
        "bookings" : ""
    }

    componentDidMount(){
        const username = getUserFirstName()+" "+getUserLastName()
        const email = getUserEmail()
        const rewards = getRewardPoints()
        //TODO: Comment it later
        const bookings = getBookings(username, email, rewards)
        this.setState({
            bookings: bookings
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
            let currBooking = bookings[i]
            let isUpcoming = (utilObj.getDays(currDate, currBooking.bookingDateFrom) > 0)
            if(isUpcoming){
                markup.push(
                    <Card key={i}>
                        HotelID: {currBooking.hotelId}
                        <br/>
                        CheckIn: {new Date(currBooking.bookingDateFrom).toDateString()}
                        <br/>
                        Checkout: {new Date(currBooking.bookingDateTo).toDateString()}
                        <br/>
                        No. of Guests: {currBooking.noOfGuest}
                        <br/>                        
                        <UpdateBooking currBooking={currBooking}/>
                        <br/>
                       <CancelBooking bookingId= {currBooking.bookingId} checkIn={currBooking.bookingDateFrom}/>
                    </Card>
                )
            }
        }
        return markup
        
    }
}
export default UpcomingBookings
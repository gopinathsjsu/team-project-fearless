import React, { Component, useState } from "react";
import {  Container, Card } from "react-bootstrap";
import {getUpcomingBookings} from './Fetchjson.js'
import {getUserName} from './genericUtils.js'
import UpdateBooking from './UpdateBooking'
import CancelBooking from './CancelBooking'

class UpcomingBookings extends Component{
    state={
        "bookings" : ""
    }

    componentDidMount(){
        const username = getUserName()
        //TODO: Comment it later
        const bookings = getUpcomingBookings(username)
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
        for(let i=0; i<bookings.length; i++){
            let currBooking = bookings[i]
            markup.push(
                <Card key={i}>
                    {currBooking.hotelName}
                    <br/>
                    {currBooking.checkIn}
                    <br/>
                    {currBooking.checkOut}
                    <br/>
                    {currBooking.noOfGuests}
                    <br/>
                    {currBooking.noOfRooms}
                    <br/>
                    <UpdateBooking currBooking={currBooking}/>
                    <br/>
                   <CancelBooking/>
                </Card>
            )
        }
        return markup
        
    }
}
export default UpcomingBookings
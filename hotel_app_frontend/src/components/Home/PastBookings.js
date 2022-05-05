import React, { Component, useState } from "react";
import {  Container, Card } from "react-bootstrap";
import {getBookings} from './Fetchjson.js'
import {getUserFirstName,getUserLastName} from './genericUtils.js'
import UpdateBooking from './UpdateBooking'
import CancelBooking from './CancelBooking'
import utilObj from '../Utils/utils'

class PastBookings extends Component{
    state={
        "bookings" : ""
    }

    componentDidMount(){
        const username = getUserFirstName()+" "+getUserLastName()
        //TODO: Comment it later
        const bookings = getBookings(username)
        this.setState({
            bookings
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
            let isPast = (utilObj.getDays(currBooking.bookingDateTo, currDate) > 0)
            if(isPast){
                markup.push(
                    <Card key={i}>
                        {currBooking.hotelId}
                        <br/>
                        {currBooking.bookingDateFrom}
                        <br/>
                        {currBooking.bookingDateTo}
                        <br/>
                        {currBooking.noOfGuest}
                        <br/>
                        
                        
                        
                    </Card>
                )
            }
        }
        return markup
        
    }
}
export default PastBookings
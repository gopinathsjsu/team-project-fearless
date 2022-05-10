import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Container, Form, Card, ListGroup } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import utilObj from '../Utils/utils';
import swal from "sweetalert";

function UpdateBooking(props) {
    const navigate = useNavigate();
    const currBooking = props.currBooking
    const [show, setShow] = useState(false);
    const [noOfGuest, setNoOfGuest] = useState(parseInt(currBooking.noOfGuest));
    const [room, setRoom] = useState(currBooking.room)
   
    let SRCount=0, DRCount = 0;
    let updatedAmenities=[];
    const [bookedAmenities, setBookedAmenities] = useState(currBooking.amenity)

   
    
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    

    const handleChange=(event)=>{
      console.log(" on change :");
    }
  
    const handleSubmit=()=>{
        console.log(" after handle submit");
    }

    const handleUpdate = () => {
      let bookingId = currBooking.bookingId;
      let hotelId = currBooking.hotelId;
      let customerId = currBooking.customerId;
      let room = getUpdatedRoom();
      let amenity = getUpdatedAmenities();
      let bookingDateFrom = new Date(currBooking.bookingDateFrom).toISOString().substring(0,10);
      let bookingDateTo = new Date(currBooking.bookingDateTo).toISOString().substring(0,10);
      let bookingStatus = "booked";
      let amount = "";
      let totalAmount = "";
      let paymentMethod = currBooking.paymentMethod;
      let roomNumbers = "";
      let loyaltyPointsUsed = currBooking.loyaltyPointsUsed;

      const data = {bookingId,hotelId,customerId,room,amenity,bookingDateFrom,bookingDateTo,noOfGuest:noOfGuest,bookingStatus, amount, totalAmount, paymentMethod, roomNumbers, loyaltyPointsUsed }
          axios({
              method: "post",
              url: "http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/hotel/book",
             data}).then(res=>{
              if (res.status==200){
                 swal(res.data.message);
                 navigate('../upcomingBookings')
                  console.log(res.data);
              }
              else{
                  console.log("Bad response from server");
              }
              
          });
    }

    
    const noGuestHandler=(e)=>{
      setNoOfGuest(parseInt(e.target.value));
   }
    
    const getUpdatedRoom = () =>{
      let roomStr = ""
      if(SRCount > 0){
        roomStr += "SR"+SRCount
      }
      if(DRCount > 0){
        if(SRCount > 0) roomStr += "-"
        roomStr += "DR"+DRCount
      }
      return roomStr
    }

    const getUpdatedAmenities = () =>{
      let amenityStr=""
      for( let i=0; i< updatedAmenities.length; i++){
        let curr = updatedAmenities[i];
        amenityStr += curr+"-";
      }
      return amenityStr.substring(0, amenityStr.length-1)
    }

    const changeAmenity = (e) => {
      let currAmenity = e.target.name;
      if(e.target.checked)
        updatedAmenities.push(currAmenity)
      else
        updatedAmenities.pop(currAmenity)
    }


    

    const setRooms = (rooms) => {
      let roomsArr = rooms.split("-");
      
      for(let i=0; i<roomsArr.length; i++){
        let room = roomsArr[i];
        let isSingleRoom = (room.indexOf("SR") > -1)
        let isDoubleRoom = (room.indexOf("DR") > -1)
        if(isSingleRoom){
          SRCount = parseInt(room.replace("SR", ""))
        }
        if(isDoubleRoom){
          DRCount = parseInt(room.replace("DR", ""))
        }
      }
    }
    
   // const amenities=(JSON.parse(localStorage.getItem("selectedHotel"))).amenities;

    const amenities=
    [
        {
            "amenityId": 1,
            "amenityCode": "CB",
            "amenityType": "Daily Continental Breakfast",
            "amenityCost": 25
        },
        {
            "amenityId": 2,
            "amenityCode": "FR",
            "amenityType": "Access to fitness room",
            "amenityCost": 25
        },
        {
            "amenityId": 3,
            "amenityCode": "SJ",
            "amenityType": "Access to Swimming Pool/Jacuzzi",
            "amenityCost": 25
        },
        {
            "amenityId": 4,
            "amenityCode": "DP",
            "amenityType": "Daily Parking",
            "amenityCost": 10
        },
        {
            "amenityId": 5,
            "amenityCode": "BF",
            "amenityType": "Breakfast",
            "amenityCost": 10
        },
        {
            "amenityId": 6,
            "amenityCode": "LN",
            "amenityType": "Lunch",
            "amenityCost": 10
        },
        {
            "amenityId": 7,
            "amenityCode": "DN",
            "amenityType": "Dinner",
            "amenityCost": 10
        }
    ]
    setRooms(currBooking.room)
    return (
      <>
        <Button variant="success" onClick={handleShow} >
          Update
        </Button>
  
        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title style={{color:'green', fontSize:"25px"}}>Current Booking</Modal.Title>
          </Modal.Header>
          <Modal.Body>
          <React.Fragment>
  <Card border="success">
      <Card.Header style={{textAlign:'center', color:'green', fontStyle:"italic", fontSize:"40px"}}>HOTEL {currBooking.hotelName}</Card.Header>
      <Card.Body>
          Check In : {new Date(currBooking.bookingDateFrom).toISOString().substring(0,10)}
          <br/>
          Check Out: {new Date(currBooking.bookingDateTo).toISOString().substring(0,10)}
      </Card.Body>
  </Card>

<Card border="success">
    <Card.Body>
        <form onSubmit={handleSubmit} onChange={handleChange}>
            <Form.Group>
            <Form.Label style={{ color:'green', fontStyle:"italic"}}>Select from Available Rooms</Form.Label>
            <ListGroup.Item>
                            <Row>
                            <Col> Single Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="SR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" style={{width:100}} name="SR" defaultValue={SRCount} />
                            </Col>
                            </Row>             
            </ListGroup.Item>
            <ListGroup.Item>
                            <Row>
                            <Col> Deluxe Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="DR" > Enter number of rooms </Form.Label> {" "}
                            <Form.Control type="number" style={{width:100}} name="DR" defaultValue={DRCount} />
                            </Col>
                            </Row>             
            </ListGroup.Item>
            </Form.Group>
          <br></br>
            <Form.Group>
                <Row>
                    <Col> <Form.Label style={{ color:'green', fontStyle:"italic"}} >Enter No of Guests</Form.Label>
                    </Col>
                    <Col>  <Form.Control type="number" placeholder="Enter guests" name="noOfguests" defaultValue={noOfGuest} onChange={(e)=>noGuestHandler(e)} />
                    </Col>
                </Row>
            </Form.Group>
        <br></br>

            <Form.Group>
            <Form.Label style={{ color:'green', fontStyle:"italic"}}>Add amenities</Form.Label>

            {amenities.map((amenity) => {
              let isBooked = (bookedAmenities.indexOf(amenity.amenityCode) > -1)
              if(isBooked)
                updatedAmenities.push(amenity.amenityCode)
              return (
    <div key={amenity.amenityId} className="mb-3">
      <Form.Check type="checkbox" >
        <Form.Check.Input type="checkbox"  name={amenity.amenityCode}  isValid  defaultChecked={isBooked} onChange={(e)=>changeAmenity(e)}/>
        
        <Form.Check.Label>{amenity.amenityType}</Form.Check.Label>
        
      </Form.Check>
    </div>
  )})}
            {/* <ListGroup.Item>
                        {amenities?.map(amenity=>{
                    return(
                        <ListGroup.Item key={amenity.amenityId} >
                            <Row >
                            <Col>{amenity.amenityType} 
                            </Col>
                            <Col>
                            {amenity.amenityCost}$
                            </Col>
                            <Col> 
                            <input type="checkbox" name={amenity.amenityType}   />
                         
                            </Col>
                            </Row>
                            
                            </ListGroup.Item>                     
                        );
                })}
                        </ListGroup.Item> */}
            </Form.Group>
           {/*} <br></br>
            <Button variant="success" type="submit" style={{marginLeft:350}}>Checkout</Button>*/}
          </form>
        
      
          </Card.Body>
      </Card>
            </React.Fragment>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button variant="success" onClick={handleUpdate}>
              Update
            </Button>
          </Modal.Footer>
        </Modal>
      </>
    );
  }
  
  export default UpdateBooking
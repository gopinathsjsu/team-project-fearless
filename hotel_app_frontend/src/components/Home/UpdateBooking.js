import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Container, Form, Card, ListGroup } from "react-bootstrap";
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import TextField from '@mui/material/TextField';
import swal from "sweetalert";

function UpdateBooking(props) {
    const currBooking = props.currBooking
    const [show, setShow] = useState(false);
    const [noOfGuest, setNoOfGuest] = useState(parseInt(currBooking.noOfGuest));
    const [room, setRoom] = useState(currBooking.room)
   // const [SRCount, setSRCount] = useState()
    //const [DRCount, setDRCount] = useState()
    let SRCount=0, DRCount = 0;
    let updatedAmenities=[];
    const [bookedAmenities, setBookedAmenities] = useState(currBooking.amenity)
    
    //const [checkIn, setCheckIn] = useState(currBooking.checkIn);
    //const [checkOut, setCheckOut] = useState(currBooking.checkOut);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    
   /* const incrementGuests = () => {
        setNoOfGuests(noOfGuests+1)
    }
    const decrementGuests = () => {
        setNoOfGuests(noOfGuests-1)
    }*/

    const handleChange=(event)=>{
     // setRoomData({...roomdata,[event.target.name]:event.target.value});
      console.log(" on change :");
      // console.log(roomdata);
    }
  
    const handleSubmit=()=>{
        console.log(" after handle submit");
     //   console.log(roomdata);
    }

    const handleUpdate = () => {
      let roomStr = getUpdatedRoom()
      let amenityStr = getUpdatedAmenities()

        swal("booking updated")
        //TODO:axios request, use the strings, roomStr and amenityStr
       // console.log("noOfGuests: ",noOfGuests,"  ", "checkIn: ", checkIn, "  ", "checkOut:", checkOut)
        //TODO: add axios post request to update booking and send required input parameters
        // If successful, show an alert message as booking is updated
    }

    //Call below apis before axios request
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

    const setRooms = (roomsStr) => {
      let roomsArr = roomsStr.split("-");
      
      for(let i=0; i<roomsArr.length; i++){
        let room = roomsArr[i];
        let isSingleRoom = (room.indexOf("SR") > -1)
        let isDoubleRoom = (room.indexOf("DR") > -1)
        if(isSingleRoom){
          SRCount = parseInt(room.replace("SR", ""))
         // setSRCount(srcount)
        }
        if(isDoubleRoom){
          DRCount = parseInt(room.replace("DR", ""))
          //setDRCount(drcount)
        }
      }
    }

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
        <Button variant="primary" onClick={handleShow}>
          Update
        </Button>
  
        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Current Booking</Modal.Title>
          </Modal.Header>
          <Modal.Body>
          <React.Fragment>
<Card border="success">
    <Card.Header style={{textAlign:'center', color:'green', fontStyle:"italic", fontSize:"40px"}}>HOTEL {currBooking.hotelId}</Card.Header>
    <Card.Body>
        Hotel Name : {currBooking.hotelName}<br/>
        Hotel address: {currBooking.hotelAddress}

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
                    <Col>  <Form.Control type="number" placeholder="Enter guests" name="noOfguests" defaultValue={noOfGuest} onChange={setNoOfGuest} />
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
            <br></br>
            <Button variant="success" type="submit" style={{marginLeft:350}}>Checkout</Button>
          </form>
        
      
    </Card.Body>
</Card>
            </React.Fragment>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button variant="primary" onClick={handleUpdate}>
              Update
            </Button>
          </Modal.Footer>
        </Modal>
      </>
    );
  }
  
  export default UpdateBooking
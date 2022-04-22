import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Container } from "react-bootstrap";
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import TextField from '@mui/material/TextField';
import swal from "sweetalert";

function UpdateBooking(props) {
    const currBooking = props.currBooking
    const [show, setShow] = useState(false);
    const [noOfGuests, setNoOfGuests] = useState(parseInt(currBooking.noOfGuests));
    const [checkIn, setCheckIn] = useState(currBooking.checkIn);
    const [checkOut, setCheckOut] = useState(currBooking.checkOut);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    
    const incrementGuests = () => {
        setNoOfGuests(noOfGuests+1)
    }
    const decrementGuests = () => {
        setNoOfGuests(noOfGuests-1)
    }

    const handleUpdate = () => {
        swal("booking updated")
        console.log("noOfGuests: ",noOfGuests,"  ", "checkIn: ", checkIn, "  ", "checkOut:", checkOut)
        //TODO: add axios post request to update booking and send required input parameters
        // If successful, show an alert message as booking is updated
    }

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
              <Container>
                <Row>
                    Guests:
                    <Button onClick={()=> incrementGuests()}>+</Button>
                    {noOfGuests}
                    <Button onClick={()=> decrementGuests()}>-</Button>
                </Row>
                <Row>
                <div className="date_picker">
                    <LocalizationProvider dateAdapter={AdapterDateFns}>
                    <DatePicker
                        allowSameDateSelection={true}                
                        label="CheckIn"
                        inputFormat="MM/dd/yyyy"
                        value={checkIn}
                        onChange={(d) => setCheckIn(d)}
                        renderInput={(params) => <TextField fullWidth={true} {...params} />}
                    />
                    </LocalizationProvider>
                </div>
          
                </Row>
                <Row>
                <div className="date_picker">
                    <LocalizationProvider dateAdapter={AdapterDateFns}>
                        <DatePicker
                        allowSameDateSelection={true}
                        label="CheckOut"
                        inputFormat="MM/dd/yyyy"
                        value={checkOut}
                        onChange={(d) => setCheckOut(d)}
                        renderInput={(params) => <TextField fullWidth={true} {...params} />}
                        />
                    </LocalizationProvider>
                </div>
            </Row>
             </Container>
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
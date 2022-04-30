


// import axios from "axios";
// import React,{useState} from "react";
// import { Button } from "react-bootstrap";
// import { useHistory } from "react-router-dom";


// export default function BookRoom(){
//     const [booking, setbooking]=useState({
//         roomtype:"",
//         TotalGuests:""
//         })
//     // const history=useHistory()
    
//     const handleSubmit=(event)=>{
//         event.preventDefault();
       
//         // axios.post("/bookhotel",{booking}).then(
//         //     res=>{
//         //         if (res.status==200){
//         //         console.log("booked room successfully")
//         //     }else{
//         //         console.log("booking error")
//         //     }}
//         // );
//         setbooking({roomtype:"",
//         TotalGuests:""
//          });
//     }
//     const handleChange=(event)=>{
//         console.log(event.target.value);
       
//         setbooking({...booking,[event.target.name]:event.target.value});
//         // console.log(setbooking);
//     }

   
//     return (
//         <div>
//             <p>
//                 Hotel 1
//             </p>
//             <br></br>
//             <form onSubmit={handleSubmit} onChange={handleChange} >
//             <label for="roomtype" name="roomtype" value={booking.roomtype}>Choose Room Type </label>

// <select name="roomtype" id="roomtype">
//   <option value="single">Single</option>
//   <option value="double">Double</option>
//   <option value="Deluxe">Deluxe</option>
//   <option value="Suite">Suite</option>
// </select>
// <br></br>
//  <label for="totalguests" name="TotalGuests"  >Select Number of guests </label>
//  <input type="number" name="TotalGuests" value={booking.TotalGuests}></input>
//  <br>
//  </br>
//  <Button type="submit">Book now</Button>  
//             </form>
            
//         </div>
//     )

// }



import React,{useState,useEffect} from "react";
import {useLocation} from 'react-router-dom';
import { Card, Form, Row,Col, Button,ListGroup } from "react-bootstrap";




export default function BookingsPage(){
    const [hotel, setHotel] = useState([]);
    const [rooms, setRooms]= useState([]);
    const [amenities, setAmenities]=useState([]);
    
    const [bookingData, setBookingData]=useState( {
        hotelId:"", SR:" ", DR:" "} );
    const { state } = useLocation();

    

    const validateSRooms=(event)=>{
        console.log(event.target.value);
        if (event.target.value > rooms.SR ){
           window.alert("No available single rooms");
        } 
        else{
            setBookingData({...bookingData,[event.target.name]:event.target.value})
        }   
    }
    const validateDRooms=(event)=>{
        // console.log(event.target.value);
        if (event.target.value > rooms.DR ){
           window.alert("No available deluxe rooms");
        }  
        else{
            setBookingData({...bookingData,[event.target.name]:event.target.value})
            console.log(bookingData.DR);
        }
    }

    useEffect(() => {

        console.log(state?.amenities);
        setHotel(state?.hotel);
       
        setRooms(state?.availability);
        setAmenities(state?.amenities);
        // fetch("https://jsonplaceholder.typicode.com/users/" + id)
        //     .then(res => res.json())
        //     .then(
        //         (data) => {
        //             console.log(data);
        //             setUser(data);
        //             setIsLoaded(true);
        //             
        //         },
        //         (error) => {
        //             setIsLoaded(true);
        //             setError(error);
        //         }
        //     )
    }, [])
    // if (error) {
    //     return <div>Error: {error.message}</div>;
    // }
    // if (!isLoaded) {
    //     return <div>Loading...</div>;
    // }  
    

        return (
           

                
  <Card border="success" >
  <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic", fontSize:"40px"}}>{hotel?.hotelname} , {hotel?.hotelLocation} 
           </Card.Header>
    <Card.Body>
      <Card.Title style={{ color:'green', fontStyle:"italic"}}>Hotel Details</Card.Title>
      <Card.Text>
            <ul>
               <li >
                Hotel Address : {hotel?.hotel_address}  
                </li>
                <li>
                Manager : {hotel?.hotelManagerName}  
                </li>
                <li>
                Contact Details : {hotel?.hotelContact}
                </li>
            </ul>
      </Card.Text>
    </Card.Body>
  <br />
        <Card.Body>  
        <ListGroup >
        <Card.Title style={{ color:'green', fontStyle:"italic"}}>Available Rooms</Card.Title>    
                        <ListGroup.Item>
                            <Row >
                            <Col> Single Room
                            </Col>
                            <Col>
                            <label htmlFor="SR" > Book Single Rooms </label> {" "}
                            
                            <input name="SR"  type="number" min={0} max={rooms?.SR} onChange={validateSRooms}/>
                            </Col>
                            </Row>
                        </ListGroup.Item>   
                        <ListGroup.Item>
                            <Row >
                            <Col> Deluxe Room
                            </Col>
                            <Col>
                            <label htmlFor="DR" > Book Deluxe Rooms </label> {" "}
                            <input name="DR" type="number" min={0} max={rooms?.DR} onChange={validateDRooms}/>
                            </Col>
                            </Row> 
                        </ListGroup.Item>     
        </ListGroup>
        </Card.Body>
<br></br>
        <Card.Body>  
        <ListGroup >
        <Card.Title style={{ color:'green', fontStyle:"italic"}}>Add Amenities</Card.Title> 
            
                        <ListGroup.Item>
                        {amenities?.map(amenity=>{
                    return(
                        <ListGroup.Item key={amenity.amenityId} >
                            <Row >
                            <Col>{amenity.amenityType} 
                            </Col>
                            <Col>
                            {amenity.amenityCost}$
                            </Col>
                            <Col> <input type="checkbox" name={amenity.amenityType}  />
                            </Col>
                            </Row>
                            
                            </ListGroup.Item>                     
                        );
                })}
                        </ListGroup.Item>                  
        </ListGroup>
        </Card.Body>
</Card>
       
        );
    

  
    // return(
    //     <div> you are redirected to Hotel {id} page
    //         <h1>
    //             Hotel details
    //         </h1>
    //         name : {name}

    //     </div>
    // )
}
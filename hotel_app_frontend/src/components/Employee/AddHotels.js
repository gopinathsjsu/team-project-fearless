import React,{useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card, Form, Row,Col, Button } from "react-bootstrap";



import axios from "axios";
import { fontWeight } from "@mui/system";

export default function AddHotels(){
    const [hotelData, setHotelData]=useState({});
   const [dr,setDr]=useState();
   const [sr,setSr]=useState();
  
    const nav=useNavigate();

    const handleChange=(event)=>{
        if(event.target.name=="DRCount"){
            setHotelData({...hotelData,DRCount:parseInt(event.target.value)})
        }
        else if (event.target.name=="SRCount"){
            setHotelData({...hotelData,SRCount:parseInt(event.target.value)})
        }
        else{
            setHotelData({...hotelData,[event.target.name]:event.target.value});
        }


        // console.log(event.target.value);
        
    }
    const handleSubmit=(event)=>{
        event.preventDefault();
        console.log("Hotel data is ", hotelData);
 

        axios.post("http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/employee/addhotel",hotelData)
    
        .then(res=>{
            if (res.status==200){
                console.log("res data of add hotel api ",res.data);
                alert(res.data.result);
                nav('/employee/homepage');

       
                console.log("hotel adding successful");
            }
            else{
                console.log("hotel adding unsuccessful");
            }
            
        });
     
       
        // setHotelData({hotelName: "",
        // hotelLocation: "",
        // hotelAddress: "",
        // hotelZipcode: "",
        // hotelContact: "",
        // hotelManagername: "",
        // DRCount:"",
        // SRCount:""})
        

       
    }

return(
  <React.Fragment>

      <Card style={{ width: '35rem', marginLeft:'25rem', marginTop:'2rem' }}>
          <Card.Header  style={{textAlign:'center', color:'red', fontStyle:"italic"}}>Add Hotel</Card.Header>
          <Card.Body>
          <form onSubmit={handleSubmit} onChange={handleChange} style={{fontWeight:"800", color:"blueviolet"}}>
              <Form.Group>
              <Form.Floating className="mb-3">
                 <Form.Control type="text" id="hotelName" name="hotelName" required />
                 <label htmlFor="hotelName" style={{marginLeft:10}} > Hotel Name</label>
                 </Form.Floating>
                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  name="hotelLocation" required/>
                 <label htmlFor="hotelLocation" style={{marginLeft:10}} > Hotel Location</label>
                 </Form.Floating>
                 
                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  name="hotelAddress" required/>
                 <label htmlFor="hotelAddress" style={{marginLeft:10}} > Hotel Address</label>
                 </Form.Floating>

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  name="hotelZipcode" required />
                 <label htmlFor="hotelZipcode" style={{marginLeft:10}}> Hotel ZipCode</label>
                 </Form.Floating>

                 

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  name="hotelContact" required/>
                 <label htmlFor="hotelContact" style={{marginLeft:10}} > Contact Number</label>
                 </Form.Floating> 

                 <Form.Floating className="mb-3">
                 <Form.Control type="text"  name="hotelManagername" required/>
                 <label htmlFor="hotelManagername" style={{marginLeft:10}} > Manager Name</label>
                 </Form.Floating> 

                 <Form.Floating className="mb-3">
                 <Form.Control type="email"  name="hotelEmail" required/>
                 <label htmlFor="hotelEmail" style={{marginLeft:10}} > Hotel Email</label>
                 </Form.Floating> 


                 <Form.Floating className="mb-3">
                 <Form.Control type="number"  min="0" name="DRCount"   required/>
                 <label htmlFor="DRCount" style={{marginLeft:10}} > Deluxe Rooms Count</label>
                 </Form.Floating> 

                 <Form.Floating className="mb-3">
                 <Form.Control type="number" min="0" name="SRCount"  required/>
                 <label htmlFor="SRCount" style={{marginLeft:10}} > Single Rooms Count</label>
                 </Form.Floating> 
                 
                 
              </Form.Group>
              <Row>
                  <Col>
                  
                  <Button type="submit"   variant="outline-danger">Add Hotel</Button>
                  </Col>
              </Row>



              </form>
          </Card.Body>
{/* 
          //onChange={e => setSr(parseInt(e.target.value))}  */}
      </Card>
  </React.Fragment>

    
)

}
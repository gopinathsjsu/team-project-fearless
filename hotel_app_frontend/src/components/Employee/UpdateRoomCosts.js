import React,{Component, useState} from "react";
import { Link, useNavigate} from "react-router-dom";
import { Card,  Form, ListGroup, Row, Col, Button } from "react-bootstrap";
import axios from "axios";
import Image from 'react-bootstrap/Image'
import SRimg from '../Customer/Bookings/singleRoom.jpg';
import DRimg from '../Customer/Bookings/deluxeRoom.jpg';
import './Employee.css'

class UpdateRoomCosts extends Component{
    state={
        "roomDetails" : "",
        "singleRoomCost":0,
        "deluxeRoomCost":0
    }

    componentDidMount(){
        axios({
            method: "get",
            url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/employee/viewRoomDetails/",
            headers: {
            "Content-Type": "application/json",
          }}).then(res=>{
                  if (res.status==200){
                      console.log(res.data);
                      let singleRoomCost, deluxeRoomCost;
                      let roomDetails = res.data;
                    for(let i=0 ;i<roomDetails .length; i++){
                        let room = roomDetails[i]
                        if(room.roomCode == 'SR'){
                            singleRoomCost = room.roomCost;
                        } else if(room.roomCode == 'DR'){
                            deluxeRoomCost = room.roomCost;
                        }
                    }
                      this.setState({
                          roomDetails:res.data,
                          singleRoomCost: singleRoomCost,
                          deluxeRoomCost: deluxeRoomCost
                      })  
                  }
            else{
                console.log("Bad response from server");
            }
            
        })


    }

    updateSRCost(e){
        let newSRCost = e.target.value;
        this.setState({
            singleRoomCost: newSRCost
        })
    }

    updateDRCost(e){
        let newDRCost = e.target.value;
        this.setState({
            deluxeRoomCost: newDRCost
        })
    }


    async handleUpdate(e) {
        e.preventDefault();
        const data = {  "roomDR":"DR",
                        "roomSR":"SR",
                        "roomCostDR":parseInt(this.state.deluxeRoomCost),
                        "roomCostSR":parseInt(this.state.singleRoomCost) };
        axios({
            method: "post",
            url: "http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/employee/updateRCost",
            headers: {
                "Content-Type": "application/json",
            },
            data
        }).then(res => {
            if (res.status == 200 && res.data) {
                alert(res.data.result);
                console.log(res.data);
            }
            else {
                console.log("Bad response from server");
            }

        });
    }

    render(){
        if(this.state.roomDetails){
            
            return(
                <div>
            <Card className = "roomCosts">
            <Form.Group>
            
            <ListGroup.Item>
                            <Row>
                            <Col> SuiteRoom  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                                <Image src={SRimg} width={200} height={150}></Image>
                            </Col> 
                            <Col>
                            <Form.Label htmlFor="SR" >Suite Room Cost </Form.Label> {" "}
                            <Form.Control type="number" min="0" style={{width:100}} name="SR" id="SR" defaultValue={this.state.singleRoomCost} onChange={(e)=>this.updateSRCost(e)} />
                            </Col>
                          </Row>  
            </ListGroup.Item>
            <hr/>
            <ListGroup.Item>
                            <Row>
                            <Col> Deluxe Room  {" "}
                            <Form.Text className="text-muted">Sea-Facing, TV set, Bathroom </Form.Text>
                            </Col>
                            <Col>
                                <Image src={DRimg} width={200} height={150}></Image>
                            </Col>
                            <Col>
                            <Form.Label htmlFor="DR" > Delux Room Cost </Form.Label> {" "}
                            <Form.Control type="number" min="0" style={{width:100}} name="DR" id="DR" defaultValue={this.state.deluxeRoomCost} onChange={(e)=>this.updateDRCost(e)}/>
                            </Col>
                            </Row>
                           
            </ListGroup.Item>
            </Form.Group>
            <Card.Body> <Button variant="success" onClick={(e)=>this.handleUpdate(e)}>Update</Button></Card.Body>
            </Card>
            </div>
            )
        } else {
            return(<div></div>)
            
        }
       
    }

}

export default UpdateRoomCosts;
import React, { useState, useEffect } from 'react';
import { useHistory,Link } from 'react-router-dom';
import axios from 'axios';
import { Card, Form, Row,Col, Button,ListGroup } from "react-bootstrap";
import { FormButton } from 'semantic-ui-react';




export default function DisplayHotels() {


    const [users, setUsers] = useState([]);
    // const [url,setUrl]=useState("");

    const history=useHistory();
    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/users')
            .then((response) => {
                console.log(response.data);
                setUsers(response.data);
            })
            .catch((error)=>{
                console.log(error);

            })
    }, [])


    // const alertClicked=(val)=>{
      
    //     setUrl(val);
   
    //     console.log({url});
        
    //     history.push("/bookings/${url}");

        
    // }

    return (
        <React.Fragment>
            <Card>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Displaying Search Results</Card.Header>
          <Card.Body>
        
        <ListGroup >
           
            
                {users.map(user=>{
                    return(
                        
                        <ListGroup.Item key={user.id} >
                    
                            <Row >
                            
                            <Col>{user.name}
                            </Col>
                            <Col>
                            {user.email}
                            </Col>
                            <Col>
                            <Link style={{variant:"success", fontStyle:"italic", color:"green"}} to={`hotel/${user.id}`}>Select</Link>
                            </Col>
                            </Row>
                            <Row>
                                <Col>
                                Description of the Hotel
                                </Col>
                                
                            </Row>
                            
                            </ListGroup.Item>
                        );
                    
                })}
        </ListGroup>
        </Card.Body>

        </Card>
        </React.Fragment>
)
       

}


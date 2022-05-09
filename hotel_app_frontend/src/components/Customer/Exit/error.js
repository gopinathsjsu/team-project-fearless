
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';

export default function Error(){

    return(
        <React.Fragment>
        <Card  style={{ marginTop:'15rem',
            
            margin: "auto", maxWidth: '40rem',
width: "100",
border: "3px solid red",
padding: "10px"}}>
            <p><i><b>
                OOPS !! Could not Process your request. Try Again : )
            </b>
                </i></p>
        </Card>
    </React.Fragment>
    )
}

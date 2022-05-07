
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';

export default function Exit(){

    return(
       <React.Fragment>
           <Card  style={{ marginTop:'10rem', margin: "auto", maxWidth: '40rem',
  width: "100",
  border: "3px solid green",
  padding: "10px"}}>
               <p><i><b>
               Yours bookings are confirmed !!! HOPE YOU ENJOY YOUR STAY : )
               </b>
                   </i></p>
           </Card>
       </React.Fragment>
    )
}

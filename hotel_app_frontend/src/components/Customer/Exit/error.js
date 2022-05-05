
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Card, Form, ListGroup, Row, Col, Button } from 'react-bootstrap';
import { Link, useParams,useNavigate } from 'react-router-dom';
import {useLocation} from 'react-router-dom';

export default function Error(){

    return(
        <div>
           There was an error. Please try again !!!!
        </div>
    )
}

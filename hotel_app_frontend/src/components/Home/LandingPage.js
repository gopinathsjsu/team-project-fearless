
import React from 'react';
import { Row, Col, Alert, Container } from 'react-bootstrap';
import Grid from '@mui/material/Grid';
import './LandingPage.css';

function LandingPage() {
    return (
        <div className='landingBody' style={{ backgroundSize: 'cover' }}>
            <Grid container spacing={4}>
                <Grid item xs={6}></Grid>
                <Grid item xs={6}></Grid>
            </Grid>
            
                <div class="cardlanding2 ">
                    <div>
                    <h1 style={{color:"black",fontSize:"30px", textAlign:"center", fontWeight:"bold" }}>HOTELS APPLICATION</h1>
                    <h3 style={{color:"black",fontSize:"25px", textAlign:"center", fontWeight:"bold"}}>
                        "Awesome vacations starts with best stays!!"
                    </h3>
                </div>
                
            </div>
        </div>
    );
}

export default LandingPage;
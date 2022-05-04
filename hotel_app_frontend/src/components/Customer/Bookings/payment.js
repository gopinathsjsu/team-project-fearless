import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {useLocation} from 'react-router-dom';
import { setDate } from 'date-fns';
export  default function Payment(){
    const location = useLocation();
    const [data,setData]=useState({});

    useEffect(()=>{

       
        setData(location.state);
       
        console.log(data);


    })
    return(
<div>Payment</div>

      
    )
}
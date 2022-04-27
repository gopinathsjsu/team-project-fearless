import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FormControl, InputLabel, Select, MenuItem } from '@mui/material';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import {Button} from 'react-bootstrap'
import {getLocationBasedHotels} from './Fetchjson';
import Header from "./Header";
import './HotelSearch.css';
//import {urls} from 'Utils';

function HotelSearch(props) {
    const navigate = useNavigate();
    const [location, setLocation] = useState("");
    const [from, setCheckIn] = useState("");
    const [to, setCheckOut] = useState("");
    const updateLocation=(e)=>{
      setLocation(e.target.value)
    }
    
    const handleSearch = async (e) => {
        e.preventDefault();
        
        //navigate("../find", {replace:true})
       props.updateHotelList(getLocationBasedHotels(location))
       /*await axios({
         method:'post',
         //TODO: update backend URL
         url:"",
         data:{location,checkIn,checkOut},
         config: {headers: { 'Content-Type': 'multipart/form-data'}} 
       }).then((response)=>{
         if(response.status >= 500){
           throw new Error("Bad response from server")
         }
         return response.data;
       }).then((responseData)=>{
         //TODO: uncomment below after backend api implementation
         //updateHotelList(responseData.message)
         
       })*/
       const data = JSON.stringify({from, to, location})
      // "{'from':"+ from+",'to':"+to+",'location':"+location+"}";
        //  console.log(data);
        console.log(data)

      /* axios.post("http://localhost:3000/",data).then(res=>{
        if (res.status==200){
            console.log(res.data);
        }
        else{
            console.log("wrong user");
        }
        
    });*/

    };

    return (
        <div>
        <div className="searchfilter">
        <form className="search_form">
        <div className="searchDestination">
           <FormControl fullWidth>
              <InputLabel id="demo-simple-select-label">Where?</InputLabel>
              <Select
                defaultValue={location}
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={location}
                label="Where?"
                onChange={updateLocation}
              >
                <MenuItem value={"London"}>London</MenuItem>
                <MenuItem value={"Mangalore"}>Mangalore</MenuItem>
              </Select>
            </FormControl>
          </div>
          <br/>
          <div className="date_picker">
            <LocalizationProvider dateAdapter={AdapterDateFns}>
              <DatePicker
                allowSameDateSelection={true}                
                label="CheckIn"
                inputFormat="MM/dd/yyyy"
                value={from}
                onChange={(d) => setCheckIn(d)}
                renderInput={(params) => <TextField fullWidth={true} {...params} />}
              />
            </LocalizationProvider>
          </div>
          <br/>
          <div className="date_picker">
            <LocalizationProvider dateAdapter={AdapterDateFns}>
                <DatePicker
                  allowSameDateSelection={true}
                  label="CheckOut"
                  inputFormat="MM/dd/yyyy"
                  value={to}
                  onChange={(d) => setCheckOut(d)}
                  renderInput={(params) => <TextField fullWidth={true} {...params} />}
                />
              </LocalizationProvider>
          </div>
          <br/>
          <div className="searchHotel">
            <Button className = "button"
              onClick={handleSearch}>
              Search
            </Button>
          </div>
        </form>
        </div>
    </div>
    );
};

export default HotelSearch;
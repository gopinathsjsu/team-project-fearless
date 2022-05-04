import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FormControl, InputLabel, Select, MenuItem } from '@mui/material';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import {Button} from 'react-bootstrap';
import {getLocationBasedHotels} from './Fetchjson';
import Header from "./Header";
import './HotelSearch.css';
import utilObj from '../Utils/utils';

function HotelSearch(props) {
    const navigate = useNavigate();
    const [location, setLocation] = useState("");
    const [from, setCheckIn] = useState(new Date().toISOString().substring(0,10));
    const [to, setCheckOut] = useState(new Date().toISOString().substring(0,10));
    
    const updateLocation=(e)=>{
      setLocation(e.target.value)
    }
   
    const handleSearch = async (e) => {
        e.preventDefault();
        if(utilObj.getDays(from, to) > 7){
          alert("Please choose 7 or less days")
          return;
        }
        if(!utilObj.isValidCheckinAndCheckout(from, to)){
          alert("Checkout date should be later than checkin")
          return;
        }
        localStorage.setItem("from", from);
        localStorage.setItem("to", to);
        localStorage.setItem("location", location);
       props.updateHotelList(getLocationBasedHotels(location, from, to))
       
       const data = {from, to, location}
       console.log(data);

      /* axios({
              method: "post",
              url: utilObj.urls.backendURL+"/api/hotel/search",
              headers: {
              "Content-Type": "application/json",
            },
             data}).then(res=>{
              if (res.status==200){
                  updateHotelList(res.message)
                  console.log(res.data);
              }
              else{
                  console.log("Bad response from server");
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
                onChange={(d) => setCheckIn(d.toISOString().substring(0,10))}
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
                  onChange={(d) => setCheckOut(d.toISOString().substring(0,10))}
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
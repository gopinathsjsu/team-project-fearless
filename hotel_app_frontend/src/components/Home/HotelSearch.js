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
import './Styles/HotelSearch.css';
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

      axios({
              method: "post",
              url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/api/hotel/search",
              // url: utilObj.urls.backendURL+"/api/hotel/search",
              headers: {
              "Content-Type": "application/json",
            },
             data}).then(res=>{
              if (res.status==200){
                  // updateHotelList(res.message)
                  console.log(res.data);
              }
              else{
                  console.log("Bad response from server");
              }
              
          });

      };

    return (
        <div>
        <div className="search-bar">
          <form>
            <div className="search-location form-search">
             <FormControl fullWidth >
                <InputLabel id="demo-simple-select-label">Where?</InputLabel>
                <Select
                  defaultValue={location}
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  value={location}
                  label="Where?"
                  onChange={updateLocation}
                >
                  <MenuItem value={"San Francisco"}>San Francisco</MenuItem>
                  <MenuItem value={"Mangalore"}>Mangalore</MenuItem>
                  <MenuItem value={"Udupi"}>Udupi</MenuItem>
                  <MenuItem value={"Santa Cruz"}>Sanat Cruz</MenuItem>
                  <MenuItem value={"New Delhi"}>New Delhi</MenuItem>
                </Select>
              </FormControl>
            </div>
            <div className="date_picker search-from form-search">
              <LocalizationProvider dateAdapter={AdapterDateFns}>
                <DatePicker
                  allowSameDateSelection={false}
                  label="CheckIn"
                  inputFormat="MM/dd/yyyy"
                  value={from}
                  onChange={(d) => setCheckIn(d.toISOString().substring(0,10))}
                  renderInput={(params) => <TextField fullWidth={true} {...params} />}
                />
              </LocalizationProvider>
            </div>
            <div className="date_picker search-to form-search">
              <LocalizationProvider dateAdapter={AdapterDateFns}>
                  <DatePicker
                    allowSameDateSelection={false}
                    label="CheckOut"
                    inputFormat="MM/dd/yyyy"
                    value={to}
                    onChange={(d) => setCheckOut(d.toISOString().substring(0,10))}
                    renderInput={(params) => <TextField fullWidth={true} {...params} />}
                  />
                </LocalizationProvider>
            </div>
            <div className="searchHotel">
              <Button className = "button-search"
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
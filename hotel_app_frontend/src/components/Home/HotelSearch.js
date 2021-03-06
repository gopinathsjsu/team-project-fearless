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
        /*
        if(utilObj.getDays(new Date(), from) < 0){
          
          alert("Invalid date selection")
          return;
        }*/
        if(!utilObj.isValidCheckinAndCheckout(from, to)){
          alert("Checkout date should be later than checkin")
          return;
        }
        localStorage.setItem("from", from);
        localStorage.setItem("to", to);
        localStorage.setItem("location", location);
       
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
                  localStorage.setItem("hotelList", JSON.stringify(res.data));
                  console.log("local storage hotel list is :",JSON.parse(localStorage.getItem("hotelList")));
                  props.updateHotelList(JSON.stringify(res.data))
                  console.log(res.data);

                  // //limeka
                  // localStorage.setItem("HotelList",JSON.stringify(res.data));
                  // console.log("the hotel list is ",JSON.parse(localStorage.getItem("HotelList")));
                  // // const selectedHotel=JSON.parse(localStorage.getItem("selectedHotel"));
                  // // console.log("amenities",selectedHotel.amenities);
                  // //limeka


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
                  <MenuItem value={"Los Angeles"}>Los Angeles</MenuItem>
                  <MenuItem value={"San Jose"}>San Jose</MenuItem>
                  <MenuItem value={"Santa Cruz"}>Santa Cruz</MenuItem>
                </Select>
              </FormControl>
            </div>
            <div className="date_picker search-from form-search">
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
            <div className="date_picker search-to form-search">
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
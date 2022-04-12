mport React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {FormControl, InputLabel, Select, MenuItem} from '@mui/material/'


import './LandingPage.css';

function LandingPage() {
    const navigate = useNavigate();
    const [location, setLocation] = useState("");
    const [checkIn, setCheckIn] = useState();
    const [checkOut, setCheckOut] = useState();
    
    const handleSearch = (e) => {
        e.preventDefault();
        navigate("/findhotels");
    };

    return (
        <div>
        <div className="searchfilter">
        <form className="search_form">
        <div className="searchDestination">
           <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Where?</InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={location}
              label="Where?"
              onChange={(e) => setLocation(e.target.value)}
            >
              <MenuItem value={setLocation}>London</MenuItem>
              <MenuItem value={setLocation}>Perth</MenuItem>
              <MenuItem value={setLocation}>India</MenuItem>
            </Select>
            </FormControl>
          </div>
          <div className="date_picker">
            <label className="duration" htmlFor="checkIn">
              Check In
            </label>
            <input
                style={{ height: "50px" }}
                onChange={(e) => setCheckIn(e.target.value)}
                className="duration"
                type="date"
            ></input>
          </div>
          <div className="date_picker">
            <label className="duration" htmlFor="checkOut">
              Check Out
            </label>
            <input
              style={{ height: "50px" }}
              onChange={(e) => setCheckOut(e.target.value)}
              className="duration"
              type="date"
            ></input>
          </div>
          <div className="searchHotel">
            <button
              style={{ height: "35px" }}
              className="searchBtn"
              onClick={handleSearch}
            >
              Search
            </button>
          </div>
        </form>
        </div>
    </div>
    );
};

export default LandingPage;

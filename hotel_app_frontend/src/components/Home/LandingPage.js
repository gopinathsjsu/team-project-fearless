import React, { useState } from "react";
import HotelSearch from "./HotelSearch";
import HotelList from "./HotelList";
import Header from "./Header";

function LandingPage() {
    const [hotelList, setHotelList] = useState(JSON.parse(localStorage.getItem("hotelList")));
    const updateHotelList = (hotelList) => {
        //hotelList = JSON.parse(localStorage.getItem("hotelList"));
        hotelList = JSON.parse(hotelList);
        setHotelList(hotelList)
    }
    return (
        <div>
            <HotelSearch updateHotelList={updateHotelList}/>
            <HotelList hotelList = {hotelList}/> 
        </div>
    )

}

export default LandingPage;
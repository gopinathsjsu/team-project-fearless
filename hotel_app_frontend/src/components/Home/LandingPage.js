import React, { useState } from "react";
import HotelSearch from "./HotelSearch";
import HotelList from "./HotelList";
import Header from "./Header";



function LandingPage() {
    const [hotelList, setHotelList] = useState("");
    const updateHotelList = (hotelList) => {
        setHotelList(hotelList)
    }
    return (
        <div>
            <Header/>
            <HotelSearch updateHotelList={updateHotelList}/>
            <HotelList hotelList = {hotelList}/>

            
        </div>
    )

}

export default LandingPage;
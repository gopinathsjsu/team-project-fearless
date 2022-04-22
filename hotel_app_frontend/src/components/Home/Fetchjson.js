export const getLocationBasedHotels = (location) =>{
    let mangaloreJson = [
      {
          "hotelId": 100,
          "hotelname": "The Ocean Pearl-Mangalore",
          "hotelLocation": "Mangalore",
          "hotel_address": "Navabharath Cir, KA, India",
          "hotelZipCode": 575003,
          "hotelContact": "12345667890",
          "hotelManagerName": "Rajesh Koothrappali",
          "hotelEmail": "stg@gmail.com"
  
      },
      {
          "hotelId": 200,
          "hotelname": "The Ocean Pearl-Mangalore",
          "hotelLocation": "Mangalore",
          "hotel_address": "Navaopbharath Cir, KA, India",
          "hotelZipCode": 579003,
          "hotelContact": "12322667890",
          "hotelManagerName": "Rajesh Koothyurappali",
          "hotelEmail": "pop@gmail.com"
  
      }
  ];

  let LondonJson = [
    {
        "hotelId": 100,
        "hotelname": "The Ocean Pearl-London",
        "hotelLocation": "Mangalore",
        "hotel_address": "Navabharath Cir, KA, India",
        "hotelZipCode": 575003,
        "hotelContact": "12345667890",
        "hotelManagerName": "Rajesh Koothrappali",
        "hotelEmail": "stg@gmail.com"

    },
    {
        "hotelId": 200,
        "hotelname": "The Ocean Pearl-London",
        "hotelLocation": "Mangalore",
        "hotel_address": "Navaopbharath Cir, KA, India",
        "hotelZipCode": 579003,
        "hotelContact": "12322667890",
        "hotelManagerName": "Rajesh Koothyurappali",
        "hotelEmail": "pop@gmail.com"

    }
];
let hotelMap = {
  "Mangalore": mangaloreJson,
  "London":LondonJson
}
return hotelMap[location]
}

export const getUpcomingBookings = (user) => {
    return(
        [
            {
                "bookingId": "1",
                "checkIn": "12/4/2022",
                "checkOut": "12/18/2022",
                "hotelName": "Conrad",
                "noOfGuests": "3",
                "noOfRooms": "2"
            },
            {
                "bookingId": "2",
                "checkIn": "4/4/2022",
                "checkOut": "4/18/2022",
                "hotelName": "Alice Bob",
                "noOfGuests": "3",
                "noOfRooms": "2"
            },
            {
                "bookingId": "3",
                "checkIn": "5/4/2022",
                "checkOut": "5/18/2022",
                "hotelName": "Barefoot",
                "noOfGuests": "4",
                "noOfRooms": "2"
            },
        ]
    )
}
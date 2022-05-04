export const getLocationBasedHotels = (location, from, to) =>{
    let mangaloreJson = [
        {
            "amenities": [
                {
                    "amenityId": 1,
                    "amenityCode": "CB",
                    "amenityType": "Daily Continental Breakfast",
                    "amenityCost": 25
                },
                {
                    "amenityId": 2,
                    "amenityCode": "FR",
                    "amenityType": "Access to fitness room",
                    "amenityCost": 25
                },
                {
                    "amenityId": 3,
                    "amenityCode": "SJ",
                    "amenityType": "Access to Swimming Pool/Jacuzzi",
                    "amenityCost": 25
                },
                {
                    "amenityId": 4,
                    "amenityCode": "DP",
                    "amenityType": "Daily Parking",
                    "amenityCost": 10
                },
                {
                    "amenityId": 5,
                    "amenityCode": "BF",
                    "amenityType": "Breakfast",
                    "amenityCost": 10
                },
                {
                    "amenityId": 6,
                    "amenityCode": "LN",
                    "amenityType": "Lunch",
                    "amenityCost": 10
                },
                {
                    "amenityId": 7,
                    "amenityCode": "DN",
                    "amenityType": "Dinner",
                    "amenityCost": 10
                }
            ],
            "hotel": {
                "hotelId": 100,
                "hotelname": "The Ocean Pearl",
                "hotelLocation": "Mangalore",
                "hotel_address": "Navabharath Cir, KA, India",
                "hotelZipCode": 575003,
                "hotelContact": "12345667890",
                "hotelManagerName": "Rajesh Koothrappali"
            },
            "availability": {
                "DR": 90,
                "SR": 90
            }
        },
        {
            "amenities": [
                {
                    "amenityId": 1,
                    "amenityCode": "CB",
                    "amenityType": "Daily Continental Breakfast",
                    "amenityCost": 25
                },
                {
                    "amenityId": 2,
                    "amenityCode": "FR",
                    "amenityType": "Access to fitness room",
                    "amenityCost": 25
                },
                {
                    "amenityId": 3,
                    "amenityCode": "SJ",
                    "amenityType": "Access to Swimming Pool/Jacuzzi",
                    "amenityCost": 25
                },
                {
                    "amenityId": 4,
                    "amenityCode": "DP",
                    "amenityType": "Daily Parking",
                    "amenityCost": 10
                },
                {
                    "amenityId": 5,
                    "amenityCode": "BF",
                    "amenityType": "Breakfast",
                    "amenityCost": 10
                },
                {
                    "amenityId": 6,
                    "amenityCode": "LN",
                    "amenityType": "Lunch",
                    "amenityCost": 10
                },
                {
                    "amenityId": 7,
                    "amenityCode": "DN",
                    "amenityType": "Dinner",
                    "amenityCost": 10
                }
            ],
            "hotel": {
                "hotelId": 400,
                "hotelname": "Hilton",
                "hotelLocation": "Mangalore",
                "hotel_address": "Navabharath Cir, KA, India",
                "hotelZipCode": 575003,
                "hotelContact": "12345667890",
                "hotelManagerName": "Rajesh Koothrappali"
            },
            "availability": {
                "DR": 175,
                "SR": 175
            }
        }
    ];

  let LondonJson = [
    {
        "amenities": [
            {
                "amenityId": 1,
                "amenityCode": "CB",
                "amenityType": "Daily Continental Breakfast",
                "amenityCost": 25
            },
            {
                "amenityId": 2,
                "amenityCode": "FR",
                "amenityType": "Access to fitness room",
                "amenityCost": 25
            },
            {
                "amenityId": 3,
                "amenityCode": "SJ",
                "amenityType": "Access to Swimming Pool/Jacuzzi",
                "amenityCost": 25
            },
            {
                "amenityId": 4,
                "amenityCode": "DP",
                "amenityType": "Daily Parking",
                "amenityCost": 10
            },
            {
                "amenityId": 5,
                "amenityCode": "BF",
                "amenityType": "Breakfast",
                "amenityCost": 10
            },
            {
                "amenityId": 6,
                "amenityCode": "LN",
                "amenityType": "Lunch",
                "amenityCost": 10
            },
            {
                "amenityId": 7,
                "amenityCode": "DN",
                "amenityType": "Dinner",
                "amenityCost": 10
            }
        ],
        "hotel": {
            "hotelId": 100,
            "hotelname": "The Ocean Pearl-London",
            "hotelLocation": "London",
            "hotel_address": "Navabharath Cir, KA, India",
            "hotelZipCode": 575003,
            "hotelContact": "12345667890",
            "hotelManagerName": "Rajesh Koothrappali"
        },
        "availability": {
            "DR": 90,
            "SR": 90
        }
    },
    {
        "amenities": [
            {
                "amenityId": 1,
                "amenityCode": "CB",
                "amenityType": "Daily Continental Breakfast",
                "amenityCost": 25
            },
            {
                "amenityId": 2,
                "amenityCode": "FR",
                "amenityType": "Access to fitness room",
                "amenityCost": 25
            },
            {
                "amenityId": 3,
                "amenityCode": "SJ",
                "amenityType": "Access to Swimming Pool/Jacuzzi",
                "amenityCost": 25
            },
            {
                "amenityId": 4,
                "amenityCode": "DP",
                "amenityType": "Daily Parking",
                "amenityCost": 10
            },
            {
                "amenityId": 5,
                "amenityCode": "BF",
                "amenityType": "Breakfast",
                "amenityCost": 10
            },
            {
                "amenityId": 6,
                "amenityCode": "LN",
                "amenityType": "Lunch",
                "amenityCost": 10
            },
            {
                "amenityId": 7,
                "amenityCode": "DN",
                "amenityType": "Dinner",
                "amenityCost": 10
            }
        ],
        "hotel": {
            "hotelId": 400,
            "hotelname": "Hilton-London",
            "hotelLocation": "London",
            "hotel_address": "Navabharath Cir, KA, India",
            "hotelZipCode": 575003,
            "hotelContact": "12345667890",
            "hotelManagerName": "Rajesh Koothrappali"
        },
        "availability": {
            "DR": 175,
            "SR": 175
        }
    }
];
let hotelMap = {
  "Mangalore": mangaloreJson,
  "London":LondonJson
}
return hotelMap[location]
}

export const getBookings = (user) => {
    return(
        [
            {
                "bookingId": 4,
                "hotelId": 400,
                "customerId": 1,
                "room": "DR2-SR2",
                "amenity": "FR-SJ",
                "bookingDateFrom": "2022-05-20T07:00:00.000+00:00",
                "bookingDateTo": "2022-05-25T07:00:00.000+00:00",
                "noOfGuest": 1,
                "bookingStatus": "Booked",
                "amount": 3060.0,
                "totalAmount": 3060.0,
                "paymentMethod": "Cash",
                "roomNumbers": "A120",
                "lpUsed": 20
            },
            {
                "bookingId": 5,
                "hotelId": 500,
                "customerId": 1,
                "room": "DR2-SR2",
                "amenity": "FR-SJ",
                "bookingDateFrom": "2022-04-20T07:00:00.000+00:00",
                "bookingDateTo": "2022-04-25T07:00:00.000+00:00",
                "noOfGuest": 1,
                "bookingStatus": "Booked",
                "amount": 3020.0,
                "totalAmount": 3020.0,
                "paymentMethod": "Cash",
                "roomNumbers": "A120",
                "lpUsed": 60
            },
            {
                "bookingId": 6,
                "hotelId": 600,
                "customerId": 1,
                "room": "DR2-SR2",
                "amenity": "FR-SJ",
                "bookingDateFrom": "2022-06-20T07:00:00.000+00:00",
                "bookingDateTo": "2022-06-25T07:00:00.000+00:00",
                "noOfGuest": 1,
                "bookingStatus": "Booked",
                "amount": 3070.0,
                "totalAmount": 3070.0,
                "paymentMethod": "Cash",
                "roomNumbers": "A120",
                "lpUsed": 10
            },
            {
                "bookingId": 7,
                "hotelId": 700,
                "customerId": 1,
                "room": "DR3-SR3",
                "amenity": "CB-DP",
                "bookingDateFrom": "2022-04-20T07:00:00.000+00:00",
                "bookingDateTo": "2022-04-25T07:00:00.000+00:00",
                "noOfGuest": 1,
                "bookingStatus": "Booked",
                "amount": 4440.0,
                "totalAmount": 4440.0,
                "paymentMethod": "Cash",
                "roomNumbers": "A120",
                "lpUsed": 20
            }
        ]
        
    )
}
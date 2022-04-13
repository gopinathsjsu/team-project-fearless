


// import axios from "axios";
// import React,{useState} from "react";
// import { Button } from "react-bootstrap";
// import { useHistory } from "react-router-dom";


// export default function BookRoom(){
//     const [booking, setbooking]=useState({
//         roomtype:"",
//         TotalGuests:""
//         })
//     // const history=useHistory()
    
//     const handleSubmit=(event)=>{
//         event.preventDefault();
       
//         // axios.post("/bookhotel",{booking}).then(
//         //     res=>{
//         //         if (res.status==200){
//         //         console.log("booked room successfully")
//         //     }else{
//         //         console.log("booking error")
//         //     }}
//         // );
//         setbooking({roomtype:"",
//         TotalGuests:""
//          });
//     }
//     const handleChange=(event)=>{
//         console.log(event.target.value);
       
//         setbooking({...booking,[event.target.name]:event.target.value});
//         // console.log(setbooking);
//     }

   
//     return (
//         <div>
//             <p>
//                 Hotel 1
//             </p>
//             <br></br>
//             <form onSubmit={handleSubmit} onChange={handleChange} >
//             <label for="roomtype" name="roomtype" value={booking.roomtype}>Choose Room Type </label>

// <select name="roomtype" id="roomtype">
//   <option value="single">Single</option>
//   <option value="double">Double</option>
//   <option value="Deluxe">Deluxe</option>
//   <option value="Suite">Suite</option>
// </select>
// <br></br>
//  <label for="totalguests" name="TotalGuests"  >Select Number of guests </label>
//  <input type="number" name="TotalGuests" value={booking.TotalGuests}></input>
//  <br>
//  </br>
//  <Button type="submit">Book now</Button>  
//             </form>
            
//         </div>
//     )

// }
import React,{useState,useEffect} from "react";




export default function BookingsPage(props){
    const id=props.match.params.id
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [user, setUser] = useState([]);
    
    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users/" + id)
            .then(res => res.json())
            .then(
                (data) => {
                    console.log(data);
                    setUser(data);
                    setIsLoaded(true);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])
    if (error) {
        return <div>Error: {error.message}</div>;
    }
    if (!isLoaded) {
        return <div>Loading...</div>;
    }  
    
    if (user) {
        return (
            <div>
                <h1>{user.name}</h1>
                <div>
                    Email: {user.email}
                </div>
                <div>
                    Phone: {user.phone}
                </div>
                <div>
                    Website: {user.website}
                </div>
            </div>
        );
    }

  
    // return(
    //     <div> you are redirected to Hotel {id} page
    //         <h1>
    //             Hotel details
    //         </h1>
    //         name : {name}

    //     </div>
    // )
}
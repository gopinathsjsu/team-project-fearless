const urls = {
    backendURL : "http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/"
    //backendURL : "http://localhost:8081"
}

const getDays = (fromDate, toDate) =>{
    let date1 = new Date(toDate);
    let date2 = new Date(fromDate);
    let diffTime = date1.getTime() - date2.getTime();
    let diffDays = diffTime / (1000 * 3600 * 24);
    return diffDays;
   }

   const isValidCheckinAndCheckout = (fromDate, toDate) =>{
    let diffDays = getDays(fromDate, toDate)
    return diffDays > 0;
   }

   const getCustomerId = () => {
       let user = localStorage.getItem("user")
       if(user){

        try {
            let userObj = JSON.parse(user);
                if(userObj.object)
                 return userObj.object.custId
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
        return null
   }

   const utilObj = {
       "urls": urls,
       "getDays" : getDays,
       "isValidCheckinAndCheckout": isValidCheckinAndCheckout,
       "getCustomerId" : getCustomerId
   }

export default utilObj
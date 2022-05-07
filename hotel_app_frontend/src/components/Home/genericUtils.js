export var getUserEmail = () => {
    let user = localStorage.getItem("custId")
    try {
        let userObj = JSON.parse(user);
            if(userObj)
             return userObj.custEmail
    }catch(err) {
        console.log('Error: ', err.message);
    }
        return null
}

export var getUserFirstName = () => {
    let user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.custFirstName
        }catch(err) {
            console.log('Error: ', err.message);
        }
     
    }
     return null
}

export var getUserLastName = () => {
    let user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.custLastName
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

export var getRewardPoints = () => {
    const user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.loyaltyPoints
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

export var getAddress = () => {
    const user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.custAddress
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

export var getBookingCount = () => {
    const user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.bookingCount
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

export var getContact = () => {
    const user = localStorage.getItem("custId")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj)
                 return userObj.contactNumber
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

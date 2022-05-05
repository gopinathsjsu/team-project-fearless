export var getUserEmail = () => {
    let user = localStorage.getItem("user")
    try {
        let userObj = JSON.parse(user);
            if(userObj.object)
             return userObj.object.custEmail
    }catch(err) {
        console.log('Error: ', err.message);
    }
        return null
}

export var getUserFirstName = () => {
    let user = localStorage.getItem("user")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj.object)
                 return userObj.object.custFirstName
        }catch(err) {
            console.log('Error: ', err.message);
        }
     
     
    }
     return null
}

export var getUserLastName = () => {
    let user = localStorage.getItem("user")
    if(user){
        try {
            let userObj = JSON.parse(user);
                if(userObj.object)
                 return userObj.object.LastName
        }catch(err) {
            console.log('Error: ', err.message);
        }
    }
     return null
}

export var getRewardPoints = () => {
    const username = localStorage.getItem("rewardPoints")
    return username
}

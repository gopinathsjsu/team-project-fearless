export var getUserEmail = () => {
    let user = localStorage.getItem("user")
       if(user){
        let userObj = JSON.parse(user);
        if(userObj.object)
            return userObj.object.custEmail
       }
        return null
}

export var getUserFirstName = () => {
    let user = localStorage.getItem("user")
    if(user){
     let userObj = JSON.parse(user);
     if(userObj.object)
         return userObj.object.custFirstName
    }
     return null
}

export var getUserLastName = () => {
    let user = localStorage.getItem("user")
    if(user){
     let userObj = JSON.parse(user);
     if(userObj.object)
         return userObj.object.custLastName
    }
     return null
}

export var getRewardPoints = () => {
    const username = localStorage.getItem("rewardPoints")
    return username
}

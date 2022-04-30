export var getUserEmail = () => {
    const email = localStorage.getItem("email")
    return email
}

export var getUserName = () => {
    const username = localStorage.getItem("user")
    return username
}

export var getRewardPoints = () => {
    const username = localStorage.getItem("rewardPoints")
    return username
}

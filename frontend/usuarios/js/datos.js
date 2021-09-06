const BASE_API_URL = 'http://localhost:8090/users/'

const personalCustomerData = document.getElementById('PersonalCustomerData') 
const userPicture = document.getElementById('userPicture')
const userButton = document.getElementById('customerButton')

//console.log(personalCustomerData)

const renderUserDataForm = (user) => {
    holito = user
    console.log(user)
    document.getElementById('names').value = user.names
    document.getElementById('lastNames').value = user.lastNames
    document.getElementById('identificationNumber').value = user.identificationNumber
    document.getElementById('phoneNumber').value = user.phoneNumber
    document.getElementById('address').value = user.address
    document.getElementById('email').value = user.email
    document.getElementById('password').value = user.password

}



function updateCustomer(){
    console.log('ACTUALIZADO EL USUARIOOOOOOOOOO')
    location.href = 'http://127.0.0.1:5501/usuarios/MiPlan.html'
    
}

function updateCustomerPassword(){
    console.log('ACTUALIZANDO PASSWORDDDDDDDDDDDDDDDD')
}


async function userData(userId){
    const data = await fetch(BASE_API_URL + userId)
    return data.json()
};

async function getData(){
    const userId = localStorage.getItem('userId')
    const user = await userData(userId)
    template = renderUserDataForm(user.user)
    userButton.setAttribute('id', 'holiwis')
    userButton.textContent = user.user.names
    if (!user.user.photo){
        userPicture.src = user.user.photo
    }else{
        userPicture.src = './imagenes/default-profile.png'
    }
}

getData()
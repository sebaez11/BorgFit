const API_URL = 'http://localhost:8090/users/customers/'

document.getElementById('user-register-form').addEventListener('submit', (evt) => {
    evt.preventDefault()
    createCustomer()
})


async function createCustomer(evt){
    const customer = {
        identificationNumber: document.getElementById('identificationNumber').value,
        names: document.getElementById('names').value,
        lastNames: document.getElementById('lastNames').value,
        address: document.getElementById('address').value,
        phoneNumber: document.getElementById('phoneNumber').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        photo: "./imagenes/administratives/default-profile.png"
    }
    const objectfilled = Object.values(customer)
    //console.log(administrative)
    if(!objectfilled.includes("")){
        let response = await fetch(API_URL, {
            method: "POST",
            body: JSON.stringify(customer),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        
        if(response.ok){
            location.href = "http://127.0.0.1:5501/usuarios/loginUser.html"
        }else if(response.status == 422){
            formError = document.getElementById("form-error");
            formError.innerHTML = 'Email y número de identificación deben ser únicos.'
        }
        console.log(response)
    }
}
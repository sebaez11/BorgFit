const BASE_API_URL = 'http://localhost:8090/users/administratives/'

document.getElementById('form-administrativo').addEventListener('submit' , (evt) => {
    evt.preventDefault()
    createAdministrative()
})

async function createAdministrative(evt){

    const administrative = {
        identificationNumber: document.getElementById('identification').value,
        names: document.getElementById('first_name').value,
        lastNames: document.getElementById('last_name').value,
        address: document.getElementById('address').value,
        phoneNumber: document.getElementById('phone_number').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        photo: "./imagenes/administratives/default-profile.png"
    }
    const objectfilled = Object.values(administrative)
    //console.log(administrative)
    if(!objectfilled.includes("")){
        let response = await fetch(BASE_API_URL, {
            method: "POST",
            body: JSON.stringify(administrative),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        if(response.ok){
            location.href = "http://127.0.0.1:5501/admin/crudAdmin.html"
        }else if(response.status == 422){
            formError = document.getElementById("form-error");
            formError.innerHTML = 'Email y número de identificación deben ser únicos.'
        }
    }
}

const API_URL = 'http://localhost:8090/users/'


document.getElementById('login-form').addEventListener('submit', (evt) => {
    evt.preventDefault()
    customerLogin()
})

async function customerLogin() {
    const userLogin = {
        identificationNumber: document.getElementById('userId').value,
        password: document.getElementById('userPassword').value
    }
    const URI = 'customers/login/'
    let response = await fetch(API_URL + URI, {
        method: "POST",
        body: JSON.stringify(userLogin),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    if (response.ok) {
        response = response.json()
        response.then(data => localStorage.setItem('token',data.userJwt.token))
        response.then(data => localStorage.setItem('userId',data.userJwt.identificationNumber))
        location.href = 'http://127.0.0.1:5501/usuarios/Datos.html'
    } else if (response.status == 401 || response.status == 404 || response.status == 500) {
        formError = document.getElementById("form-error");
        formError.innerHTML = 'Verifique que los datos sean correctos. Este es un inicio de sesión para clientes.'
    }

}
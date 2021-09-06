API_URL = 'http://localhost:8090/users/'


async function renderAdministrativeDataData() {
    const response = await getAdministrativeData()
    document.getElementById('identificationNumber').value = response.user.identificationNumber
    document.getElementById('names').value = response.user.names
    document.getElementById('lastNames').value = response.user.lastNames
    document.getElementById('email').value = response.user.email
    document.getElementById('password').value = response.user.password
    document.getElementById('phoneNumber').value = response.user.phoneNumber
    document.getElementById('address').value = response.user.address
}

async function getAdministrativeData() {
    const administrativeId = localStorage.getItem('AdministrativeId')
    let response = await fetch(API_URL + administrativeId)
    return response.json()
}
renderAdministrativeDataData()
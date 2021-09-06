const API_URL = 'http://localhost:8090/users/'

const renderAdministrativeData = (administrative) => `
<div class="media">
    <img src="imagenes/administratives/default-profile.png" class="rounded-circle" height="50" />
    <div class="media-body">
        <p class="ml-4">
            <input value="${administrative.photo}" required id="photo" type="file" name="photo">
            <div class="invalid-feedback">
                Este campo es requerido.
            </div>
        </p>
    </div>
</div>

<div class="row g-3">
    <div class="offset-2 col-8">
        <p class="is-invalid alert-danger" id="form-error">
            
        </p>
    </div>
    <div class="offset-2 col-8">
        <input value="${administrative.names}" required type="text" class="form-control" id="names" placeholder="Nombres">
        <div class="invalid-feedback">
            Este campo es requerido.
        </div>
    </div>

    <div class="offset-2 col-8">
        <input value="${administrative.lastNames}" required type="text" class="form-control" id="lastNames" placeholder="Apellidos">
        <div class="invalid-feedback">
            Este campo es requerido.
        </div>
    </div>

    <div class="offset-2 col-8">
        <input value="${administrative.identificationNumber}" readonly required type="text" class="form-control" id="identification" placeholder="Número de identificación">
        <div class="invalid-feedback">
            Este campo es requerido y debe ser único.
        </div>
    </div>

    <div class="offset-2 col-8">
        <input value="${administrative.email}" required type="email" class="form-control" id="email" placeholder="Email">
        <div class="invalid-feedback">
            Este campo es requerido y debe ser único.
        </div>
    </div>
    
    <div class="offset-2 col-8">
        <input value="${administrative.phoneNumber}" required type="text" class="form-control" id="phoneNumber" placeholder="Teléfono">
        <div class="invalid-feedback">
            Este campo es requerido.
        </div>
    </div>

    <div class="offset-2 col-8">
        <input value="${administrative.address}" required type="text" class="form-control" id="address" placeholder="Dirección">
        <div class="invalid-feedback">
            Este campo es requerido.
        </div>
    </div>
`

const renderChangePassword = (password) => `
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <label style="color: #2C305E;">Actualizacion de Contraseña</label>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="Contraseña anterior" id="recipient-name" value="${password}">
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="Contraseña nueva" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Actualizar</button>
            </div>
        </div>
    </div>
`

/* document.getElementById('update-administrative-form').addEventListener('submit', (evt) => {
    evt.preventDefault()
    updateAdministrative()
})
 */
async function updateAdministrative() {
    const administrativeId = localStorage.getItem('administrativeId')
    const administrative = {
        identificationNumber: document.getElementById('identificationNumber'),
        names: document.getElementById('names'),
        lastNames: document.getElementById('lastNames'),
        email: document.getElementById('email'),
        password: document.getElementById('password'),
        phoneNumber: document.getElementById('phoneNumber'),
        address: document.getElementById('address'),

    }
    console.log(administrative)
    const response = await fetch(API_URL + administrativeId, {
        method = "PUT",
        body = JSON.stringify(administrative)
    })

    if (response.ok) {
        location.href = 'http://127.0.0.1:5501/admin/crudAdmin.html'
    } else {
        console.log(response)
    }
}
const bodyy = document.getElementById('bodyy');
const BASE_API_URL = 'http://localhost:8090/users/'

const renderAdministrativeData = (administrative) => `
    <tr>
        <td><img src="${administrative.photo}" class="avatar" alt="${administrative.names}">${administrative.names}</td>
        <td>${administrative.email}</td>
        <td>${administrative.phoneNumber}</td>
        <td>${administrative.identificationNumber}</td>
        <td>
            <a onclick="getAdministrativeId(${administrative.identificationNumber})" href="./editarAdministrativo.html" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Editar">&#xE254;</i></a>
            <a data-target="#EliminarAdministrativo" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Eliminar">&#xe92b;</i></a>
        </td>
    </tr>
    <div id="EliminarAdministrativo" class="modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Eliminar administrativo</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>¿Está seguro de eliminar este administrativo?</p>
                            <p class="text-warning"><small>No podrá rehacerlo.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input onclick="eliminarAdministrativo(${administrative.identificationNumber})" type="submit" class="btn btn-danger" value="Sí, eliminar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
`


function getAdministrativeId(administrativeId) {
    localStorage.setItem('AdministrativeId', administrativeId)
    location.href = 'http://127.0.0.1:5501/admin/editarAdministrativo.html'
}

async function eliminarAdministrativo(id) {
    const data = await fetch(BASE_API_URL + id, {
        method: "DELETE"
    })
    location.href = 'http://127.0.0.1:5501/admin/crudAdmin.html'
}

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

async function getAll() {
    const data = await fetch(BASE_API_URL + 'administratives/')
    return data.json()
}

async function renderAll() {
    const response = await getAll()
    response.users.forEach(administrative => {
        if (!administrative.photo) {
            administrative.photo = 'imagenes/administratives/default-profile.png'
        }
        template = renderAdministrativeData(administrative)
        bodyy.innerHTML += template
    });
}

renderAll()
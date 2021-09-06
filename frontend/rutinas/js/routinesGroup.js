const routinesGroupsContainer = document.getElementById('routinesGroupsContainer');
const API_URL = 'http://localhost:8090/routines/groups/'


const renderRoutinesGroup = (routinesGroup) => `
        <div class="offset-1 row">
            <div class="card col-md-4 col-lg-4 mt-4 my-4">
                <img src="${routinesGroup.photo}" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title mb-0">${routinesGroup.name}</h5>
                    <button onclick="getRoutinesByRoutinesGroupId(${routinesGroup.id})" type="button" class="col-4 btn btn-primary">Ver</button>
                </div>
            </div>
        </div>
`

function getRoutinesByRoutinesGroupId(routinesGroupId) {
    localStorage.setItem('routinesGroupId', routinesGroupId)
    location.href = 'http://127.0.0.1:5501/rutinas/rutinas.html'
}

async function getAll() {
    const data = await fetch(API_URL)
    return data.json()
}

async function getAllRoutinesGroups() {
    const response = await getAll()
    response.routinesGroup.forEach(routinesGroup => {
        template = renderRoutinesGroup(routinesGroup)
        routinesGroupsContainer.innerHTML += template
    });
}

getAllRoutinesGroups()
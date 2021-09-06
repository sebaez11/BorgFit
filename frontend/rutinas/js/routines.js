const routinesContainer = document.getElementById('routines');
const API_URL = 'http://localhost:8090/routines/group/'

const renderRoutines = (routine) => `
    <div class="offset-1 col-4">
        <div class="card h-100">
            <img src="${routine.routinesGroup.photo}" class="card-img-top img-fluid" alt="...">
            <div class="card-body">
                <h5 class="card-title">${routine.routinesGroup.name}</h5>
                <p class="card-text">NIVEL ${routine.level}</p>
            </div>
            <button onclick="getExercisesByRoutineId(${routine.id})" type="button" class="col-4 btn btn-primary">Ver</button>
        </div>
    </div>
`


function getExercisesByRoutineId(routineId){
    localStorage.setItem('routineId', routineId)
    location.href = 'http://127.0.0.1:5501/rutinas/ejercicios.html'
}

async function getAll(){
    const routinesGroupId = localStorage.getItem('routinesGroupId')
    const data = await fetch(API_URL+routinesGroupId)
    return data.json()
}

async function getAllRoutines(){
    const response = await getAll()
    response.routines.forEach(routine => {
        console.log(routine)
        template = renderRoutines(routine)
        routinesContainer.innerHTML += template
    });
}


getAllRoutines()
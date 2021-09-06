const workoutsContainer = document.getElementById('workouts');
const BASE_API_URL = 'http://localhost:8090/routines/'

const renderWorkouts = (workout) => `
    <div class="col-4">
        <div class="card h-100">
            <img src="${workout.photo}" class="card-img-top img-fluid" alt="${workout.name}">
            <div class="card-body">
                <h5 class="card-title">${workout.name}</h5>
            </div>
            <div class="card-footer">
                <small class="text-muted"> SERIES: ${workout.series} / REPETITIONS: ${workout.repetitions} </small>
            </div>
        </div>
    </div>
`

async function getAll(){
    const routineId = localStorage.getItem('routineId')
    const data = await fetch(BASE_API_URL+routineId)
    return data.json()
}

async function getAllWorkouts(){
    const response = await getAll()
    console.log(response)
    response.routine.workouts.forEach(workout => {
        console.log(workout)
        template = renderWorkouts(workout)
        workoutsContainer.innerHTML += template
    });
}


getAllWorkouts()
const BASE_API_URL = 'http://localhost:8090/payments/users/'
const paymentHistoryTable = document.getElementById('paymentHistoryTable')

const renderPayment = (payment) => `
<tr>
    <td>${payment.month}</td>
    <td>
        ${payment.date}
    </td>
    <td>
    ${payment.amount}
    </td>
</tr>

`

async function getUserPayments() {
    const userId = localStorage.getItem('userId')
    let response = await fetch(BASE_API_URL + userId + '/')
    response = response.json()
    const MONTHS = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
    response.then(data => {
        data.payments.forEach(payment => {
            var date = new Date(payment.date)
            console.log(payment)
            payment = {
                ...payment,
                month: MONTHS[date.getMonth()]
            }
            template = renderPayment(payment)
            paymentHistoryTable.innerHTML += template
        });
    })
}



getUserPayments()
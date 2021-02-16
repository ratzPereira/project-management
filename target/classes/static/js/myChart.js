new Chart(document.getElementById("myDoughnutChart"), {
    type: 'doughnut',
     data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor:["#3e95cd", "#8e5ea2", "#3cba9f" ],
            borderColor: 'rgb(255, 99, 132)',
            data: [0, 10, 5, 2, 20, 30, 45]
        }]
    },

    // Configuration options go here
    options: {}
});
var niceChartData = decodeHtml(chartData)
var chartJsonArray = JSON.parse(niceChartData)


var arrayLength = chartJsonArray.length

var numericData = []
var labelData = []

for(var i = 0; i < arrayLength; i++) {
	numericData[i] = chartJsonArray[i].value
	labelData[i] = chartJsonArray[i].label
}





new Chart(document.getElementById("myDoughnutChart"), {
    type: 'doughnut',
     data: {
        labels: labelData,
        datasets: [{
            label: '',
            backgroundColor:["#3d8c40", "#03254c", "#f4bc1c" ],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
	title: {
		display: true,
		text: 'Project Statuses'
	}
}
});


function decodeHtml(html) {
	var txt = document.createElement("textarea")
	txt.innerHTML = html
	return txt.value
}
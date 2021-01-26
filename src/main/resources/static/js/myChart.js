
var niceChartData=decodeHtml(charData);
var chartJsonArray=JSON.parse(niceChartData); //If you receive data in JSON format, you can convert it into a JavaScript object:

var arrayLength=chartJsonArray.length;

var numericData=[];
var labelData=[];

for (var i=0; i< arrayLength;i++){

    numericData[i]=chartJsonArray[i].value;
    labelData[i]=chartJsonArray[i].label;
}



// For a pie chart                           //this is the area where the chart is going to be generated
 new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
     // The data for our dataset
     data: {
         labels: labelData,
         datasets: [{
             label: 'My First dataset',
             backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
             borderColor: 'rgb(255, 99, 132)',
             data: numericData
         }]
     },

     // here java script object
     options: {

        title:{
            display: true,
            text: 'project Statuses'
        }

     }
});

//[{"label": "completed","value": 1},{"label": "INPROGRESS","value": 2},{"label": "NOTSTARTED","value": 1}]

function decodeHtml(html){

    var  txt=document.createElement("textarea");  //decoding from json to java skript
    txt.innerHTML=html;
    return txt.value;
}

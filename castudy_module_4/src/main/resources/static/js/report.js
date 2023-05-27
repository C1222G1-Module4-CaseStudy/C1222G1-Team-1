
    google.charts.load('current', {packages: ['corechart']});
    google.charts.setOnLoadCallback(getReport);

    let arr = [];

    function getReport(){
        $.ajax({
            url: 'http://localhost:8080/report',

            type: 'get',
            success: function drawChart(elements) {
                arrData = [['Element', 'Density', { role: 'style' }]];
                $.each(elements, function(index, value){
                    arrData.push([value.saleDate, value.revenue])
                })
                // Define the chart to be drawn.
                let data = google.visualization.arrayToDataTable(arrData);
                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                    2]);

                var options = {
                    title: "Density of Precious Metals, in g/cm^3",
                    width: 600,
                    height: 400,
                    bar: {groupWidth: "95%"},
                    legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("myPieChart"));
                chart.draw(view, options);
            },
            error: () => {
                alert("hệ thống đang bảo trì");
            }
        });
    }






    google.charts.load('current', {packages: ['corechart']});
    google.charts.setOnLoadCallback(getReport);

    let arr = [];

    function getReport(){
        $.ajax({
            url: 'http://localhost:8080/report',
            type: 'get',
            success: function drawChart(res) {
                // [{role:"string"},  {role:"number"}, ],
                let data = google.visualization.arrayToDataTable([]);
                data.addColumn('string', 'Tên sản phẩm');
                data.addColumn('number', 'Số lượng');
                data.addColumn({role:"style"});
                $.each(res, function (i, obj) {
                    // arr.push([
                    //     obj.saleDate,
                    //     obj.revenue,
                    //     "gold"
                    // ]);
                    data.addRows([[
                            obj.nameProduct,
                            Number(obj.totals),
                            "gold"
                    ]]
                    )
                });

                let view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    {
                        calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation"
                    },
                    2]);

                let options = {
                    title: "Số lượng sản phẩm bán được",
                    width: 900,
                    height: 500,
                    bar: {groupWidth: "90%"},
                    legend: {position: "none"},
                };
                let chart = new google.visualization.ColumnChart(document.getElementById("myPieChart"));
                chart.draw(view, options);
            }
            ,
            error: () => {
                alert("hệ thống đang bảo trì");
            }
        });
    }







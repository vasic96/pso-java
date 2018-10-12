$(document).ready(function(){
    

   // alert($("#numOfiterations").val());

   $('#numOfIteration').val("asdasd");



    $("#calculate").click(function(){

        var numberOfIterations = $("#numOfiterations").val();
        var particleNumber = $("#particleNumber").val();
        var fiParticle = $("#fiParticle").val();
        var fiSwarm = $("#fiSwarm").val();
        var omegavalue = $("#omegavalue").val();
        var numOfDimensions = $("#numOfDimensions").val();
        var funkcija = $("#selectFunction").val();
        var omegaMin = $("#omegaMin").val();


        var data = {
            "dimensions":numOfDimensions,
            "numofparticles":particleNumber,
            "omegavalue":omegavalue,
            "fiparticle":fiParticle,
            "fiswarm":fiSwarm,
            "function":funkcija,
            "iterations":numberOfIterations,
            "omegaMin":omegaMin
        }

        $.ajax({
            url: "http://localhost:8080/PsoWithJava/PsoServlet",
            type: "get",
            data: data,
            success: function(response){
                $(".table").remove();
                $("<table class=\"table\">"+
                    "<thead><tr>"+
                    "<th>#</th><th>Vrednost</th>"+
                    "</tr></thead>"+
                    "<tbody id=\"tbody\"><tr><td>Globalni minimum</td><td>"+
                    
                    response.minimumValue+
                    "</td></tr>"+
                    
                
                "</table>").appendTo('.container');

                for(i=0;i<response.minimumPosition.length;i++){
                    $("<tr><td>Coordinate No." + i + "</td>"+
                    "<td>"+response.minimumPosition[i]+"</td></tr>").appendTo('#tbody')
                }

            },
            error: function(error){
                console.log("Greska");
            }
        });


    });


});
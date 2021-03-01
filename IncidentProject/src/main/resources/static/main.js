//$(document).ready(function () {


/*$("#search-form").submit(function (event) {

    //stop submit the form, we will post it manually.
    event.preventDefault();

    fire_ajax_submit();

});*/

//});

window.addEventListener('load', function (){

    getAllIncidents();
});

function refreashTable(){

    getAllIncidents();
}

function getAllIncidents(){

    fetch("getIncidents",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "get"

        })
        .then(response => response.json())
        .then( function (data){
            let  a = "<table class=\"table table-success table-striped\"><tr><th>id</th><th>Repoted-by</th><th>Incident Details</th><th>Impact Type</th><th>Other Details</th><th>Ticket Status</th><th>actions</th></tr>";


            for (var i = 0; i < data.length; i++){
                a += `<tr><td>${data[i].id}</td><td>${data[i].userName}</td><td>${data[i].incidentDetails}</td><td>${data[i].impactType}</td><td>${data[i].otherDetails}</td><td>${data[i].incidentStatus}</td><td><a href="#" onclick="editIncident(${data[i].id})">edit</a></td></tr>`
            }

            a+="</table>";
            document.getElementById('pro12').innerHTML=a;
        } )
}

function  editIncident(id){
    $('#editModal').modal('show');
    document.getElementById('editIncidentId').value=id;
}

function  editIncidentForm(){
    let statusId = document.getElementById('statusTypeId').value;
    let incidentDetailsId = document.getElementById('editIncidentId').value;

    if(statusId!='' && incidentDetailsId!=''){

        fetch("updateIncidentStatus",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "post",
                body: JSON.stringify({'id':incidentDetailsId , 'statusTypeId':statusId})

            })
            .then(response => response)
            .then(data => {
                $('#editModal').modal('hide');
                document.getElementById('editIncidentId').value='';
                getAllIncidents();
                }
            );


    }
}

function createIncidentForm() {
    let username = document.getElementById('username').value;
    let incidentDetails = document.getElementById('incidentDetails').value;
    let impactType = document.getElementById('impactType').value;
    let otherDetails = document.getElementById('otherDetails').value;

    if(username!='' && incidentDetails!='' && impactType !='' && otherDetails!=''){

        fetch("createIncident",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "post",
                body: JSON.stringify({
                    "userName": username,
                    "incidentDetails": incidentDetails,
                    "impactType": impactType,
                    "otherDetails": otherDetails
                })

            })
            .then(response => response)
            .then(data => {
                $('#exampleModal').modal('hide');
                getAllIncidents();

                document.getElementById('username').value='';
                document.getElementById('incidentDetails').value='';
                document.getElementById('impactType').value='';
                document.getElementById('otherDetails').value='';
                }
            );

    }
}

function emailGetDetails(){

    $('#emailModal').modal('show');

    fetch("email",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "get"

        })
        .then(response => response.json())
        .then(data=>{
            document.getElementById('emailUsername').value=data.emailFrom;
            document.getElementById('emailPassword').value=data.emailPassword;
            document.getElementById('emailToAddress').value=data.emialTo;
            document.getElementById('emailId').value=data.emailId;
        })
}

function emailSaveForm() {
    let emailUserName = document.getElementById('emailUsername').value;
    let emailPW = document.getElementById('emailPassword').value;
    let emailTo = document.getElementById('emailToAddress').value;
    let emailId = document.getElementById('emailId').value;

    if(emailId != '' && emailUserName!='' && emailPW!='' && emailTo !=''){

        fetch("emailUpdate",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "post",
                body: JSON.stringify({
                    "emailFrom": emailUserName,
                    "emailPassword": emailPW,
                    "emialTo": emailTo,
                    "emailId": emailId
                })

            })
            .then(response => response)
            .then(data => {
                    $('#emailModal').modal('hide');
                    getAllIncidents();
                }
            );

    }
}



/*
function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}
*/

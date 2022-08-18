// test
$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListAccounts() {
    $(".main").load("viewlistaccounts.html");
    // debugger;
    buildTable();
}

var accounts = [];

function Account(id, email, username, firstName, lastName,
                 departmentName, positionName, salaryName, createDate, role) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentName = departmentName;
    this.positionName = positionName;
    this.salaryName = salaryName;
    this.createDate = createDate;
    this.role = role;
}

function getListAccounts() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/accounts",
        dataType: "json",
        success: function (response) {
            //Chuyển đối response => listAccount
            accounts =[];
            // function Account(id, email, username, firstName, lastName,
            //                  departmentName, positionName, salaryName, createDate, role) {
            response.content.forEach(element => {
                let account = {
                    id: element.id,
                    email: element.email,
                    username: element.username,
                    firstName: element.firstName,
                    lastName: element.lastName,
                    departmentName: element.departmentName,
                    positionName: element.positionName,
                    salaryName: element.salaryName,
                    createDate: element.createDate,
                    role: element.role,
                };
                console.log(account);
                accounts.push(account);
            });
            fillAccountToTable();
        }
    });
    // // call API from server
    // $.get("http://localhost:8080/api/v1/accounts", function(data, status) {
    //
    //     // reset list accounts
    //     accounts = [];
    //
    //     // error
    //     if (status == "error") {
    //         // TODO
    //         alert("Error when loading data");
    //         return;
    //     }
    //
    //     // success
    //     console.log(data);
    //     parseData(data);
    //     fillAccountToTable();
    // });
}

function parseData(data) {
    accounts = data;

    // data.forEach(function(item) {
    //     accounts.push(new Account(item.id, item.name));
    // });
}

function fillAccountToTable() {
    accounts.forEach(function(item) {
        $('tbody').append(

            '<tr>' +
            '<td>' + item.id + '</td>' +
            '<td>' + item.email + '</td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.firstName + '</td>' +
            '<td>' + item.lastName + '</td>' +
            '<td>' + item.departmentName + '</td>' +
            '<td>' + item.positionName + '</td>' +
            '<td>' + item.salaryName + '</td>' +
            '<td>' + item.createDate + '</td>' +
            '<td>' + item.role + '</td>' +

            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListAccounts();
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addAccount() {

    // get data
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var account = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts',
        type: 'POST',
        data: JSON.stringify(account), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function(data, textStatus, xhr) {
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openUpdateModal(id) {

    // get index from account's id
    var index = accounts.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = accounts[index].id;
    document.getElementById("name").value = accounts[index].name;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addAccount();
    } else {
        updateAccount();
    }
}

function updateAccount() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    // TODO validate
    // then fail validate ==> return;

    var account = {
        name: name
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'PUT',
        data: JSON.stringify(account),
        contentType: "application/json",
        success: function(result) {
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from account's id
    var index = accounts.findIndex(x => x.id == id);
    var name = accounts[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteAccount(id);
    }
}

function deleteAccount(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'DELETE',
        success: function(result) {
            // success
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}
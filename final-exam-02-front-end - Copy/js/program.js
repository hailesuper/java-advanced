var SIZE = 3;
var currentPage = 1;
var isAsc = false;
var currentFieldName = "id";
var oldName;
const groupNameRegex = /^[a-zA-Z0-9\s]{6,30}$/;

function isLogin() {
    var username = storage.getItem("USERNAME");
    return username ? true : false;
}

// $(document).ready( function() {
//     $('#datePicker').val(new Date().toDateInputValue());
// });

$(function () {
    if (!isLogin()) {
        window.location.href = "http://localhost:5502/html/login.html";
    }
    $(".header").load("header.html", function () {
        document.getElementById("fullName").innerHTML = storage.getItem("FULLNAME");
    });
    $(".menu-left").load("menu-left.html");
    $(".main").load("home.html");

    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListGroups() {
    $(".main").load("viewlistgroups.html", function () {
        buildTable();
    });
}

var groups = [];

function Group(id, name, totalMember, creator, createDate) {
    this.id = id;
    this.name = name;
    this.totalMember = totalMember;
    this.creator = creator;
    this.createDate = createDate;
}

function getListGroups() {
    // call API from server
    var url = "http://localhost:8080/api/v1/groups";
    var search = document.getElementById("searchInput").value;

    url += "?page=" + currentPage + "&size=" + SIZE;

    url += "&sort=" + currentFieldName + "," + (isAsc ? 'ASC' : 'DESC');

    if (search != null && search != undefined && search.length != 0) {
        url += "&search=" + search;
    }

    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json", // type of body (json, xml, text)
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // reset list groups
            groups = [];

            // error
            if (status == "error") {
                // TODO
                alert("Error when loading data");
                return;
            }

            // success
            groups = data.content;
            fillGroupToTable();
            renderPaging(data.totalPages);
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function renderPaging(totalPages) {
    $('#pagination').empty();
    for (let index = 1; index <= totalPages; index++) {
        $('#pagination').append(
            '<li class="page-item">' +
            '<a class="page-link" onClick="onClickPage(' + index + ')">' + index + '</a>' +
            '</li>'
        );
    }
}

function onClickPage(page) {
    if (currentPage == page) {
        return;
    }
    currentPage = page;
    buildTable();
}

function fillGroupToTable() {

    // add delete button
    if (storage.getItem("ROLE") != "USER") {
        document.getElementById("addButton").style.display = "block";
        document.getElementById("deleteButton").style.display = "block";
    } else {
        document.getElementById("addButton").style.display = "none";
        document.getElementById("deleteButton").style.display = "none";
    }

    // heading
    $('#table-heading').empty();
    var strHeading = "";

    if (storage.getItem("ROLE") != "USER") {
        strHeading += '<th><input id="checkbox-total" type="checkbox" onclick="changeCheckboxTotal()"/></th>';
    }

    strHeading += "<th onclick='onSort(\"id\")'>Id</th>";
    strHeading += "<th onclick='onSort(\"name\")'>Name</th>";
    strHeading += "<th onclick='onSort(\"totalMember\")'>Member</th>";
    strHeading += "<th onclick='onSort(\"creator\")'>Creator</th>";
    strHeading += "<th onclick='onSort(\"createDate\")'>Created Date</th>";


    if (storage.getItem("ROLE") != "USER") {
        strHeading += "<th>Actions</th>";
    }

    $('#table-heading').append(strHeading);

    // body
    groups.forEach(function (item, index) {
        var str = "";
        str += '<tr>';


        if (storage.getItem("ROLE") != "USER") {
            str += '<td><input id="checkbox-' + index + '" value="' + item.id + '" type="checkbox" /></td>';
        }

        str +=
            '<td>' + item.id + '</td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.totalMember + '</td>' +
            '<td>' + item.creator.fullName + '</td>' +
            '<td>' + item.createDate + '</td>'
        ;

        if (storage.getItem("ROLE") != "USER") {
            str +=
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                '</td>';
        }
        str += '</tr>';
        $('tbody').append(str);
    });
}

function buildTable() {
    $('tbody').empty();
    getListGroups();
}

function onClickSearchButton() {
    resetPaging();
    resetSorting();
    // get list
    buildTable();
}

function resetSearch() {
    document.getElementById("searchInput").value = "";
}

function resetPaging() {
    currentPage = 1;
}

function resetFilter() {
}

function resetCreateDate() {
    document.getElementById("createDate").value = "";
}

function resetSorting() {
    isAsc = false;
    currentFieldName = "id";
}

function onSort(fieldName) {
    if (currentFieldName != fieldName) {
        isAsc = true;
        currentFieldName = fieldName;
    } else {
        isAsc = !isAsc;
    }

    buildTable();
}

function openAddModal() {
    resetForm();
    openModal();
    document.getElementById("modal-title").innerHTML = "Add New Group";
    document.getElementById("addModal").style.display = "block";

}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("error-message").style.display = "none";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function showMessageErrorValidate(message) {
    document.getElementById("error-message").style.display = "block";
    document.getElementById("error-message").innerHTML = message;
}

function addGroup() {

    // get data
    let name = document.getElementById("name").value;
    let totalMember = document.getElementById("totalMember").value;
    let createDate = document.getElementById("createDate").value;

    let dateEntered = new Date(createDate);

    // validate

    if (!groupNameRegex.test(name)) {
        showMessageErrorValidate("Tên 6-30 ký tự không bao gồm ký tự đặc biệt");
        return;
    }

    if (dateEntered < new Date(2000, 1, 1) || dateEntered > Date.now()) {
        showMessageErrorValidate("Ngày tạo từ 2000 và nhỏ hơn hôm nay");
        return;
    }

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/name/' + name,
        type: 'GET',
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            if (!data) {
                var group = {
                    name: name,
                    totalMember: totalMember,
                    createDate: createDate,
                    creatorId: storage.getItem("ID")
                };
                $.ajax({
                    url: 'http://localhost:8080/api/v1/groups',
                    type: 'POST',
                    data: JSON.stringify(group), // body
                    contentType: "application/json", // type of body (json, xml, text)
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", "Basic " + btoa(
                            storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                    },
                    // dataType: 'json', // datatype return
                    success: function (data, textStatus, xhr) {
                        hideModal();
                        showSuccessAlert();
                        resetSearch();
                        resetPaging();
                        resetSorting();
                        resetFilter();
                        resetCreateDate();
                        buildTable();
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            } else {
                showMessageErrorValidate("Tên không được trùng");
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://localhost:5502/html/forbidden.html";
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}


function openUpdateModal(id) {
    resetForm();


    // get index from group's id
    var index = groups.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = groups[index].id;
    document.getElementById("name").value = groups[index].name;
    oldName = groups[index].name;
    openModal();
    document.getElementById("modal-title").innerHTML = "Update Group Name";
    document.getElementById("addModal").style.display = "none";


}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addGroup();
    } else {
        updateGroup();
    }
}

function updateGroup() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    if (name == oldName) {
        // success
        hideModal();
        showSuccessAlert();
        resetSearch();
        resetPaging();
        resetSorting();
        resetFilter();
        buildTable();
    } else {

        // validate
        if (!groupNameRegex.test(name)) {
            showMessageErrorValidate("Tên 6-30 ký tự không bao gồm ký tự đặc biệt");
            return;
        }


        $.ajax({
            url: 'http://localhost:8080/api/v1/groups/name/' + name,
            type: 'GET',
            contentType: "application/json", // type of body (json, xml, text)
            // dataType: 'json', // datatype return
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(
                    storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function (data, textStatus, xhr) {
                if (!data) {
                    var group = {
                        name: name
                    };

                    $.ajax({
                        url: 'http://localhost:8080/api/v1/groups/' + id,
                        type: 'PUT',
                        data: JSON.stringify(group),
                        contentType: "application/json",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                        },
                        success: function (result) {
                            // success
                            hideModal();
                            showSuccessAlert();
                            resetSearch();
                            resetPaging();
                            resetSorting();
                            resetFilter();
                            buildTable();
                        },
                        error(jqXHR, textStatus, errorThrown) {
                            if (jqXHR.status == 403) {
                                window.location.href = "http://localhost:5502/html/forbidden.html";
                            } else {
                                console.log();
                                console.log(textStatus);
                                console.log(errorThrown);
                            }
                        }
                    });
                } else {
                    showMessageErrorValidate("Tên không được trùng");
                }
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }


}


function openConfirmDelete(id) {
    // get index from group's id
    var index = groups.findIndex(x => x.id == id);
    var name = groups[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteGroup(id);
    }
}

function deleteGroup(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(
                storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function (result) {
            // success
            showSuccessAlert();
            resetSearch();
            resetPaging();
            resetSorting();
            resetFilter();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 403) {
                window.location.href = "http://localhost:5502/html/forbidden.html";
            } else {
                console.log();
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

function deleteMultipleGroup() {
    // get id cua nhung o duoc tich
    var ids = [];
    for (let index = 0; index < SIZE; index++) {
        var checkboxInput = document.getElementById("checkbox-" + index);
        if (checkboxInput != null && checkboxInput != undefined) {
            if (checkboxInput.checked) {
                ids.push(checkboxInput.value);
            }
        } else {
            break;
        }
    }

    if (ids.length == 0) {
        alert("Bạn phải chọn ít nhất 1 bản ghi mới xóa được...");
    }

    let checkedGroupNames = [];

    groups.forEach(function(element) {
        let flag = ids.includes(element.id.toString());
        if (flag) {checkedGroupNames.push(element.name)}
    })


    var result = confirm("Want to delete groups: " + checkedGroupNames + " ?");
    if (result) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/groups?ids=' + ids.toString(),
            type: 'DELETE',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(
                    storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function (result) {
                // success
                showSuccessAlert();
                resetSearch();
                resetPaging();
                resetSorting();
                resetFilter();
                buildTable();
            },
            error(jqXHR, textStatus, errorThrown) {
                if (jqXHR.status == 403) {
                    window.location.href = "http://localhost:5502/html/forbidden.html";
                } else {
                    console.log();
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            }
        });
    }



    //
    // // goi api
    // $.ajax({
    //     url: 'http://localhost:8080/api/v1/groups?ids=' + ids.toString(),
    //     type: 'DELETE',
    //     beforeSend: function (xhr) {
    //         xhr.setRequestHeader("Authorization", "Basic " + btoa(
    //             storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    //     },
    //     success: function (result) {
    //         // success
    //         showSuccessAlert();
    //         resetSearch();
    //         resetPaging();
    //         resetSorting();
    //         resetFilter();
    //         buildTable();
    //     },
    //     error(jqXHR, textStatus, errorThrown) {
    //         if (jqXHR.status == 403) {
    //             window.location.href = "http://localhost:5502/html/forbidden.html";
    //         } else {
    //             console.log();
    //             console.log(textStatus);
    //             console.log(errorThrown);
    //         }
    //     }
    // });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}

function changeCheckboxTotal() {
    var checkboxTotal = document.getElementById("checkbox-total");

    for (let index = 0; index < SIZE; index++) {
        var checkboxInput = document.getElementById("checkbox-" + index);
        if (checkboxInput != null && checkboxInput != undefined) {
            checkboxInput.checked = checkboxTotal.checked;
        } else {
            break;
        }

    }
}

function logout() {
    window.location.href = "http://localhost:5502/html/login.html";
    // remove storage
    storage.removeItem("ID");
    storage.removeItem("EMAIL");
    storage.removeItem("FIRSTNAME");
    storage.removeItem("LASTNAME");
    storage.removeItem("FULLNAME");
    storage.removeItem("ROLE");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");
}

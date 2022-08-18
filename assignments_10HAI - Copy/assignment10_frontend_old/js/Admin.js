var listAccount =[];
let indexUpdateAccount = "";
var listDepartment =[];
var listPosition =[];
// khai bao luu page va size
var currentPage =1;
var currentSize =5;
var totalPage;
//khai bao bien cho sort du lieuj
var sortField="id";
var sortDirectinon = "asc";
//
var search = "";
$(function () {
    //Hàm load dữ liệu API và hiển thị dữ liệu ở table
    fetchListAccountAPI();
    fetchListDepartmentAPI();
    fetchListPositionAPI();
    //Xứ lý sự kiện Reset
    $("#resetBtn").click(function (e) { 
        // e.preventDefault();
        $("#idID").val("");
        $("#EmailID").val("");
        $("#UsernameID").val("");
        $("#FullnameID").val("");
        $("#DepartmentID").val("");
        $("#PositionID").val("");
        $("#CreateDateID").val("");
    });

    //Xử lý sự kiện Save
   $("#FormID").submit(function (e) { 
    //B1:Lấy dữ liệu người dùng nhập:
    var v_idID = $("#idID").val();
    var v_emailID = $("#EmailID").val();
    var v_usernameID = $("#UsernameID").val();
    var v_fullnameID = $("#FullnameID").val();
    var v_departmentID = $("#DepartmentID").val();
    var v_positonID = $("#PositionID").val();
    var v_createDateID = $("#CreateDateID").val(); 

    // Bước 2: Từ dữ liệu người dùng nhập ==> Đối tượng lưu trữ
//     {
//     "Email": "Email 1",
//     "Username": "Username 1",
//     "Fullname": "Fullname 1",
//     "Department": "Department 1",
//     "Positon": "Positon 1",
//     "CreateDate": "CreateDate 1",
//     "AccountID": "1"
//   },
    var account = {
        
      email: v_emailID,
      username: v_usernameID,
      fullname: v_fullnameID,
      departmentId: v_departmentID,
      positionId: v_positonID,
        // CreateDate: v_createDateID,
      };
    //   console.log("account",account);
    //b3: Lưu trữ vào Arr
    // listAccount.push(account)
    // //showaccount
    // showAccount();
    //call API
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/v1/Account",
        data: JSON.stringify(account),
        // dataType: "json",
        contentType: "application/json; charset=UTF-8",
        success: function (response) {
            fetchListAccountAPI();// load lai du lieu
        }
    });
    e.preventDefault();
   });
});
//  Hàm showAccount()
function showAccount() {
    $("#tableBodyId").empty();
    for (let index = 0; index < listAccount.length; index++) {
      $("#tableBodyId").append(
        `<tr>
    <td>${listAccount[index].id}</td>
    <td>${listAccount[index].email}</td>
    <td>${listAccount[index].username}</td>
    <td>${listAccount[index].fullname}</td>
    <td>${listAccount[index].department}</td>
    <td>${listAccount[index].position}</td>
    <td>${listAccount[index].createDate}</td>
    <td>
      <button type="button" class="btn btn-warning" onclick="handleEdit(${index})">Edit</button>
    </td>
    <td>
      <button type="button" class="btn btn-danger" onclick="handleDelete(${index})">Delete</button>
    </td>
    </tr>`
      );
    }
  }

  //  Hàm xóa Account
function handleDelete(index) {
    var Del_Id = listAccount[index].id
    console.log("Del_Id",Del_Id);
    var confimrDel = confirm("Bạn có chắn chắn xóa phần tử này hay không");
    if (confimrDel) {
    //   listAccount.splice(indexDelParam, 1);
  //   $.ajax({
  //     url: "http://localhost:8080/api/v1/Account/"+ Del_Id,
  //     type: 'DELETE',

  //     success: function(result) {
  //         // Do something with the result
  //         fetchListAccountAPI();
  //     }
  // });
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/v1/Account/"+ Del_Id,
    
        // dataType: "json",

        success: function (response) {

            if (response == undefined || response == null) {
                alert("Error when loading data");

                return;
              }
      
              fetchListAccountAPI();
        }
    });

    }
  }

  //  Hàm Edit Account
function handleEdit(indexAccountEdit) {
  // disable truong email,username
    $("#EmailID").attr("disabled", "disabled");
    $("#UsernameID").attr("disabled", "disabled");
    //tim id phong ban theo ten
    var iDep=0
    for (let index = 0; index < listDepartment.length; index++) {
     if (listDepartment[index].name===listAccount[indexAccountEdit].department) {
        iDep=listDepartment[index].id;
     }
      
    }
    $("#idID").val(listAccount[indexAccountEdit].id);
    $("#EmailID").val(listAccount[indexAccountEdit].email);
    $("#UsernameID").val(listAccount[indexAccountEdit].username);
    $("#FullnameID").val(listAccount[indexAccountEdit].fullname);
    $("#DepartmentID").val(listAccount[indexAccountEdit].department);
    $("#PositionID").val(listAccount[indexAccountEdit].position);
    $("#CreateDateID").val(listAccount[indexAccountEdit].createDate);
  
    // indexUpdateAccount = indexAccountEdit;
  }

  $("#UpdateBtn").click(function (e) {
    
    // Lấy lại thông tin người dùng cập nhật
    var v_idID = $("#idID").val();
    var v_emailID = $("#EmailID").val();
    var v_usernameID = $("#UsernameID").val();
    var v_fullnameID = $("#FullnameID").val();
    var v_departmentID = $("#DepartmentID").val();
    var v_positonID = $("#PositionID").val();
    var v_createDateID = $("#CreateDateID").val(); 

    var accountUpdate = {
      fullname: v_fullnameID,
      departmentId: v_departmentID,
      positionId: v_positonID,
    }
    console.log("Clicked Update");
    console.log("v_idID",v_idID);
    console.log("v_departmentID",v_departmentID);
    $.ajax({
      type: "PUT",
      url: "http://localhost:8080/api/v1/Account"+ v_idID,
      data: JSON.stringify(accountUpdate),
      contentType: "application/json; charset=UTF-8",
      success: function (response) {
        fetchListAccountAPI();
      },
    });
    // Set lại dữ liệu trong listAccount
    // listAccount[indexUpdateAccount].id = v_idID;
    // listAccount[indexUpdateAccount].email = v_emailID;
    // listAccount[indexUpdateAccount].username = v_usernameID;
    // listAccount[indexUpdateAccount].fullname = v_fullnameID;
    // listAccount[indexUpdateAccount].department = v_departmentID;
    // listAccount[indexUpdateAccount].position = v_positonID;
    // listAccount[indexUpdateAccount].createDate = v_createDateID;
    // //
    // var account = {
    //     AccountID: listAccount[indexUpdateAccount].id,
    //     Email: listAccount[indexUpdateAccount].email,
    //     Username: listAccount[indexUpdateAccount].username,
    //     Fullname: listAccount[indexUpdateAccount].fullname,
    //     Department: listAccount[indexUpdateAccount].department,
    //     Positon: listAccount[indexUpdateAccount].position,
    //     CreateDate: listAccount[indexUpdateAccount].createDate,
    //   };
    //   $.ajax({
    //       type: "PUT",
    //       url: "https://628aec077886bbbb37ad2f37.mockapi.io/accounts/aip/AccountAPI",
    //       data: account,
    //       dataType: "json",
    //       success: function (response) {
    //         fetchListAccountAPI();
    //       }
    //   });
    showAccount();


  });
  
  
//ham fetchListAccountAPI()
function fetchListAccountAPI(){
// call API
var urlGet = `http://localhost:8080/api/v1/Account?size=${currentSize}&page=${currentPage}&sort=${sortField},${sortDirectinon}&search=${search}`;
$.ajax({
    type: "GET",
    url: urlGet,
    dataType: "json",
    success: function (response) {
        //Chuyển đối response => listAccount
        listAccount =[];
        response.content.forEach(element => {
          var account = {
            id: element.id,
            email: element.email,
            username: element.username,
            fullname: element.fullName,
            department: element.department,
            position: element.position,
            createDate: element.createDate,
          };
          listAccount.push(account);
      });

        showAccount();
        //
        totalPage= response.totalPages;
        
        // 
        generateButtonPaging(totalPage);
    }
});
}
//
function getListEmploye(params) {
    
}

// //du lieu api chuyen ve dang list
// function parseData(data) {
//     data.forEach(function (item)  {
//         var account = {
//             AccountID: item.AccountID,
//             Email: item.Email,
//             Username: item.Username,
//             FullName: item.FullName,
//             Department: item.Department,
//             Position: item.Position,
//             CreateDate: item.CreateDate,
      
//     });
//     listAccount.push(account)
// }
function fetchListDepartmentAPI() {
  //load du lieu api departmnent
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/departments",
    // data: "data",
    dataType: "json",
    success: function (response) {
      console.log("list department:",response);
      //gan du lieu nhan tu API vao listdepartment
      listDepartment = response;
      //hien thi du lieu listdepartment trong the option
      for (let index = 0; index < listDepartment.length; index++) {
        $("#DepartmentID").append(`
            <option value="${listDepartment[index].id}">${listDepartment[index].name}</option>
        `);
        
      }
    }
  });
}

function fetchListPositionAPI() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/possitions",
    // data: "data",
    dataType: "json",
    success: function (response) {
      console.log("list department:",response);
      //gan du lieu nhan tu API vao listdepartment
      listPosition = response;
      //hien thi du lieu listdepartment trong the option
      for (let index = 0; index < listPosition.length; index++) {
        $("#PositionID").append(`
            <option value="${listPosition[index].id}">${listPosition[index].name}</option>
        `);
        
      }
    }
  });
}
//khai bao
//ham xu ly thay doi page
function handleChangepage(page) {
  if (currentPage==page) {
    return;
  }
  currentPage=page;
  fetchListAccountAPI();
}
function generateButtonPaging(totalPageParam) {
  var pagingString = "";
  for (let index = 0; index < totalPageParam; index++) {
    if (currentPage== index + 1) {
      pagingString += `<li class="active"><a  onclick="handleChangepage(${index +1})">${index +1}</a></li>`;
    } else {
      pagingString += `<li><a onclick="handleChangepage(${index +1})">${index +1}</a></li>`;
    }
   
  }
  $(".pagination").empty();
  $(".pagination").append(pagingString);
}

//ham xu ly thay doi Size
function handleChangeSize(selectTag) {
  var sizeParam = selectTag.value;
  if (sizeParam==currentSize) {
    return;
  }
  currentSize = sizeParam;
  fetchListAccountAPI();
}

//ham xu ly thay doi truong sort
function handleChangeSortField(selectTag) {
  var sortFieldParam = selectTag.value;
if (sortFieldParam == sortField) {
  return;
}
  sortField = sortFieldParam;
  fetchListAccountAPI();
}
//ham xu ly thay doi chieu sort
function handleChangeSortDirection(selectTag) {
  var sortDirectionParam = selectTag.value;
if (sortDirectionParam == sortDirectinon) {
  return;
}
  sortDirectinon = sortDirectionParam;
  fetchListAccountAPI();
}

function handlesearch(searchID) {
  // let menusearch = searchinput.value;
  // let menuitems = Array.from();
  // menusearch.value = 
  let searchvalue = $("#searchID").val();
  // searchvalue = search.trim();
  search = searchvalue.trim();
  
  fetchListAccountAPI();
}
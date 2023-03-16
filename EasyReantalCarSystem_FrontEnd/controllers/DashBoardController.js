let loadAllCusForDashBoard = "http://localhost:8080/EasyCarRentalSystem_BackEnd_war_exploded/api/v1/";

loadAllCustomers();

function loadAllCustomers() {
    $("#tblCus").empty();
    $.ajax({
        url: loadAllCusForDashBoard + "customer",
        dataType: "json",
        success: function (res) {
            for (let cus of res.data) {
                var row = '<tr><td>' + cus.customerId + '</td><td>' + cus.name + '</td><td>' + cus.email +
                    '</td><td>' + cus.password + '</td><td>' + cus.contactNo + '</td><td>' + cus.address +
                    '</td><td>' + cus.nicNo + '</td><td>' + cus.drivingLicenseNo + '</td></tr>'
                $("#tblCus").append(row)
            }
        }
    });
}
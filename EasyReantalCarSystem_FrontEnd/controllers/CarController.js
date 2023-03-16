
let baseUrl = "http://localhost:8080/EasyCarRentalSystem_BackEnd_war_exploded/api/v1/";

loadAllCars();

$("#btnAddCar").click(function () {
    let carNo = $("#inputCarNo").val();
    let carBrand = $("#inputBrand").val();
    let carType = $("#inputType").val();
    let carTransmissionType = $("#inputTransmission").val();
    let carFuelType = $("#inputFuelType").val();
    let carColor = $("#inputColor").val();
    let passengers = $("#inputNoPass").val();
    let carDailyRate = $("#inputDailyRate").val();
    let carMonthlyRate = $("#inputMonthlyRate").val();
    let freeKmDaily = $("#inputFreeKmForDay").val();
    let freeKmMonth = $("#inputFreeKmForMonth").val();
    let carPricePerExtra = $("#inputPricePerExtraKm").val();
    let status = $("#inputAvailability").val();
    let frontImageName = $("#frontImg")[0].files[0].name;
    let backImageName = $("#backImg")[0].files[0].name;
    let sideImageName = $("#sideImg")[0].files[0].name;
    let interiorImageName = $("#interiorImg")[0].files[0].name;

    var car = {
        "carRegNo": carNo,
        "brand": carBrand,
        "type": carType,
        "transmissionType": carTransmissionType,
        "fuelType": carFuelType,
        "color": carColor,
        "noOfPassenger": passengers,
        "fontImage": frontImageName,
        "backImage": backImageName,
        "sideImage": sideImageName,
        "interiorImage": interiorImageName,
        "dailyRate": carDailyRate,
        "monthlyRate": carMonthlyRate,
        "freeKmForDaily": freeKmDaily,
        "freeKmForMonth": freeKmMonth,
        "pricePerExtraKm": carPricePerExtra,
        "availability": status
    }

    $.ajax({
        url: baseUrl + "car",
        method: "post",
        data: JSON.stringify(car),
        contentType: "application/json",
        success: function(resp) {
            alert(resp.message);
            loadAllCars();
        },
        error:function(error){
            var jsObject=JSON.parse(error.responseText);
            alert(jsObject.message);
        }
    });
});

$("#btnCarDelete").click(function () {
    let carNo = $("#inputCarNo").val();

    $.ajax({
        url: baseUrl + "car?carRegNo=" + carNo + "",
        method: "delete",
        dataType: "json",
        success: function (res) {
            alert(res.message)
            loadAllCars();
        },
        error: function (err) {
            let cause= JSON.parse(err.responseText).message;
            alert(cause);
        }
    });
});

function loadAllCars() {
    $("#tblCars").empty();
    $.ajax({
        url: baseUrl + "car",
        dataType: "json",
        success: function (res) {
            for (let c of res.data){
                var row = '<tr><td>' + c.carRegNo + '</td><td>' + c.brand + '</td><td>' + c.type + '</td><td>'
                    + c.noOfPassenger + '</td><td>' + c.transmissionType + '</td><td>' + c.fuelType + '</td><td>'
                    + c.color + '</td><td>' + c.dailyRate + '</td><td>' + c.monthlyRate + '</td><td>'
                    + c.freeKmForDaily + '</td><td>' + c.freeKmForMonth + '</td><td>' + c.pricePerExtraKm
                    + '</td><td>' + c.availability +'</td></tr>'
                $("#tblCars").append(row);
            }
            bindRowClickEvent();
        }
    });
}

function bindRowClickEvent() {
    $("#tblCars>tr").click(function () {
        let carNo = $(this).children(":eq(0)").text();
        let carBrand = $(this).children(":eq(1)").text();
        let carType = $(this).children(":eq(2)").text();
        let carTransmissionType = $(this).children(":eq(3)").text();
        let carFuelType = $(this).children(":eq(4)").text();
        let carColor = $(this).children(":eq(5)").text();
        let passengers = $(this).children(":eq(6)").text();
        let carDailyRate = $(this).children(":eq(7)").text();
        let carMonthlyRate = $(this).children(":eq(8)").text();
        let freeKmDaily = $(this).children(":eq(9)").text();
        let freeKmMonth = $(this).children(":eq(10)").text();
        let carPricePerExtra = $(this).children(":eq(11)").text();
        let status = $(this).children(":eq(12)").text();

        $("#inputCarNo").val(carNo);
        $("#inputBrand").val(carBrand);
        $("#inputType").val(carType);
        $("#inputTransmission").val(carTransmissionType);
        $("#inputFuelType").val(carFuelType);
        $("#inputColor").val(carColor);
        $("#inputNoPass").val(passengers);
        $("#inputDailyRate").val(carDailyRate);
        $("#inputMonthlyRate").val(carMonthlyRate);
        $("#inputFreeKmForDay").val(freeKmDaily);
        $("#inputFreeKmForMonth").val(freeKmMonth);
        $("#inputPricePerExtraKm").val(carPricePerExtra);
        $("#inputAvailability").val(status);

    });
}

/*    $("#btnAddCar").click(function () {
        addCar();
    });

    function addCar() {
        var carData = new FormData();

        let frontImageName = $("#frontImg")[0].files[0].name;
        let backImageName = $("#backImg")[0].files[0].name;
        let sideImageName = $("#sideImg")[0].files[0].name;
        let interiorImageName = $("#interiorImg")[0].files[0].name;

        let frontImg = $("#frontImg")[0].files[0];
        let backImg = $("#backImg")[0].files[0];
        let sideImg = $("#sideImg")[0].files[0];
        let interiorImg = $("#interiorImg")[0].files[0];

        let carNo = $("#inputCarNo").val();
        let carBrand = $("#inputBrand").val();
        let carType = $("#inputType").val();
        let carTransmissionType = $("#inputTransmission").val();
        let carFuelType = $("#inputFuelType").val();
        let carColor = $("#inputColor").val();
        let passengers = $("#inputNoPass").val();
        let carDailyRate = $("#inputDailyRate").val();
        let carMonthlyRate = $("#inputMonthlyRate").val();
        let freeKmDaily = $("#inputFreeKmForDay").val();
        let freeKmMonth = $("#inputFreeKmForMonth").val();
        let carPricePerExtra = $("#inputPricePerExtraKm").val();
        let status = $("#inputAvailability").val();
        let img1 = frontImageName;
        let img2 = backImageName;
        let img3 = sideImageName;
        let img4 = interiorImageName;

        var carDTO = {
            "carRegNo": carNo,
            "brand": carBrand,
            "type": carType,
            "transmissionType": carTransmissionType,
            "fuelType": carFuelType,
            "color": carColor,
            "noOfPassenger": passengers,
            "fontImage": "uploads/" + img1,
            "backImage": "uploads/" + img2,
            "sideImage": "uploads/" + img3,
            "interiorImage": "uploads/" + img4,
            "dailyRate": carDailyRate,
            "monthlyRate": carMonthlyRate,
            "freeKmForDaily": freeKmDaily,
            "freeKmForMonth": freeKmMonth,
            "pricePerExtraKm": carPricePerExtra,
            "availability": status
        }

        carData.append("carImgFiles" , frontImg)
        carData.append("carImgFiles" , backImg)
        carData.append("carImgFiles" , sideImg)
        carData.append("carImgFiles" , interiorImg)
        carData.append("car" , new Blob([JSON.stringify(carDTO)], {type: "application/json"}))

        $.ajax({
            url: baseUrl + "car",
            method: "post",
            async: true,
            contentType: false,
            processData: false,
            data: carData,
            success: function(resp) {
                alert(resp.message);
                uploadImages(carNo);
            },
            error:function(error){
                alert(error.responseJSON.message);
                console.log(error);
            }
        });
    }

    function uploadImages(regNo) {
        let frontImg = $("#frontImg")[0].files[0];
        let backImg = $("#backImg")[0].files[0];
        let sideImg = $("#sideImg")[0].files[0];
        let interiorImg = $("#interiorImg")[0].files[0];

        let frontImageName = regNo + "-fontImage-" + $("#frontImg")[0].files[0].name;
        let backImageName = regNo + "-backImage-" + $("#backImg")[0].files[0].name;
        let sideImageName = regNo + "-sideImage-" + $("#sideImg")[0].files[0].name;
        let interiorImageName = regNo + "-interiorImage-" + $("#interiorImg")[0].files[0].name;

        var data = new FormData();

        data.append("fontImage" , frontImg, frontImageName);
        data.append("backImage" , backImg, backImageName);
        data.append("sideImage" , sideImg, sideImageName);
        data.append("interiorImage" , interiorImg, interiorImageName);

        $.ajax({
            url: baseUrl + "car/uploadImg/" + regNo,
            method: "post",
            async: true,
            contentType: false,
            processData: false,
            data: data,
            success: function(resp) {
                alert(resp.message);
            },
            error:function(error){
                var jsObject=JSON.parse(error.responseText);
                alert(jsObject.message);
            }
        });
    }*/
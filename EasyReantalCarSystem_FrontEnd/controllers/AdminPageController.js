$("#btn-admin-home").click(function () {
    $("#admin-dashboard").css("display", "block");
    $("#car-manage").css("display", "none");
});

$("#btn-car-manage").click(function () {
    $("#admin-dashboard").css("display", "none");
    $("#car-manage").css("display", "block");
});
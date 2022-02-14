$(document).ready(function () {
    $(".addnew").click(function () {
        window.location.href = "/addNewFilm"
    })
    $(".delbutton").click(function () {
        $.ajax({
            url: "/api/deleteFilm",
            method: "post",
            dataType: "json",
            data: {"id": this.value},
            success: function (data) {
                window.location.href = "/films"
            }
        })
    })
    $(".edit").click(function () {
        window.location.href = "/edit/" + this.value
    })
})

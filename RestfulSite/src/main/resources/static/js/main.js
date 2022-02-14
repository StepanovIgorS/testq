$(document).ready(function () {
    $("p").click(function () {
        let element = $(this)
         $.ajax({
             url: '/api/rand',
             method: "post",
             dataType: "json",
             success: function (data) {
                 console.log(data.generated_value)
                 element.text(data.generated_value)
             }
         })
    })
})

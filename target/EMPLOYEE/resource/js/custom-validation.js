
$(() => {

    $("#frmEmployee").validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        rules: {
            fullName: {
                required: true,
                minlength: 5,
                maxlength: 50
            } ,
            phone: {
                required: true,
                number: true,
                matches: "[0-9]+",
                minlength: 10,
                maxlength: 11
            },
            email: {
                required: true,
                email: true,
                matches: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
    }

        },
        messages: {

            fullName: {
                required: "Không được để trống trường này",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
            phone: {
                required: "Không được để trống trường này",
                number: "Vui lòng nhập một số hợp lệ",
                minlength: "Hãy nhập ít nhất 10 chữ số",
                maxlength: "Hãy nhập tối đã 11 chữ số"
            },
            email: {
                required: "Không được để trống trường này",
                email: "Vui lòng nhập email hợp lệ",

            }
        },
        submitHandler: function() {
            updateEmployee();
        }
    });
});

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
            },
            email: {
                required: true,
                email: true,

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
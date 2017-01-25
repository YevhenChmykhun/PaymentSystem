$.validator.addMethod(
    "regex",
    function(value, element, regexp)
    {
        if (regexp.constructor != RegExp)
            regexp = new RegExp(regexp);
        else if (regexp.global)
            regexp.lastIndex = 0;
        return this.optional(element) || regexp.test(value);
    },
    "please check your input"
);

$(function () {
    // Initialize form validation on the registration form.
    // It has the name attribute "sign-in"
    $("form[name='sign-in']").validate({
        // Specify validation rules
        rules: {
            phone: {
                required: true,
                regex : /\+380\d{9}/
            },
            password: {
                required: true
            }
        },
        // Specify validation error messages
        messages: {
            phone: {
                required: "validation.required".localize(),
                regex : "validation.phone_number".localize()
            },
            password: {
                required: "validation.required".localize()
            }
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function (form) {
            form.submit();
        }
    });
});

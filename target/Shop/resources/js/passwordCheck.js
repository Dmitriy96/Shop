$(document).ready(function(){
    var pass1;
    var pass2;
    var passwordError = $('#passwordBlock .errorMessage');
    var confirmPasswordError = $('#confirmPasswordBlock .errorMessage');
    $('#password').blur(function () {
        pass1 = $(this).val();
        pass1 = $.trim(pass1);
        if (pass1.length == 0)
        {
            $(passwordError).show();
            $(confirmPasswordError).hide();
            $('#confirmPassword').removeClass('has-success');
            $('#confirmPassword').removeClass('has-error');
            $('#password').removeClass('has-success');
            $('#password').addClass('has-error');
        }
        else
        {
            $(passwordError).hide();
            if (pass2.length != 0 && pass1 == pass2)
            {
                $(confirmPasswordError).hide();
                $('#confirmPassword').removeClass('has-error');
                $('#confirmPassword').addClass('has-success');
                $('#password').removeClass('has-error');
                $('#password').addClass('has-success');
            }
            else
            {
                $(confirmPasswordError).show();
                $('#confirmPassword').removeClass('has-success');
                $('#confirmPassword').addClass('has-error');
                $('#password').removeClass('has-success');
                $('#password').removeClass('has-error');
            }
        }
    });
    $('#confirmPassword').blur(function () {
        pass2 = $(this).val();
        pass2 = $.trim(pass2);
        if (pass2.length == 0 && pass1.length != 0)
        {
            $(confirmPasswordError).show();
            $('#confirmPassword').removeClass('has-success');
            $('#confirmPassword').addClass('has-error');
            $('#password').removeClass('has-success');
            $('#password').removeClass('has-error');
        }
        else
        {
            $(confirmPasswordError).hide();
            if (pass1.length != 0 && pass2.length != 0)
            {
                if (pass1 == pass2)
                {
                    $('#confirmPassword').removeClass('has-error');
                    $('#confirmPassword').addClass('has-success');
                    $('#password').removeClass('has-error');
                    $('#password').addClass('has-success');
                }
                else
                {
                    $(confirmPasswordError).show();
                    $('#confirmPassword').removeClass('has-success');
                    $('#confirmPassword').addClass('has-error');
                    $('#password').removeClass('has-success');
                    $('#password').removeClass('has-error');
                }
            }
        }
    });

    $("#form").submit(function() {
        if (!pass1) {
            $(passwordError).show();
            return false;
        }
        else
        if (!pass2 || pass2 != pass1) {
            $(confirmPasswordError).show();
            return false;
        }
        else return true;
    });
});
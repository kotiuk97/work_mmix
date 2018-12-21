<#macro page>
<!Doctype html>
<html >
    <head>

        <title>Rabota CV</title>
        <meta content="text/html; charset=UTD-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--reCaptcha-->
        <script src='https://www.google.com/recaptcha/api.js'></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body>
    <#include "navbar.ftl">
    <div class="container mt-5">
         <#nested>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <!--script uses to change a label name, if any file was selected-->
    <script type="application/javascript">
        $('.custom-file-input').on('change', function() {
            let fileName = $(this).val().split('\\').pop();
            let label = $(this).siblings('.custom-file-label');

            if (label.data('default-title') === undefined) {
                label.data('default-title', label.html());
            }

            if (fileName === '') {
                label.removeClass("selected").html(label.data('default-title'));
            } else {
                label.addClass("selected").html(fileName);
            }
        });
    </script>
    </body>
</html>

</#macro>
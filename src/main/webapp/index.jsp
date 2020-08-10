<html>
<head>
    <meta charset="UTF-8">
    <title>School Management System</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="style.css" />
    <script type="text/javascript" src="LAB.min.js"></script>
</head>
<body>
    <div>
        <h3>TRACOM ACADEMY - SCHOOL MANAGEMENT SYSTEM</h3>
    </div>
    <div class="topnav">
      <a class="active" href="#home" id="topnav-institutions">INSTITUTIONS</a>
      <a href="#">CAMPUSES</a>
      <a href="#" id="topnav-faculties">FACULTIES</a>
      <a href="#" id="topnav-departments">DEPARTMENTS</a>
      <a href="#" id="topnav-courses">COURSES</a>
      <a href="#" id="topnav-units">UNITS</a>
      <a href="#" id="topnav-students">STUDENTS</a>
      <a href="#" id="topnav-tutors">TUTORS</a>
      <a href="#" id="topnav-users">USERS</a>
      <a href="#">LECTURERS</a>
      <div id="auth-links"> <!-- Set up links depending on whether user is logged in or not --></div>
    </div>
    <div id="content"></div>
</body>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   <script>
        $(function() {
            // Check if a user session exists. Set the links in the navbar accordngly.
            fetch('http://localhost:8080/SchoolMgtSystem/login')
            .then(
                function(response) {
                    if (response.status !== 200) {
                        console.log('Looks like there was a problem. Status Code: ' + response.status);
                        return;
                    }
                    response.json().then(data => {
                        if(data.name != null) {
                            let name = data.name.toUpperCase();
                            let role = data.role.toUpperCase();
                            console.log('A user is logged in');
                            $('#auth-links').html("");
                            $('#auth-links').append('<div id="logout-link"><a href="http://localhost:8080/SchoolMgtSystem/logout" id="">LOGOUT</a></div>');
                            $('#auth-links').append(`<a href="#" id="user-link"> <i class="fa fa-user" aria-hidden="true"></i> ${name} (${role})</a>`);
                        }
                        else {
                            console.log('No user is logged in');
                            $('#auth-links').html("");
                            $('#auth-links').append('<a href="./login/login.html" id="login-link">LOGIN</a>');
                        }
                    });
                }
            )
            .catch(err => console.log('Fetch Error :-S', err));
        });
    </script>
    <script src="app-library.js"></script>
    <script src="links.js"></script>
</body>
</html>

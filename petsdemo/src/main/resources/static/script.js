document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var username = document.getElementById('username');
    var password = document.getElementById('password');
    var usernameError = document.getElementById('usernameError');
    var passwordError = document.getElementById('passwordError');

    usernameError.style.display = 'none';
    passwordError.style.display = 'none';

    if (!validateUsername(username.value)) {
        usernameError.textContent = 'Please enter a valid username.';
        usernameError.style.display = 'block';
        return false;
    }

    if (!validatePassword(password.value)) {
        passwordError.textContent = 'Password must be at least 8 characters long, and include at least one uppercase letter, one lowercase letter, and one number.';
        passwordError.style.display = 'block';
        return false;
    }

    // If validation passes, you can submit the form or perform other actions
    // alert('Form submitted successfully!');
    // return true;
    window.location.href="http://localhost:8080/test";
});

function validateUsername(username) {
    return username.trim() !== '';
}

function validatePassword(password) {
    var re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
    return re.test(String(password));
}

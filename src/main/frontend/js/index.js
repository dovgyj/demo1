import "../css/index.scss";

import jQuery from "jquery";
window.$ = jQuery;
window.jQuery = jQuery;

import Popper from "popper.js";
window.Popper = Popper;

require('bootstrap-material-design');

require("@fortawesome/fontawesome-free");

// window.onload = function () {
//     document.getElementById("password1").onchange = validatePassword;
//     document.getElementById("password2").onchange = validatePassword;
// }
/*function validatePassword(){
    alert("fire");
    var pass2=document.getElementById("password2").value;
    var pass1=document.getElementById("password1").value;
    if(pass1!=pass2)
        document.getElementById("password2").setCustomValidity("Passwords Don't Match");
    else
        document.getElementById("password2").setCustomValidity('');
//empty string means no validation error
}*/

/*var password = document.getElementById("password")
    , confirm_password = document.getElementById("password2");

function validatePassword(){
    if(password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
        confirm_password.setCustomValidity('');
    }
}*/
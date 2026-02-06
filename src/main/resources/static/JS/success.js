/*
function validateForm() {

    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();
	let email = document.getElementById("email").value.trim();

    let successMsg = document.getElementById("successMsg");
    let errorMsg = document.getElementById("errorMsg");

    // hide messages first
    successMsg.style.display = "none";
    errorMsg.style.display = "none";

    // validation
    if (username === "" || password === "" || email==="") {
        errorMsg.style.display = "block";
        return false; // ❌ stop submit
    }

    // if correct
    successMsg.style.display = "block";

    // optional delay before submit
    setTimeout(() => {
        document.getElementById("loginForm").submit();
    }, 1000);

    return false; // prevent double submit
}
*/
function submit(){
	alert("Your form is submited");
}

var show = document.getElementById("nav-links");
function showMenu() {
        show.style.right = "0";
}
function closeMenu() {
        show.style.right = "-200px";
}
function togglePopup2() {
        document.getElementById("popup-2").classList.toggle("active");
}

function togglePopup(index) {
        document.getElementById(index).classList.toggle("active");
}

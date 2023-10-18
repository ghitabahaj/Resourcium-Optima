//
// window.addEventListener('DOMContentLoaded', event => {
//
//     // Navbar shrink function
//     var navbarShrink = function () {
//         const navbarCollapsible = document.body.querySelector('#mainNav');
//         if (!navbarCollapsible) {
//             return;
//         }
//         if (window.scrollY === 0) {
//             navbarCollapsible.classList.remove('navbar-shrink')
//         } else {
//             navbarCollapsible.classList.add('navbar-shrink')
//         }
//
//     };
//
//     navbarShrink();
//
//     // Shrink the navbar when page is scrolled
//     document.addEventListener('scroll', navbarShrink);
//
//     // Activate Bootstrap scrollspy on the main nav element
//     const mainNav = document.body.querySelector('#mainNav');
//     if (mainNav) {
//         new bootstrap.ScrollSpy(document.body, {
//             target: '#mainNav',
//             rootMargin: '0px 0px -40%',
//         });
//     };
//
// });

let sideBar = document.getElementById("wrapper");
let toggleButton = document.getElementById("menu-toggle");

toggleButton.onclick = function () {
    /*if(sideBar.classList.contains("toggled")){
        sideBar.classList.remove("toggled");
        wrapper.style.width("calc(100vw - 17rem)");
    }else{
        sideBar.classList.add("toggled");
        wrapper.style.width("100vw");
    }*/
    sideBar.classList.toggle("toggled");
};

const date = new Date();

let day = date.getDate();
let month = date.getMonth() + 1;
let year = date.getFullYear();

let currentDate = `${day}-${month}-${year}`;
document.getElementById('current-date').innerHTML = currentDate;

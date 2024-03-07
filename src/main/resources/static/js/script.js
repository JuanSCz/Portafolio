const header = document.querySelector("header");
window.addEventListener("scroll", function () {
    header.classList.toggle("sticky", this.window.scrollY > 100);
});

let menu = document.querySelector('#menu-icon');
let navlist = document.querySelector('.navlist');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navlist.classList.toggle('open');
};

window.onscroll = () => {
    menu.classlist.remove('bx-x');
    navlist.classList.remove('open');
};

document.addEventListener('DOMContentLoaded', function () {
    var typed = new Typed("#typed-output", {
        strings: ["Programador Java Backend Jr"],
        typeSpeed: 70,
        backSpeed: 55,
        backDelay: 1000,
        startDelay: 500,
        loop: true
    });
});

document.addEventListener("DOMContentLoaded", function () {
    var links = document.querySelectorAll('header a');

    links.forEach(function (link) {
        link.addEventListener('click', function (e) {
            e.preventDefault();

            var targetId = this.hash.substring(1);
            var targetElement = document.getElementById(targetId);

            if (targetElement) {
                var offset = document.querySelector('header').offsetHeight;
                var targetOffset = targetElement.offsetTop - offset;

                window.scrollTo({
                    top: targetOffset,
                    behavior: 'smooth'
                });
            }
        });
    });
});
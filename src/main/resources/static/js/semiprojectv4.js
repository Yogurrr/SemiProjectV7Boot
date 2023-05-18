// header 로고 클릭 이벤트
let logo = document.querySelector('#logo');
logo.addEventListener('click', () => {
    location.href = '/';
})

// ------------------------------------------ login
const lgnfrm = document.forms.lgnfrm;
const loginbtn = document.querySelector('#loginbtn');
const lgoutbtn = document.querySelector('#lgoutbtn');

loginbtn?.addEventListener('click', () => {
    if (lgnfrm.userid.value === '') alert('아이디를 입력하세요!');
    else if (lgnfrm.passwd.value === '') alert('비밀번호를 입력하세요!');
    else {
        lgnfrm.method = 'post';
        lgnfrm.action = '/login';
        lgnfrm.submit();
    }
})

lgoutbtn?.addEventListener('click', () => {
    location.href = '/logout';
})
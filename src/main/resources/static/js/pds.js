// 새글쓰기
const writebtn = document.querySelector('#writebtn')
writebtn?.addEventListener('click', () => {
    const pdsfrm = document.forms.pdsfrm;
    if (pdsfrm.title.value === '') alert('제목을 작성하세요!');
    else if (pdsfrm.contents.value === '') alert('본문을 작성하세요!');
    else if (grecaptcha.getResponse() === '') alert('자동가입방지를 확인하세요!');
    else {
        pdsfrm.method = 'post';
        pdsfrm.enctype = 'multipart/form-data';
        pdsfrm.submit();
    }
})

// 목록보기
// 새글쓰기 버튼
const go2write = document.querySelector('#go2write')
go2write?.addEventListener('click', () => {
    location.href = '/pds/write';
})

// 목록으로
const go2list = document.querySelector('#go2list')
go2list?.addEventListener('click', () => { location.href = '/pds/list?cpg=1' })
function addToCart(action){//action매개변수는 도서를 장바구니에 추가하기 위한 액션 url을 나타냄
    document.addForm.action = action ;
    document.addForm.submit();//폼을 제출하여 서버에 해당 액션 실행 서버에 장바구니 추가 요청 전송
    alert("도서가 장바구니에 추가되었습니다!");//알림
}

function removeFromCart(action) {
    document.removeForm.action = action;
    document.removeForm.submit();
    window.location.reload();// 도서를 삭제한 후 장바구니 내용이 업데이트 되도록 현재 페이지를 새로고침
}

function clearCart(){
    document.clearForm.submit();
    window.location.reload();
}
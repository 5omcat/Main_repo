<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Footer -->
<footer class="py-5 bg-dark">
	<div class="container">
		<c:if test="${mvo ne null}">
		<div class="btn-group">
			<div class="btn-group">
				<a href="/pay/payment" class="btn btn-primary">결제</a>
			</div>

			<div class="btn-group">
				<a href="/stockscrap/ssmenu" class="btn btn-primary">재고/폐기</a>
			</div>

			<div class="btn-group">
				<a href="/receipt/soldlist?member_id=${mvo.member_id}" class="btn btn-primary">판매조회</a>
			</div>

			<div class="btn-group">
				<a href="/order/ons" class="btn btn-primary">발주관리</a> <a href="#"
					class="btn btn-primary">매출통계</a>
			</div>

			<c:if test="${mvo ne null}">
				<div class="btn-group">
					<a href="/member/logout" class="btn btn-primary">로그아웃</a>
				</div>
			</c:if>
			<c:if test="${mvo eq null}">
				<div class="btn-group">
					<a href="/member/login" class="btn btn-primary">로그인</a>
				</div>
			</c:if>
		</div>
		</c:if>
	</div>
	<!-- /.container -->
</footer>

<script>
	let msg = '<c:out value="${msg}"/>';
	if (msg != '') {
		alert(msg);
	}
	/* let pSign = '<c:out value="${pSign}"/>';
	if (pSign != '') {
	  alert(pSign);
	} */

	$(function() {
		$("#chkid").on("blur", function() {
			console.log('check');
			let idVal = $("#chkid").val();
			$.ajax({
				url : "/member/dupleIdCheck",
				type : "get",
				data : {
					member_id : idVal
				},
				success : function(result) {
					console.log(result);
					if (result > 0) {
						$("#chkId").text("중복된 아이디입니다!").css("color", "#f00");
					} else {
						$("#chkId").text("사용가능한 아이디입니다!").css("color", "#0f0");
					}
				}
			});
		});
		function pwdChk() {
			let pwd = $("#pwd").val();
			let pattern1 = /[0-9]/;
			let pattern2 = /[a-zA-Z]/;
			let pattern3 = /[~!@#$%^&*()_+|<>?:{}]/;
			if (!pattern1.test(pwd) || !pattern2.test(pwd)
					|| !pattern3.test(pwd) || pwd.length < 8) {
				$("#pwdChkR").text("비밀번호 형식에 맞게 입력하세요.").css("color", "#f00");
				//join 비활성화
			} else {
				$("#pwdChkR").text("형식에 알맞은 비밀번호 입니다.").css("color", "#0f0");
				//join 활성화
			}
		}
	});
</script>

</body>

</html>
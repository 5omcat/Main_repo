<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<!-- Content section -->
<section class="py-5">
  <div class="container">
    <h1>회원 가입</h1>
    <form action="/member/join" method="post">
      <div class="form-group">
        <label for="member_id">ID: &nbsp;<span id="chkId"></span></label> <input type="text"
          class="form-control" id="chkid" placeholder="Enter id"
          name="member_id">
      </div>
      <div class="form-group">
        <label for="pwd">Password2:</label> <input type="password"
          class="form-control" id="pwd2" placeholder="Enter password"
          name="member_pwd2">
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label> <input type="password"
          class="form-control" id="pwd" placeholder="Enter password"
          name="member_pwd">
      </div>
      <select name="opt" class="custom-select">
       <option selected>Member type</option>
       <option value="0">가맹점</option>
       <option value="1">가맹주</option>
      </select>
      <button type="submit" class="btn btn-primary">Submit</button>
      <button type="button" class="btn btn-danger" onclick="location.repace('login.jsp')">Cancle</button>
    </form>
  </div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
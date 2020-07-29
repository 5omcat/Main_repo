<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<form action="/member/login" method="post">
  <div class="form-group">
    <label for="id">ID: </label>
    <input type="text" class="form-control" placeholder="Enter id" id="id" name="member_id">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="member_pwd">
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
  <a class="btn btn-warning" href="/member/join">회원가입</a>
</form>

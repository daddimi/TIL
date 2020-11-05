<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="center">
<h1>SHOP Update Page</h1>
<form enctype="multipart/form-data" action="shopupdateimpl.mc" method="post">
ID: ${dbshop.id }<br>
NAME: <input type="text" name="pwd" value="${dbshop.name }"><br>
PRICE: <input type="text" name="name" value="${dbshop.price }"><br>
REGDATE: ${dbshop.regdate }<br>
IMG: ${dbshop.img }<br>
NEWIMG: <input type= "file" name="newimg">
<input type="hidden" name="img" value="${dbshop.img }">
<input type="hidden" name="id" value="${dbshop.id }">
<input type="submit" value="UPDATE">
</form>

</div>
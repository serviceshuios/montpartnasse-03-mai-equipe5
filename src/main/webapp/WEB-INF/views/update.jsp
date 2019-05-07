<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/style"
	href="<%=request.getContextPath()%>/resources/css/style.css">

<title>Association</title>
</head>
<body>
	<h2>CRUD</h2>
	<div>
		<f:form modelAttribute="societeTransport" method="POST" action="updateSave">

			<td>Id de Societe:</td>
			<td><select name="idSociete">
						<optgroup>
								<option value="0">-</option>
								<c:if test="${!empty societeTransports}">
									<c:forEach items="${societeTransports}" var="st"> 
									<option value="${st.idSociete}"><c:out value="${st.nomSociete}"></c:out> </option>
									</c:forEach>
								</c:if>
						</optgroup>
				</select></td>
			<td>
			
			<td>Id de Cargaison:</td>
			<td><select name="idCargaison">
					<optgroup>
								<option value="0">-</option>
								<c:if test="${!empty cargaisons}">
									<c:forEach items="${cargaisons}" var="c"> 
									<option value="${c.idCargaison}"><c:out value="${c.nomCargaison}"></c:out> </option>
									</c:forEach>
								</c:if>
						</optgroup>
				</select></td>
			<td>
			
			<tr>
					<td><input type="submit" value="enregistrer" /></td>
				</tr>
				
		</f:form>
	</div>
	</body>
</html>
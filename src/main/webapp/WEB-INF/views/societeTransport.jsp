<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link rel="stylesheet" type="text/style" href="<%=request.getContextPath()%>/resources/css/style.css"> -->
<link rel="stylesheet" href="resources/css/style.css" />

<title>Sociéte de transport</title>
</head>

<body>
	<h2>CRUD Societe de transport</h2>
	<div>
		<f:form modelAttribute="societeTransport" method="POST" action="saveSociete">
			<table>
				<tr>
					<td><f:hidden path="idSociete"/> </td>
				</tr>
				<tr>
					<td>Nom de la société:</td>
					<td><f:input path="nomSociete" /></td>
					<td><f:errors path="nomSociete" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Numéro Siret:</td>
					<td><f:input path="numSiret" /></td>
					<td><f:errors path="numSiret" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Date de création:</td>
					<td><f:input path="dateCreation" /></td>
					<td><f:errors path="dateCreation" cssClass="error"/></td>
				</tr>
				

				
				<tr>
					<td><input type="submit" value="enregistrer" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	
	<div id="listProduits">
		<table class="table1">
			<tr>
				<th>ID</th>
				<th>Nom de la société:</th>
				<th>Numéro Siret:</th>
				<th>Date de création:</th>
				<th>SUPPRIMER</th>
				<th>MODIFIER</th>
		<!-- 	<th>Nom de la cargaison:</th> -->
				
			</tr>
			<c:forEach var="st" items="${societeTransports}">
				<tr>
					<td>${st.idSociete}</td>
					<td>${st.nomSociete}</td>
					<td>${st.numSiret}</td>
					<td>${st.dateCreation}</td>
					<td><a href="deleteSociete?idSociete=${st.idSociete}">supprimer</a></td>  <!-- ?id vient de la classe Societe -->
					<td><a href="editSociete?idSociete=${st.idSociete}">editer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
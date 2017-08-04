<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste des voyages </title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
<div class="container">
<h2> Liste des voyages</h2>
<table class="table table-stripped">
<thead> 

	<tr>
		<th> LIBELLE </th>
		<th> DESTINATION </th>
		<th> PRIX </th>
		<th> PASSEPORT </th>
		<th> AGENCE </th>
		<th> ACTIONS </th>
		

	</tr>
</thead>
<tbody>

		<s:iterator value="voyages">
			<tr>
				<td><s:property value="libelle"/></td>
				<td><s:property value="destination"/></td>
				<td><s:property value="prix"/></td> 
				<td><s:property value="passeport"/></td>
				<td><s:property value="agence.nom"/></td>
				<td>
					<s:form action="edit" method="get" theme="simple">
						<s:hidden name="id" />
						<s:submit value="editer" class="btn btn-warning btn-block" />
					</s:form>
						<s:form action="delete" method="post" theme="simple">
						<s:hidden name="id" />
						<s:submit value="supprimer" class="btn btn-danger btn-block" />
					</s:form>
									
				</td>
			</tr>
			</s:iterator>
	
</tbody>
</table>

	<s:form action="create" methode="post" theme="simple">
	  		<s:submit class="btn btn-success" value= "creation voyageur"/>
	 </s:form>
</div>
</body>
</html>
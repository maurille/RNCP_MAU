<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:url action="" var="baseurl" />
<link href="<s:property value='baseurl'/>vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<title>liste des auteurs</title>

<style type="text/css">
	.erreur_saisie {
		background-color: pink;
	}
</style>
</head>
<body>
<div class="container">
	<h2>edition d'un auteur</h2>
	<s:form action="save" method="post" theme="simple">
		<s:if test="hasFieldErrors() || hasActionErrors()">
			<div class="alert alert-danger" role="alert">
				<s:actionerror />
				<s:fielderror  />
			</div>
		</s:if>
		<s:hidden name="id"/>
		<div class="input-group">
			<span class="input-group-addon" id="nom_addon">Nom</span>
			<s:textfield name="nom"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="nom_addon" />
		</div>
	
		<div class="input-group">
			<span class="input-group-addon" id="prenom_addon">prenom</span>
			<s:textfield name="prenom"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="prenom_addon" />
		</div>
		
				<div class="input-group">
			<span class="input-group-addon" id="email_addon">email</span>
			<s:textfield name="email"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="email_addon" />
		</div>

		<s:submit value="sauver" cssClass="btn btn-success" />
	</s:form>
</div>
</body>
</html>
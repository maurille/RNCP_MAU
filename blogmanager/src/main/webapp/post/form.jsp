<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:url action="" var="baseurl" />
<link href="<s:property value='baseurl'/>vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<title>les posts info et maths</title>

<style type="text/css">
	.erreur_saisie {
		background-color: PaleTurquoise;
	}
</style>
</head>
<body>
<div class="container">
	<h2>edition d'un post</h2>
	<s:form action="save" method="post" theme="simple">
		<s:if test="hasFieldErrors() || hasActionErrors()">
			<div class="alert alert-danger" role="alert">
				<s:actionerror />
				<s:fielderror  />
			</div>
		</s:if>
		<s:hidden name="id"/>
		<div class="input-group">
			<span class="input-group-addon" id="titre_addon">titre post</span>
			<s:textfield name="titre"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="titre_addon" />
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="corps_addon">corps du post</span>
			<s:textarea name="corps" cols="20" rows="5"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="corps_addon" />
		</div>
				
		<div class="input-group">
			<span class="input-group-addon" id="auteurId_addon">l'auteur du post</span>
			<s:select list="auteurs"
					  listKey="id"
					  listValue="nom"
					  name="auteurId"
					  aria-describedby="auteurId_addon"
					  cssClass="form-control" />
		</div>
		
		<s:submit value="sauver" cssClass="btn btn-success" />
	</s:form>
</div>
</body>
</html>
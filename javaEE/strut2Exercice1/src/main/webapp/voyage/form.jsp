<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url action="/" var="baserl"/>
<base href="%{baseurL}"/>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<title>les voyages </title>
<style type="text/css">
	.erreur_saisie{
	background-color: pink;
	}
</style>	
</head>
<body>
<div class="container"> 
<h2> edition voyage </h2>
<s:form action ="save" method="post" theme="simple">
	<s:if test=" hasFieldErrors()"> 
		<div class="alert alert-danger" role="alert">
			<s:fielderror/>
		</div>
	</s:if>
	<s:hidden name="id"/>
	
	<div class="input-group">
			<span class="input-group-addon" id="libelle_addon">libelle voyage</span>
			<s:textfield name="libelle"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="libelle_addon" />
	</div>
		
	<div class="input-group">
			<span class="input-group-addon" id="destination_addon">destination voyage</span>
			<s:textfield name="destination"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="destination_addon" />
	</div>
		
	<div class="input-group">
		<span class="input-group-addon" id="prix_addon">prix du voyage</span>
		<s:textfield name="prix"
						 cssClass="form-control"
						 cssErrorClass="erreur_saisie"
						 aria-describedby="prix_addon" />
	</div>
	<div class="input-group">
			<span class="input-group-addon" id="agenceId_addon">agence de voyage</span>
			<s:select 
				list="agences" 
				listKey="id" 
				listValue="nom" 
				name="agenceId"
				cssClass="form-control"
				cssErrorClass="erreur_saisie"
				aria-describedby="agenceId_addon" />		
	</div>
	
	<div class="input-group">
			
		<s:checkbox name="passeport"
					cssClass="form-control"
					cssErrorClass="erreur_saisie"
					aria-describedby="passeport_addon" />
		<span class="input-group-addon" id="passeport_addon">passeport requis?</span>
	</div>
	
	<s:submit value="sauverVoyage" class="btn btn-primary"/>
	</s:form>
</div>
</body>

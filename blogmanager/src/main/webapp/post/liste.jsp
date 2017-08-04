<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> liste des posts</title>
<link href="vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
<div class="container">
	<div class="well">
		<h4> BlogGeek</h4>
	</div>
	  <div class="panel panel-primary">
	  
	  	<s:iterator value="posts">
			<div class="panel-heading">
				<div class="row">
					<div class="col-lg-2">
							<h5> Titre du post: <s:property value="titre"/> </h5>
					</div>
					<div class="col-lg-offset-8 col-lg-2">
					 		<h6> Auteur: <s:property value="auteur.nom"/> </h6>
					</div>					   
				</div>					   
			</div>

			<div class="panel-body">
				<s:property value="corps"/>
			</div>	
			
			<div class="panel-footer">
			
				<div class="row">
					<div class="col-lg-2">
						<small> 
							Rediger par <s:property value="auteur.nom"/> le <s:property value="dateCreation"/>, 
							et modifier le <s:property value="dateEdition"/>
						</small>
					</div>
					<div class="col-lg-offset-8 col-lg-2">
					 	<s:form action="edit" method="get" theme="simple" style="display:inline-block;">
							<s:hidden name="id" />
							<s:submit value="editer" class="btn btn-info btn-block" />
						</s:form>
						<s:form action="delete" method="post" theme="simple" style="display:inline-block;">
								<s:hidden name="id" />
								<s:submit value="supprimer" class="btn btn-danger btn-block" />
						</s:form>
					 </div>
					
				</div>
			</div>
		 </s:iterator>
		</div>


		<div class="row">
					<div class="col-lg-3">
							<s:form action="create" method="get" theme="simple">
								<s:submit value="creation" class="btn btn-success" />
							</s:form>
					</div>
					<div class="col-lg-offset-8 col-lg-2">
					 	<s:form action="create" method="get" theme="simple">
							<s:submit value="ajouter auteur" class="btn btn-success" />
						</s:form>
					 </div>
					
			</div>

	
	
</div>
</body>
</html>
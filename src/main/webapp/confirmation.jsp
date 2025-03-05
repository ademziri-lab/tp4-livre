<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container mt-3">
        <div class="card">
            <div class="card-header bg-success text-white">
                Confirmation de l'ajout
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID:</label>
                    <input readonly type="text" class="form-control" value="${livre.idLivre}" />
                </div>
                <div class="form-group">
                    <label class="control-label">Titre:</label>
                    <input readonly type="text" class="form-control" value="${livre.titre}" />
                </div>
                <div class="form-group">
                    <label class="control-label">Auteur:</label>
                    <input readonly type="text" class="form-control" value="${livre.auteur}" />
                </div>
                <div class="form-group">
                    <label class="control-label">Prix:</label>
                    <input readonly type="text" class="form-control" value="${livre.prix}" />
                </div>
                <div class="form-group">
                    <label class="control-label">Année:</label>
                    <input readonly type="text" class="form-control" value="${livre.annee}" />
                </div>
                <div class="mt-3">
                    <a href="chercher.do?motCle=" class="btn btn-primary">Retour à la liste</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
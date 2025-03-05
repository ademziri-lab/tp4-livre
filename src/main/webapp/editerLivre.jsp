<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un Livre</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container mt-3">
        <div class="card">
            <div class="card-header bg-primary text-white">
                Modification d'un Livre
            </div>
            <div class="card-body">
                <form action="update.do" method="post">
                    <div class="form-group">
                        <label class="control-label">ID:</label>
                        <input readonly type="text" name="id" class="form-control" value="${livre.idLivre}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Titre:</label>
                        <input type="text" name="titre" class="form-control" value="${livre.titre}" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Auteur:</label>
                        <input type="text" name="auteur" class="form-control" value="${livre.auteur}" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Prix:</label>
                        <input type="number" step="0.01" name="prix" class="form-control" value="${livre.prix}" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Année:</label>
                        <input type="number" name="annee" class="form-control" value="${livre.annee}" required />
                    </div>
                    <div class="mt-3">
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
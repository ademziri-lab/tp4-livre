<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Livres</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container mt-3">
        <div class="card">
            <div class="card-header">
                Recherche des Livres
            </div>
            <div class="card-body">
                <form action="chercher.do" method="get" >
                    
                        <label for="motCle" class="mr-2">Mot Clé:</label>
                        <input type="text" name="motCle" id="motCle" value="${model.motCle}"  />
                    
                    <button type="submit" class="btn btn-primary">chercher</button>
                </form>
                
                <table class="table table-striped">
                    
                        <tr>
                            <th>ID</th>
                            <th>Titre</th>
                            <th>Auteur</th>
                            <th>Prix</th>
                            <th>Année</th>
                            <th>Actions</th>
                        </tr>
                    
                    
                        <c:forEach items="${model.livres}" var="l">
                            <tr>
                                <td>${l.idLivre}</td>
                                <td>${l.titre}</td>
                                <td>${l.auteur}</td>
                                <td>${l.prix}</td>
                                <td>${l.annee}</td>
                                <td>
                                    <a onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce livre?')" 
                                       href="supprimer.do?id=${l.idLivre}" 
                                       class="btn ">Supprimer</a>
                                    <a href="editer.do?id=${l.idLivre}" 
                                       class="btn ">Modifier</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
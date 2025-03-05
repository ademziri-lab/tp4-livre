<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion de Bibliothèque</title>

</head>
<body>
        <form action="controleur" method="post">
            <input type="text" name="motCle" value="${modele.motCle}" >
            <input type="submit" value="OK">
        </form>
    
     <table border="1" width="80%"> 
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Prix</th>
            <th>Année</th>
        </tr>
        <c:forEach items="${modele.livres}" var="l">
            <tr>
                <td>${l.idLivre}</td>
                <td>${l.titre}</td>
                <td>${l.auteur}</td>
                <td>${l.prix} DT</td>
                <td>${l.annee}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
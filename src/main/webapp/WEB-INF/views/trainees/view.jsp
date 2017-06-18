<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp">
    <jsp:param name="titre" value="Apprenants"/>
</jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">
                            Liste des apprenants
                            <div class="pull pull-right"><a href="/apprenant/ajouter">Ajouter</a></div>
                        </h4>
                        <p class="category">Apprenants de permis</p>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th><i class="fa fa-cog" aria-hidden="true"></i></th>
                            </thead>
                            <tbody>
                            <c:forEach items="${trainees}" var="item">
                                <tr>
                                    <td>${item.numapprenant}</td>
                                    <td>${item.nomapprenant}</td>
                                    <td>${item.prenomapprenant}</td>
                                    <th>
                                        <a href="/apprenant/editer/${item.numapprenant}">
                                            <i class="fa fa-edit" aria-hidden="true"></i>
                                        </a>
                                        <a href="/apprenant/supprimer/${item.numapprenant}">
                                            <i class="fa fa-trash" aria-hidden="true" style="color:red"></i>
                                        </a>
                                    </th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<jsp:include page="../footer.jsp">
    <jsp:param name="titre" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>
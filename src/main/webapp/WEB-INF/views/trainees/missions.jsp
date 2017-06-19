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
                            Liste des missions du jeu "${game.libellejeu}" de ${trainee.nomapprenant} ${trainee.prenomapprenant}
                        </h4>
                        <p class="category">Cliquez sur la mission pour voir les objectifs</p>
                    </div>

                    <div id="accordion">
                        <c:forEach items="${missions}" var="item">
                            <h3>${item.nummission} - ${item.libmission}</h3>
                            <div>
                                <div class="content table-responsive table-full-width">
                                    <table class="table table-striped">
                                        <thead>
                                        <th>ID</th>
                                        <th>Libelle</th>
                                        <th class="text-center"><i class="fa fa-cog" aria-hidden="true"></i></th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${item.objectives}" var="objective">
                                            <tr>
                                                <td>${objective.numobjectif}</td>
                                                <td>${objective.libobectif}</td>
                                                <th class="text-center">
                                                    <a href="/apprenant/${trainee.numapprenant}/mission/${item.nummission}/objectif/${objective.numobjectif}">
                                                        <button type="button" class="btn btn-success">
                                                            Voir actions
                                                        </button>
                                                    </a>
                                                </th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:forEach>
                    </div>


            </div>

        </div>
    </div>
</div>


<jsp:include page="../footer.jsp">
    <jsp:param name="titre" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>
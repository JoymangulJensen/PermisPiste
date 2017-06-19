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
                        <h4 class="title">Objectif - ${objective.libobectif}</h4>
                        <p class="category">Liste des actions de ${trainee.nomapprenant} ${trainee.prenomapprenant} </p>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Libellé</th>
                            <th class="text-center"><i class="fa fa-cog" aria-hidden="true"></i></th>
                            <th class="text-center">Score</th>
                            </thead>
                            <tbody>
                            <c:set var = "greyNext" value = 'false'/>
                            <c:forEach items="${objective.actions}" var="item">
                                <tr>
                                    <td>${item.numaction}</td>
                                    <td>${item.libaction}</td>
                                    <td class="text-center">
                                        <c:if test="${greyNext == 'false'}">
                                            <a href="/apprenant/${trainee.numapprenant}/mission/${mission.nummission}/objectif/${objective.numobjectif}/action/${item.numaction}/realiser">
                                                <button type="button" class="btn btn-primary">Réaliser l'action</button>
                                            </a>
                                        </c:if>
                                        <c:if test="${greyNext == 'true'}">
                                            <a href="#">
                                                <button type="button" class="btn btn-primary disabled">Réaliser l'action</button>
                                            </a>
                                        </c:if>
                                    </td>
                                    <td class="text-center">
                                        <c:if test="${item.value == -1}">
                                            <%-- On a pas répondu --%>
                                            <c:set var = "greyNext" value = "true"/>
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </c:if>

                                        <c:if test="${item.value < item.scoremin && item.value != -1}">
                                            <%-- On a répondu et on a pas suffisament --%>
                                            <c:set var = "greyNext" value = "true"/>
                                            <p style="color: red">${item.value} / ${item.scoremin}</p>
                                        </c:if>

                                        <c:if test="${item.value >= item.scoremin}">
                                            <p style="color: green">${item.value} / ${item.scoremin}</p>
                                        </c:if>


                                    </td>
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
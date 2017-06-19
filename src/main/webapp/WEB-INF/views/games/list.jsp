<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp">
    <jsp:param name="titre" value="Jeux"/>
</jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">
                            Liste des jeux
                            <div class="pull pull-right">
                                <button type="button" class="btn btn-success"><a href="/game/ajouter">Ajouter</a></button>
                            </div>
                        </h4>
                        <p class="category">Jeux </p>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Libelle</th>
                            <th class="text-center"><i class="fa fa-cog" aria-hidden="true"></i></th>
                            </thead>
                            <tbody>
                            <c:forEach items="${games}" var="item">
                                <tr>
                                    <td>${item.numjeu}</td>
                                    <td>${item.libellejeu}</td>
                                    <th class="text-center">
                                        <a href="/game/editer/${item.numjeu}">
                                            <button type="button" class="btn btn-success">
                                                <i class="fa fa-edit" aria-hidden="true"></i>
                                            </button>
                                        </a>
                                        <%--<a href="/game/supprimer/${item.numjeu}">--%>
                                            <%--<button type="button" class="btn btn-danger">--%>
                                                <%--<i class="fa fa-trash" aria-hidden="true" style="color:red"></i>--%>
                                            <%--</button>--%>
                                        <%--</a>--%>
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
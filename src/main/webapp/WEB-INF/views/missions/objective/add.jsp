<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp">
    <jsp:param name="titre" value="Missions"/>
</jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Ajouter une mission</h4>
                        <br/>
                        <form class="form-horizontal" method="post" action="/objectif/ajouter/${item.nummission}">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="game_id">Jeu : </label>
                                <div class="col-sm-10">
                                    <select id="game_id" name="game_id" class="form-control">
                                        <option value="NONE">Choisir objectif</option>
                                        <c:forEach items="${objectives}" var="item">
                                            <option value="${item.numobjectif}">${item.libobectif}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Valider</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<jsp:include page="../../footer.jsp">
    <jsp:param name="titre" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp">
    <jsp:param name="titre" value="Actions"/>
</jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Modifier une action</h4>
                        <br/>
                        <form class="form-horizontal" method="post" action="/action/editer/${action.numaction}">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="label">Libellé :</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="label" name="label" placeholder="Entrez le libellé de l'action" value="${action.libaction}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="label">Score Minimum :</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="scoremin" name="scoremin" placeholder="Entrez le score minimum pour réussir l'action" value="${action.scoremin}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="action_id">Action à réussir précedemment : </label>
                                <div class="col-sm-10">
                                    <select id="action_id" name="action_id" class="form-control">
                                        <option value="NONE">Choisir une action</option>
                                        <c:forEach items="${actions}" var="item">
                                            <c:if test="${item.numaction == action.actionByActNumaction.numaction}">
                                                <option selected value="${item.numaction}">${item.libaction}</option>
                                            </c:if>
                                            <c:if test="${item.numaction != action.actionByActNumaction.numaction}">
                                                <option value="${item.numaction}">${item.libaction}</option>
                                            </c:if>
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


<jsp:include page="../footer.jsp">
    <jsp:param name="titre" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>
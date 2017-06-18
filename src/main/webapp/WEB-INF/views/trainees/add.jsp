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
                        <h4 class="title">Ajouter un apprenant</h4>
                        <br/>
                        <form class="form-horizontal" method="post" action="/apprenant/ajouter">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="name">Nom :</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Entrer votre nom">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="firstname">Prénom : </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Entrer votre prénom">
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
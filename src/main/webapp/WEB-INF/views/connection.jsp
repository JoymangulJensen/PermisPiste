<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="header.jsp">
    <jsp:param name="titre" value="Connexion"/>
</jsp:include>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <br/>
                        <form class="form-horizontal"  onsubmit="error();">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="label">Nom d'utilisateur :</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="label" name="label" placeholder="Entrez votre nom d'utilisateur">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="label">Mot de passe :</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Entrez votre mot de pass">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button  type="submit" value="Submit" class="btn btn-default">Valider</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<jsp:include page="footer.jsp">
    <jsp:param name="titre" value="Expo : Médiathèque De POLYTECH"/>
</jsp:include>
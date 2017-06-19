<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Paper Dashboard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <!-- Bootstrap core CSS     -->
    <spring:url value="/resources/assets/css/bootstrap.min.css" var="bootstrapMinCss"/>
    <link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="/resources/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="/resources/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <spring:url value="/resources/css/demo.css" var="demoCss"/>
    <link href="${demoCss}" rel="stylesheet"/>
    <link href="/resources/assets/css/themify-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-background-color="black" data-active-color="info">

        <!--
            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
        -->

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="/" class="simple-text">
                    <img src="${pageContext.request.contextPath}/resources/assets/img/logo.png" width="230"/>
                </a>
            </div>

            <ul class="nav">
                <c:choose>
                    <c:when test="${param.titre=='Accueil'}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="/">
                        <i class="ti-home"></i>
                        <p>Accueil</p>
                    </a>
                </li>

                <c:choose>
                    <c:when test="${param.titre=='Missions'}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="/missions">
                        <i class="ti-cup"></i>
                        <p>Missions</p>
                    </a>
                </li>


                <c:choose>
                    <c:when test="${param.titre=='Apprenants'}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="/apprenants">
                        <i class="ti-book"></i>
                        <p>Apprenants</p>
                    </a>
                </li>



                <c:choose>
                    <c:when test="${param.titre=='Jeux'}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="/game/list">
                        <i class="ti-basketball"></i>
                        <p>Jeux</p>
                    </a>
                </li>

                <c:choose>
                    <c:when test="${param.titre=='Actions'}">
                        <li class="active">
                    </c:when>
                    <c:otherwise>
                        <li>
                    </c:otherwise>
                </c:choose>
                    <a href="/actions">
                        <i class="ti-briefcase"></i>
                        <p>Actions</p>
                    </a>
                </li>

                    <c:choose>
                    <c:when test="${param.titre=='Objectives'}">
                    <li class="active">
                        </c:when>
                        <c:otherwise>
                    <li>
                        </c:otherwise>
                        </c:choose>
                        <a href="/objectives">
                            <i class="ti-target"></i>
                            <p>Objectifs</p>
                        </a>
                    </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand">${param.titre}</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-bell"></i>
                                <p class="notification">5</p>
                                <p>Parametre</p>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Connexion</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
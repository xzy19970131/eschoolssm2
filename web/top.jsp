<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/8/7
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- topbar starts -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" /> <span>校园交易管理</span></a>

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container" >
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-tint"></i><span class="hidden-phone"> 换肤</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="icon-blank"></i> 经典</a></li>
                    <li><a data-value="cerulean" href="#"><i class="icon-blank"></i> 天蓝</a></li>
                    <li><a data-value="cyborg" href="#"><i class="icon-blank"></i> 酷黑</a></li>
                    <li><a data-value="redy" href="#"><i class="icon-blank"></i> 诱惑红</a></li>
                    <li><a data-value="journal" href="#"><i class="icon-blank"></i> 自由</a></li>
                    <li><a data-value="simplex" href="#"><i class="icon-blank"></i> 简约</a></li>
                    <li><a data-value="slate" href="#"><i class="icon-blank"></i> 岩黑</a></li>
                    <li><a data-value="spacelab" href="#"><i class="icon-blank"></i> 灰色空间</a></li>
                    <li><a data-value="united" href="#"><i class="icon-blank"></i> 橘红</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <!-- user dropdown starts -->
            <div class="btn-group pull-right" >
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i><span class="hidden-phone"> admin</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.jsp">注销</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <div class="top-nav nav-collapse">
                <ul class="nav">
                    <li><a href="#">访问</a></li>
                    <li>
                        <form class="navbar-search pull-left">
                            <input placeholder="Search" class="search-query span2" name="query" type="text">
                        </form>
                    </li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
<!-- topbar ends -->
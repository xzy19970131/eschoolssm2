<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style></style>
    <!--
        Charisma v1.0.0

        Copyright 2012 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
    -->
    <meta charset="utf-8">
    <title>校园交易管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/charisma-app.css" rel="stylesheet">
    <link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
    <link href='css/fullcalendar.css' rel='stylesheet'>
    <link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
    <link href='css/chosen.css' rel='stylesheet'>
    <link href='css/uniform.default.css' rel='stylesheet'>
    <link href='css/colorbox.css' rel='stylesheet'>
    <link href='css/jquery.cleditor.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/opa-icons.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>

<%--上部分top--%>
<c:import url="top.jsp"></c:import>

<div class="container-fluid">
    <div class="row-fluid">
        <%--左边部分left--%>
        <c:import url="left.jsp"></c:import>



        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="span10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="#">用户管理</a> <span class="divider">/</span>
                    </li>
                    <li>
                        <a href="#">普通用户</a>
                    </li>
                </ul>
            </div>

            <div class="row-fluid sortable">
                <div class="box span12">
                    <div class="box-header well">
                        <h2><i class="icon-user"></i> 管理员列表</h2>
                        <div class="box-icon">
                            <a href="#" class="btn btn-setting btn-round">统计</a>
                            <a href="/exportAdmin" class="btn btn-setting btn-round">报表</a>
                            <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
                            <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                            <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
                        </div>
                    </div>
                    <div class="box-content">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active"><a href="#info">管理员</a></li>

                        </ul>

                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane active" id="info">
                                <div class="box-content">
                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                        <thead>
                                        <tr>
                                            <th>管理员编号</th>
                                            <th>用户名</th>
                                            <th>姓名</th>
                                            <th>联系方式</th>
                                            <th>地址</th>
                                            <th>权限</th>
                                            <th>操作</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach  var="t"  items="${allAdmin}" varStatus="s">
                                            <tr>
                                                <td class="center">${t.adminid}</td>
                                                <td class="center">${t.username}</td>
                                                <td class="center">${t.xingming}</td>
                                                <td class="center">${t.phone}</td>
                                                <td class="center">${t.address}</td>
                                                <td class="center">
                                                    <form name="">
                                                        <input type="checkbox" id ="a1"  value="user">用户管理
                                                        <input type="checkbox" id ="a2" value="product">商品管理
                                                        <input type="checkbox"  id ="a3" value="order">商品信息记录管理
                                                        <br>
                                                        <input type="checkbox"  id ="a4" value="news">评论和回复管理
                                                        <input type="checkbox"  id ="a5" value="news">线下集市管理
                                                        <input type="checkbox"  id ="a6" value="news">二手经纪人管理
                                                    </form>
                                                </td>
                                                <td class="center">
                                                    <a class="btn btn-success" href="/deleteAdmin?adminid=${t.adminid}">
                                                        <i class="icon-zoom-in icon-white"></i>
                                                        delete
                                                    </a>
                                                </td>
                                            </tr>

                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="tab-pane" id="custom">
                                <div class="box span6">
                                    <div class="box-header well" data-original-title>
                                        <h2>用户名</h2>
                                    </div>
                                    <div class="box-content">
                                        <div class="pagination pagination-centered">
                                            <ul>
                                                <li><a href="#">Prev</a></li>
                                                <li class="active">
                                                    <a href="#">1</a>
                                                </li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                                <li><a href="#">4</a></li>
                                                <li><a href="#">Next</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/span-->
            </div>
        </div>
    </div>
</div>

                <!-- external javascript
                ================================================== -->
                <!-- Placed at the end of the document so the pages load faster -->

                <!-- jQuery -->
                <script src="js/jquery-1.7.2.min.js"></script>
                <!-- jQuery UI -->
                <script src="js/jquery-ui-1.8.21.custom.min.js"></script>
                <!-- transition / effect library -->
                <script src="js/bootstrap-transition.js"></script>
                <!-- alert enhancer library -->
                <script src="js/bootstrap-alert.js"></script>
                <!-- modal / dialog library -->
                <script src="js/bootstrap-modal.js"></script>
                <!-- custom dropdown library -->
                <script src="js/bootstrap-dropdown.js"></script>
                <!-- scrolspy library -->
                <script src="js/bootstrap-scrollspy.js"></script>
                <!-- library for creating tabs -->
                <script src="js/bootstrap-tab.js"></script>
                <!-- library for advanced tooltip -->
                <script src="js/bootstrap-tooltip.js"></script>
                <!-- popover effect library -->
                <script src="js/bootstrap-popover.js"></script>
                <!-- button enhancer library -->
                <script src="js/bootstrap-button.js"></script>
                <!-- accordion library (optional, not used in demo) -->
                <script src="js/bootstrap-collapse.js"></script>
                <!-- carousel slideshow library (optional, not used in demo) -->
                <script src="js/bootstrap-carousel.js"></script>
                <!-- autocomplete library -->
                <script src="js/bootstrap-typeahead.js"></script>
                <!-- tour library -->
                <script src="js/bootstrap-tour.js"></script>
                <!-- library for cookie management -->
                <script src="js/jquery.cookie.js"></script>
                <!-- calander plugin -->
                <script src='js/fullcalendar.min.js'></script>
                <!-- data table plugin -->
                <script src='js/jquery.dataTables.min.js'></script>

                <!-- chart libraries start -->
                <script src="js/excanvas.js"></script>
                <script src="js/jquery.flot.min.js"></script>
                <script src="js/jquery.flot.pie.min.js"></script>
                <script src="js/jquery.flot.stack.js"></script>
                <script src="js/jquery.flot.resize.min.js"></script>
                <!-- chart libraries end -->

                <!-- select or dropdown enhancer -->
                <script src="js/jquery.chosen.min.js"></script>
                <!-- checkbox, radio, and file input styler -->
                <script src="js/jquery.uniform.min.js"></script>
                <!-- plugin for gallery image view -->
                <script src="js/jquery.colorbox.min.js"></script>
                <!-- rich text editor library -->
                <script src="js/jquery.cleditor.min.js"></script>
                <!-- notification plugin -->
                <script src="js/jquery.noty.js"></script>
                <!-- file manager library -->
                <script src="js/jquery.elfinder.min.js"></script>
                <!-- star rating plugin -->
                <script src="js/jquery.raty.min.js"></script>
                <!-- for iOS style toggle switch -->
                <script src="js/jquery.iphone.toggle.js"></script>
                <!-- autogrowing textarea plugin -->
                <script src="js/jquery.autogrow-textarea.js"></script>
                <!-- multiple file upload plugin -->
                <script src="js/jquery.uploadify-3.1.min.js"></script>
                <!-- history.js for cross-browser state change on ajax -->
                <script src="js/jquery.history.js"></script>
                <!-- application script for Charisma demo -->
                <script src="js/charisma.js"></script>


</body>
</html>

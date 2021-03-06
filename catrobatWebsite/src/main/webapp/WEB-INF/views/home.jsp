<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<%@include file="top-scripts.jspf"%>
<meta charset="utf-8"/>
</head>
<body>
	<%@include file="header.jspf"%>

	<c:choose>
		<c:when test="${programName == null}">
			<div class="hero-unit">
				<h2>Welcome to Catrobat Website!</h2>
				Please, upload your project.
			</div>
		</c:when>
		<c:otherwise>
			<div class="container-fluid">
				<div class="row">
					<div class="span2">
						<div class="well">
							<ul class="nav nav-tabs nav-stacked" id="myTab">
								<li class="active"><a href="#xmlHeader" data-toggle="pill">Header</a></li>

								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#" id="objectName">Object<b
										class="caret pull-right"></b></a>
									<ul class="dropdown-menu">
										<c:forEach var="entry" items="${objects}">
											<li><a href="#${entry.key}" data-toggle="pill">${entry.value.name}</a></li>
										</c:forEach>
									</ul></li>
								<li><a href="#variables" data-toggle="pill">Variables</a></li>

							</ul>
						</div>
					</div>
					<div class="span10">
						<div class="container-fluid well">
							<div class="tab-content">
								<div class="tab-pane active" id="xmlHeader">
									<dl class="dl-horizontal">
										<c:forEach var="entry" items="${xmlHeader}">
											<dt>${entry.key}</dt>
											<dd>${entry.value}</dd>
										</c:forEach>
									</dl>
								</div>

								<c:forEach var="entry" items="${objects}">
									<div class="tab-pane" id="${entry.key}">
										<div class="row-fluid">
											<h3>Name: ${entry.value.name}</h3>
										</div>
										<div class="row-fluid">
											<div class="span12">
												<h4>Looks:</h4>
												<ul class="thumbnails">
													<c:forEach var="look" items="${entry.value.looks}">
														<li><a href="image/${look.value}"><img
																src="image/${look.value}" alt="${look.key}"
																title="${look.value}" class="thumbnail img=rounded"
																height="140px" width="140px"> </a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span12">
												<h4>Sounds:</h4>
												<div class="span6">
													<c:forEach var="sound" items="${entry.value.sounds}">
														<audio controls data-info-att="${sound.key}">
															<source src="sound/${sound.value}" type="audio/mp3" />
															<a href="sound/${sound.value}">${sound.key}</a>
														</audio>
													</c:forEach>
												</div>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span12">
												<h4>Scripts:</h4>
												<pre>${entry.value.code}</pre>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span12">
												<h4>Variables:</h4>
												<ul type="circle">
													<c:forEach var="var" items="${entry.value.variables}">
														<li>${var}</li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</c:forEach>

								<div class="tab-pane" id="variables">
									<ul type="circle">
										<c:forEach var="var" items="${variables}">
											<li>${var}</li>
										</c:forEach>
									</ul>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>




	<%@include file="bottom-scripts.jspf"%>
</body>
</html>

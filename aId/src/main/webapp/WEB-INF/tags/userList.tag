<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="coll" type="java.util.Collection" required="true"%>


<div class="user-table" align="center">

	<table border="1">
		<c:forEach items="${coll}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.dateBirthday}</td>
				<td>${user.email}</td>
				<td>${user.idRole}</td>
				<td>${user.toursNumber}</td>
				
				<c:if test="${loggedInUser.idRole == 5}">
					<td>
						<form action="editTour" method="GET">
							<div style="padding: 2px; margin: 2px">
								<input type="submit" value="EDIT" />
							</div>
						</form> <!-- <button style="padding: 2px; margin: 2px">EDIT</button> -->
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>
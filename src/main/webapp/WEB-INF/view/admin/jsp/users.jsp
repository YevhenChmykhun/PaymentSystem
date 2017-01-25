<section id="users" class="admin-table">
    <table>
        <thead>
        <tr>
            <th>user_id</th>
            <th>phoneNumber</th>
            <th>actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><strong>${user.id}</strong></td>
                <td>${user.phoneNumber}</td>
                <td>
                    <form action="<c:url value='admin'/>" method="post">
                        <input type="hidden" name="command" value="get_user_cards"/>
                        <input type="hidden" name="user_id" value="${user.id}"/>
                        <input type="submit" class="button" value="Show Cards"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

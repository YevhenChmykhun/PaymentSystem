<section id="cards" class="admin-table">
    <table>
        <thead>
        <tr>
            <th>card_id</th>
            <th>number</th>
            <th>validity</th>
            <th>actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="card" items="${cards}">
            <tr>
                <td><strong>${card.id}</strong></td>
                <td>${card.number}</td>
                <td>${card.validity}</td>
                <td>
                    <form action="<c:url value='admin'/>" method="post">
                        <input type="hidden" name="command" value="get_card_account"/>
                        <input type="hidden" name="card_id" value="${card.id}"/>
                        <input type="submit" class="button" value="Account Details"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

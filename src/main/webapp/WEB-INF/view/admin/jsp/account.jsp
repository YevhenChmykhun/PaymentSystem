<section id="account" class="admin-table">
    <%--<table>
        <thead>
        <tr>
            <th>account_id</th>
            <th>balance</th>
            <th>account_type</th>
            <th>account_status</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td><strong>${account.id}</strong></td>
                <td>${account.balance}</td>
                <td>${account.accountType.type}</td>
                <td>${account.accountStatus.status}</td>
                <td>
                    <c:choose>
                        <c:when test="${account.active}">
                            <form action="<c:url value='controller'/>" method="post">
                                <input type="hidden" name="command" value="block_account"/>
                                <input type="hidden" name="account_id" value="${account.id}"/>
                                <input type="hidden" name="next_page" value="<c:url value='controller?command=get_users'/>"/>
                                <input type="submit" class="button" value="Activate"/>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="<c:url value='controller'/>" method="post">
                                <input type="hidden" name="command" value="activate_account"/>
                                <input type="hidden" name="account_id" value="${account.id}"/>
                                <input type="hidden" name="next_page" value="<c:url value='controller?command=get_users'/>"/>
                                <input type="submit" class="button" value="Block"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>--%>
    <div>account_id: ${account.id}</div>
    <div>balance: ${account.balance}</div>
    <div>account_type: ${account.accountType.type}</div>
    <div>account_status: ${account.accountStatus.status}</div>
    <div>action:
        <c:choose>
            <c:when test="${account.active}">
                <form action="<c:url value='admin'/>" method="post">
                    <input type="hidden" name="command" value="block_account"/>
                    <input type="hidden" name="account_id" value="${account.id}"/>
                    <input type="hidden" name="next_page" value="<c:url value='/admin?command=get_card_account&card_id=${card_id}'/>"/>
                    <input type="submit" class="button" value="Block"/>
                </form>
            </c:when>
            <c:otherwise>
                <form action="<c:url value='admin'/>" method="post">
                    <input type="hidden" name="command" value="activate_account"/>
                    <input type="hidden" name="account_id" value="${account.id}"/>
                    <input type="hidden" name="next_page" value="<c:url value='/admin?command=get_card_account&card_id=${card_id}'/>"/>
                    <input type="submit" class="button" value="Activate"/>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</section>

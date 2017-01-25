<section id="active-accounts" class="admin-table">
    <table>
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
                    <form action="<c:url value='admin'/>" method="post">
                        <input type="hidden" name="command" value="block_account"/>
                        <input type="hidden" name="account_id" value="${account.id}"/>
                        <input type="hidden" name="next_page" value="<c:url value="/admin?command=get_active_accounts"/>"/>
                        <input type="submit" class="button" value="Block"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<section id="payments" class="admin-table">
    <table>
        <thead>
        <tr>
            <th>payment_id</th>
            <th>amount</th>
            <th>date</th>
            <th>sender</th>
            <th>recipient</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="payment" items="${payments}">
            <tr>
                <td><strong>${payment.id}</strong></td>
                <td>${payment.amount}</td>
                <td>${payment.date}</td>
                <td>${payment.sender.phoneNumber}</td>
                <td>${payment.recipient.phoneNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 04.11.2018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <title>$Title$</title>
</head>
<body>
<div id="app">

    <tr>
        <th>Название книги</th>
        <th>Автор книги</th>
    </tr>

    <table>
        <tr v-for="book in books">
            <td>{{book.name}}</td>
            <td>{{book.author.fio}}</td>
        </tr>
    </table>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            books: [],
        },
        methods: {
            loadListBook: function () {
                axios({
                    method: 'get',
                    url: '/book',
                }).then(response = > {
                    this.books = response.data;
            })
            }
        },
        created: function () {
            this.loadListBook();
        },

    });
</script>
</html>


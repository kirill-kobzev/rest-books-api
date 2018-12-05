<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="resources/style.css">
    <title>$Title$</title>
</head>
<body>
<div id="app">
    <header>
        <p>Книжная лавка</p>
    </header>
    <div class="main">
        <div class="bookList">
            <table>
                <tr>
                    <th>№</th>
                    <th>Название книги</th>
                    <th>Автор книги</th>
                </tr>

                <tr v-for="book in books">
                    <td>{{book.id}}</td>
                    <td>{{book.name}}</td>
                    <td>{{book.author.fio}}</td>
                </tr>
            </table>
        </div>

        <div class="wishList">
            <table>
                <tr>
                    <th>№</th>
                    <th>Название книги</th>
                    <th>Автор книги</th>
                </tr>

                <tr v-for="wish in wishes">
                    <td>{{wish.book.id}}</td>
                    <td>{{wish.book.name}}</td>
                    <td>{{wish.book.author.fio}}</td>
                </tr>
            </table>
        </div>


    </div>
    <div class="butt">
        <button class="post" v-on:click="addBook()">POST</button>
        <button class="put" v-on:click="updateBook()">PUT</button>
        <button class="delete" v-on:click="deleteBook()">DELETE</button>
    </div>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            books: [],
            wishes: [],
        },
        methods: {
            loadListBook: function () {
                axios({
                    method: 'get',
                    url: '/book'
                }).then(response => {
                    this.books = response.data;
            })
            },
            loadListWish: function () {
                axios({
                    method: 'get',
                    url: '/wish'
                }).then(response => {
                    this.wishes = response.data;
            })
                ;
            },
            addBook: function () {
                var params = new URLSearchParams();
                params.append('author', '2');
                params.append('nameBook', 'Вишневый сад');
                axios.post('/book', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                });
                this.loadListBook();
            },
            updateBook: function () {
                var params = new URLSearchParams();
                // params.append('nameBook', 'Избранное');
                // params.append('id', 1);
                axios.put('/book/' + this.books[0].id + '?nameBook=Избранное', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                });
                this.loadListBook();
            },
            deleteBook: function () {
                var params = new URLSearchParams();
                // params.append('id', this.books[0].id);
                axios.delete('/book/' + this.books[0].id, params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                });
                this.loadListBook();
            },
        },
        created: function () {
            this.loadListBook();
            this.loadListWish();
        },
    });
</script>
</html>


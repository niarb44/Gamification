//import React, { useState } from 'react';
//
//function Login() {
//  const [username, setUsername] = useState('');
//  const [password, setPassword] = useState('');
//
//  const handleSubmit = (e) => {
//    e.preventDefault();
//    // Call the backend login API
//    console.log('Logging in:', username);
//  };
//
//  return (
//    <div>
//      <h1>Login</h1>
//      <form onSubmit={handleSubmit}>
//        <input
//          type="text"
//          placeholder="Username"
//          value={username}
//          onChange={(e) => setUsername(e.target.value)}
//        />
//        <input
//          type="password"
//          placeholder="Password"
//          value={password}
//          onChange={(e) => setPassword(e.target.value)}
//        />
//        <button type="submit">Login</button>
//      </form>
//    </div>
//  );
//}
//
//export default Login;

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Logowanie</title>
</head>
<body>
    <h1>Logowanie</h1>
    <form th:action="@{/users/login}" method="post">
        <label for="username">Nazwa użytkownika:</label>
        <input type="text" id="username" name="username" required />
        <label for="password">Hasło:</label>
        <input type="password" id="password" name="password" required />
        <button type="submit">Zaloguj się</button>
    </form>
    <p th:if="${error}" th:text="${error}"></p>
</body>
</html>

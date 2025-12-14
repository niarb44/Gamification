

import React, { useState } from 'react';
import axios from 'axios';

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/login', { username, password });
            console.log('User logged in:', response.data);
            // Dodaj logikę do obsługi odpowiedzi serwera (np. przekierowanie na stronę główną)
        } catch (error) {
            console.error('Error logging in:', error);
            // Dodaj obsługę błędów (np. wyświetlenie komunikatu o błędzie logowania)
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            <button type="submit">Log In</button>
        </form>
    );
};

export default LoginForm;

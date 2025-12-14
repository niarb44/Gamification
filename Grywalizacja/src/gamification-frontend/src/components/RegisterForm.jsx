

import React, { useState } from 'react';
import axios from 'axios';

const RegisterForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/register', { username, password });
            console.log('User registered:', response.data);
            // Dodaj logikę do obsługi odpowiedzi serwera (np. wyświetlenie komunikatu o sukcesie)
        } catch (error) {
            console.error('Error registering user:', error);
            // Dodaj obsługę błędów (np. wyświetlenie komunikatu o błędzie)
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
            <button type="submit">Register</button>
        </form>
    );
};

export default RegisterForm;

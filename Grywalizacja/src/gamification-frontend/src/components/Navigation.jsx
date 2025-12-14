

import React from 'react';
import { Link } from 'react-router-dom';

const Navigation = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/register">Register</Link></li>
                <li><Link to="/login">Log In</Link></li>
                {/* Dodaj inne linki do nawigacji */}
            </ul>
        </nav>
    );
};

export default Navigation;

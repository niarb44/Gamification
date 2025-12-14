import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ThemeSelector = () => {
    const [themes, setThemes] = useState([]);
    const [selectedTheme, setSelectedTheme] = useState("");

    useEffect(() => {
        axios.get('/api/themes')
            .then(response => setThemes(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleThemeSelect = (theme) => {
        setSelectedTheme(theme);
        axios.post('/api/selectTheme', theme)
            .catch(error => console.error(error));
    }

    return (
        <div>
            <h2>Wybierz motyw:</h2>
            <ul>
                {themes.map((theme, index) => (
                    <li key={index} onClick={() => handleThemeSelect(theme)}>
                        {theme}
                    </li>
                ))}
            </ul>
            {selectedTheme && <p>Wybrany motyw: {selectedTheme}</p>}
        </div>
    );
}

export default ThemeSelector;

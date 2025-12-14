import React, { useEffect, useState } from 'react';
import axios from 'axios';

const UserProfile = ({ userId }) => {
    const [user, setUser] = useState(null);

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const response = await axios.get(`/api/users/${userId}`);
                setUser(response.data);
            } catch (error) {
                console.error('Error fetching user:', error);
            }
        };
        fetchUser();
    }, [userId]);

    if (!user) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>User Profile: {user.username}</h2>
            <p>Email: {user.email}</p>
            {/* Wyświetlanie innych informacji o użytkowniku */}
        </div>
    );
};

export default UserProfile;

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RewardSelector = () => {
    const [rewards, setRewards] = useState([]);
    const [selectedReward, setSelectedReward] = useState("");

    useEffect(() => {
        axios.get('/api/rewards')
            .then(response => setRewards(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleRewardSelect = (reward) => {
        setSelectedReward(reward);
        axios.post('/api/selectReward', reward)
            .catch(error => console.error(error));
    }

    return (
        <div>
            <h2>Wybierz rodzaj nagród:</h2>
            <ul>
                {rewards.map((reward, index) => (
                    <li key={index} onClick={() => handleRewardSelect(reward)}>
                        {reward}
                    </li>
                ))}
            </ul>
            {selectedReward && <p>Wybrany rodzaj nagród: {selectedReward}</p>}
        </div>
    );
}

export default RewardSelector;

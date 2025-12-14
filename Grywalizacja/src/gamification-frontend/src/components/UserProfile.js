import React from 'react';

function UserProfile() {
  const user = {
    name: "John Doe",
    level: 5,
    points: 1200,
    rewards: ["Badge 1", "Badge 2"]
  };

  return (
    <div>
      <h1>Profile: {user.name}</h1>
      <p>Current Level: {user.level}</p>
      <p>Points: {user.points}</p>
      <h2>Your Rewards</h2>
      <ul>
        {user.rewards.map(reward => (
          <li key={reward}>{reward}</li>
        ))}
      </ul>
    </div>
  );
}

export default UserProfile;

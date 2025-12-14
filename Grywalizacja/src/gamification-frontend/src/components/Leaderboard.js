import React from 'react';

function Leaderboard() {
  const users = [
    { name: 'User 1', level: 10, points: 2000 },
    { name: 'User 2', level: 8, points: 1700 },
    { name: 'User 3', level: 7, points: 1500 },
  ];

  return (
    <div>
      <h1>Leaderboard</h1>
      <ul>
        {users.map((user, index) => (
          <li key={index}>
            {user.name} - Level {user.level}, Points: {user.points}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Leaderboard;

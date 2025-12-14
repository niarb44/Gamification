import React from 'react';

const Reward = ({ reward }) => {
  return (
    <div>
      <h3>{reward.name}</h3>
      <p>Type: {reward.type}</p>
      <p>Level Required: {reward.levelRequired}</p>
    </div>
  );
};

export default Reward;

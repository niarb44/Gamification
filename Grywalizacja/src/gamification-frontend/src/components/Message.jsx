import React from 'react';

const Message = ({ type, text }) => {
    return (
        <div className={`message ${type}`}>
            {text}
        </div>
    );
};

export default Message;

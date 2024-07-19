import React, { useState } from "react";

const CardTarefa = ({ system, type, state, color }) => {
  const [isHovered, setIsHovered] = useState(false);

  const style = {
    backgroundColor: color,
    width: "400px",
    height: isHovered ? "300px" : "100px",
    borderRadius: "20px",
    transition: "height 0.5s ease",
    boxShadow: "0px 0px 15px rgba(0, 0, 0, 0.1)",
  };

  return (
    <div
      style={style}
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
    >
      <h3>{`[${system}]`}</h3>
      <p>
        {state} - {type}
      </p>
    </div>
  );
};

export default CardTarefa;

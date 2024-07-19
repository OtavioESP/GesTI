import React from "react";

const ChartContainer = ({ type, children }) => {
  const selectStyle = (type) => {
    switch (type) {
      case "pie":
        return { width: "550px", height: "400px" };
      case "radial":
        return { width: "550px", height: "400px" };
      case "linear":
        return { width: "800px", height: "300px" };
      case "bar":
        return { width: "400px", height: "300px" };
      default:
        return { width: "50px", height: "50px" };
    }
  };

  return (
    <div
      style={{
        ...selectStyle(type),
        boxShadow: "0px 10px 15px rgba(0, 0, 0, 0.1)",
        borderRadius: "30px",
      }}
    >
      {children}
    </div>
  );
};
export default ChartContainer;

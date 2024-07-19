import React from "react";
import ProfilePic from "../assets/images/profilePic.png";

const Header = () => {
  return (
    <div
      style={{
        width: "100%",
        display: "flex",
        height: "130px",
        flexDirection: "row",
        backgroundColor: "white",
        justifyContent: "space-between",
        borderBottomLeftRadius: "20px",
        borderBottomRightRadius: "20px",
        boxShadow: "0px 10px 15px rgba(0, 0, 0, 0.1)",
        alignItems: "center",
      }}
    >
      <h1 style={{ marginLeft: "40px" }}>Logo</h1>
      <div
        style={{ marginRight: "40px", display: "flex", flexDirection: "row" }}
      >
        <h1 style={{ marginRight: "40px" }}> name </h1>
        <img
          src={ProfilePic}
          alt="Foto de perfil"
          style={{
            borderRadius: "50%",
            width: "70px",
            height: "70px",
            cursor: "pointer",
          }}
        />
      </div>
    </div>
  );
};

export default Header;

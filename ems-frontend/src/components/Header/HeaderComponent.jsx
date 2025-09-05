import React from "react";
import "./Header.css";
import { useNavigate } from "react-router-dom";

const HeaderComponent = () => {
  const navigate = useNavigate();

  const handleme = () => {
    navigate("/");
  };
  return (
    <header className="header">
      <div className="header-container">
        <h1 className="header-title" onClick={handleme}>
          OfficeAxis🏢🧑‍💼
        </h1>
      </div>
      <div className="header-buttons">
        <button onClick={handleme}>Home🏠</button>
      </div>
    </header>
  );
};

export default HeaderComponent;

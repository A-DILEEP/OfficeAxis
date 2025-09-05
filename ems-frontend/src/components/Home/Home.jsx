import React from "react";
import "./Home.css";
import { useNavigate } from "react-router-dom";
function Home() {
  const navigate = useNavigate();
  const addEmp = () => {
    navigate("/add-employee");
  };
  const viewAllEmp = () => {
    navigate("/employee");
  };
  const addDept = () => {
    navigate("/add-department");
  };
  const viewAllDept = () => {
    navigate("/department");
  };
  return (
    <div className="home-page">
      <div className="home-card">
        <div className="home-row">
          <div className="home-btn-wrap">
            <button className="home-btn" onClick={viewAllEmp}>
              View All Employees 🗒️
            </button>
          </div>
          <div className="home-btn-wrap">
            <button className="home-btn" onClick={addEmp}>
              Add Employee ➕🧑‍💼
            </button>
          </div>
        </div>
        <div className="home-row">
          <div className="home-btn-wrap">
            <button className="home-btn" onClick={addDept}>
              Add Department
            </button>
          </div>
          <div className="home-btn-wrap">
            <button className="home-btn" onClick={viewAllDept}>
              View All Departments
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;

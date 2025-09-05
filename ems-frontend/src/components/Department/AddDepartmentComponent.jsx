import React, { useState } from "react";
import { addDepartment } from "../../service/DepartmentService";
import { useNavigate } from "react-router-dom";

function AddDepartmentComponent() {
  const [name, setName] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    const department = { name }; 
    addDepartment(department)
      .then((res) => {
        navigate("/employee"); 
      })
      .catch((err) => console.error("Error adding department:", err));
  };

  return (
    <div className="container">
      <h2 className="title">Add Department</h2>
      <form className="form" onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Department Name</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter department name"
            required
          />
        </div>
        <button type="submit" className="btn primary">
          Save Department
        </button>
        <button
          type="button"
          className="btn danger"
          onClick={() => navigate(-1)}
        >
          Cancel
        </button>
      </form>
    </div>
  );
}

export default AddDepartmentComponent;

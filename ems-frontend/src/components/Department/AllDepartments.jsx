import React, { useEffect, useState } from "react";
import {
  deleteDepartment,
  getAllDepartments,
} from "../../service/DepartmentService";
import "./AllDepartments.css";
function AllDepartments() {
  const [departments, setDepartments] = useState([]);
  useEffect(() => {
    getAllDepartments().then((Response) => {
      setDepartments(Response.data);
    });
  }, []);
  const deleteDept = (id) => {
    deleteDepartment(id)
      .then(() => {
        setDepartments((prev) => prev.filter((dep) => dep.id !== id));
      })
      .catch((e) => console.log(e));
  };
  return (
    <div className="AllDepartments">
      <div className="myt">
        <table className="Department-table">
          <thead>
            <tr>
              <th>Department ID</th>
              <th>Department Name</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {departments.map((dept) => (
              <tr key={dept.id}>
                <td>{dept.id}</td>
                <td>{dept.name}</td>
                <td>
                  <button
                    className="btn danger"
                    onClick={() => deleteDept(dept.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
            {departments.length === 0 && (
              <tr>
                <td colSpan="5" style={{ textAlign: "center" }}>
                  No departments found
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default AllDepartments;

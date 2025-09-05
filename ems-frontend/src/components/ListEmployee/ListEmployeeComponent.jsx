import React, { useEffect, useState } from "react";
import { deleteEmployee, listEmployees } from "../../service/EmployeeService";
import { useNavigate } from "react-router-dom";
import "./ListEmployee.css";
import HeaderComponent from "../Header/HeaderComponent";

function ListEmployeeComponent() {
  const [employee, setEmployee] = useState([]);
  const [search, setSearch] = useState("");
  const [sortField, setSortField] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");
  const navigator = useNavigate();

  useEffect(() => {
    listEmployees()
      .then((response) => {
        console.log("API raw response:", response);
        setEmployee(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  function addNewEmployee() {
    navigator("/add-employee");
  }
  function updateEmp(id) {
    navigator(`/edit-employee/${id}`);
  }
  function detailInfo(id) {
    navigator(`/employee/${id}`);
  }
  function addNewDept() {
    navigator(`/add-department`);
  }
  function deleteEmp(id) {
    deleteEmployee(id)
      .then(() => {
        setEmployee((prev) => prev.filter((emp) => emp.id !== id));
        console.log("Deleted employee with id:" + id);
      })
      .catch((e) => console.log(e));
  }

  function handleSort(field) {
    const order = sortField === field && sortOrder === "asc" ? "desc" : "asc";
    setSortField(field);
    setSortOrder(order);
    const sorted = [...employee].sort((a, b) => {
      if (a[field] < b[field]) return order === "asc" ? -1 : 1;
      if (a[field] > b[field]) return order === "asc" ? 1 : -1;
      return 0;
    });
    setEmployee(sorted);
  }

  const filteredEmployees = employee.filter(
    (emp) =>
      emp.firstName.toLowerCase().includes(search.toLowerCase()) ||
      emp.lastName.toLowerCase().includes(search.toLowerCase()) ||
      emp.email.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="container">
      <h2 className="title">Employees List</h2>
      <button className="btn primary" onClick={addNewEmployee}>
        Add Employee
      </button>
      <button className="btn primary" onClick={addNewDept}>
        Add Department
      </button>
      <input
        type="text"
        placeholder="Search by Name or Email"
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        className="search-box"
      />
      <div>
        <table className="employee-table">
          <thead>
            <tr>
              <th onClick={() => handleSort("id")}>Employee ID</th>
              <th onClick={() => handleSort("firstName")}>First Name</th>
              <th onClick={() => handleSort("lastName")}>Last Name</th>
              <th onClick={() => handleSort("email")}>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {filteredEmployees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>
                  <button
                    className="btn details"
                    onClick={() => detailInfo(employee.id)}
                  >
                    Details
                  </button>
                  <button
                    className="btn info"
                    onClick={() => updateEmp(employee.id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn danger"
                    onClick={() => deleteEmp(employee.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
            {filteredEmployees.length === 0 && (
              <tr>
                <td colSpan="5" style={{ textAlign: "center" }}>
                  No employees found
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ListEmployeeComponent;

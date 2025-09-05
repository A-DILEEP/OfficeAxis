import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getEmployee } from "../../service/EmployeeService";
import "./DetailEmployee.css";
import img from "../../assets/defaultImg.jpg";

function DetailEmployee() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [department, setDepartment] = useState("General");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getEmployee(id)
        .then((res) => {
          setFirstName(res.data.firstName);
          setLastName(res.data.lastName);
          setEmail(res.data.email);
          setDepartment(res.data.department?.name || "General"); 
          setCity(res.data.addressDto?.city || "");
          setState(res.data.addressDto?.state || "");
        })
        .catch((e) => console.log(e));
    }
  }, [id]);
  return (
    <div className="DetailsEmp">
      <div className="DetailsCard">
        <div className="dc">
          <img src={img} alt="profile" />
        </div>
        <div className="te">
          <p>First Name:</p> <span>{firstName}</span>
        </div>
        <div className="te">
          <p>Last Name:</p> <span>{lastName}</span>
        </div>
        <div className="te">
          <p>Email:</p> <span>{email}</span>
        </div>
        <div className="te">
          <p>Department:</p> <span>{department}</span>
        </div>
      </div>
      <div className="DetailsCard">
        <h3 className="card-title">Address</h3>
        <div className="te">
          <p>City:</p> <span>{city}</span>
        </div>
        <div className="te">
          <p>State:</p> <span>{state}</span>
        </div>
      </div>
    </div>
  );
}

export default DetailEmployee;

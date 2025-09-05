import "./App.css";
import HeaderComponent from "./components/Header/HeaderComponent.jsx";
import FooterComponent from "./components/Footer/FooterComponent.jsx";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListEmpCo from "./components/ListEmployee/ListEmployeeComponent.jsx";
import EmpCompo from "./components/Employee/EmployeeComponent.jsx";
import DetailEmployee from "./components/DetailEmp/DetailEmployee.jsx";
import { Suspense } from "react";
import AddDepartmentComponent from "./components/Department/AddDepartmentComponent.jsx";
import Home from "./components/Home/Home.jsx";
import AllDepartments from "./components/Department/AllDepartments.jsx";
function App() {
  return (
    <div className="app-wrapper">
      <BrowserRouter>
        <HeaderComponent />
        <main className="flex-grow">
          <Suspense fallback={<h2>Loading Page...</h2>}>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/employee" element={<ListEmpCo />} />
              <Route path="/employee/:id" element={<DetailEmployee />} />
              <Route path="/add-employee" element={<EmpCompo />} />
              <Route path="/department" element={<AllDepartments />} />
              <Route path="/edit-employee/:id" element={<EmpCompo />} />
              <Route
                path="/add-department"
                element={<AddDepartmentComponent />}
              />
            </Routes>
          </Suspense>
        </main>
      </BrowserRouter>
    </div>
  );
}

export default App;

import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL + "/api/departments";

export const getAllDepartments = () => {
  return axios.get(API_BASE_URL);
};

export const addDepartment = (department) => {
  return axios.post(API_BASE_URL, department);
};

export const deleteDepartment=(deptId)=>{
  return axios.delete(API_BASE_URL+"/"+deptId);
}
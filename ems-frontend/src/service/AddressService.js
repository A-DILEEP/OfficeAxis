import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL + "/api/address";

export const listAddress = () => {
  return axios.get(API_BASE_URL);
};

export const createDepartment = (department) => {
  return axios.post(API_BASE_URL, department);
};

export const getDepartment = (departmentId) => {
  return axios.get(API_BASE_URL + "/" + employeeId);
};

export const updateDepartment = (departmentId, department) => {
  return axios.put(API_BASE_URL + "/" + departmentId, department);
};

export const deleteDepartment = (departmentId) => {
  return axios.delete(API_BASE_URL + "/" + departmentId);
};

import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL+"/api/employee";

export const listEmployees = () => {
  return axios.get(API_BASE_URL);
};

export const createEmployee = (employee) => {
  return axios.post(API_BASE_URL, employee);
};

export const getEmployee = (employeeId) => {
  return axios.get(API_BASE_URL + "/" + employeeId);
};

export const updateEmployee = (employeeId, employee) => {
  return axios.put(API_BASE_URL + "/" + employeeId, employee);
};

export const deleteEmployee = (employeeId) => {
  return axios.delete(API_BASE_URL + "/" + employeeId);
};

import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL + "/api/projects";

export const getAllProjects = () => {
  return axios.get(API_BASE_URL);
};

export const createProject = (project) => {
  return axios.post(API_BASE_URL, project);
};

export const getProject = (projectId) => {
  return axios.get(API_BASE_URL + "/" + projectId);
};

export const updateProject = (projectId, project) => {
  return axios.put(API_BASE_URL + "/" + projectId, project);
};

export const deleteProject = (projectId) => {
  return axios.delete(API_BASE_URL + "/" + projectId);
};

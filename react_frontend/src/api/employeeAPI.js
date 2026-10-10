import { axiosClient } from "./axiosClient";

const Base='/employees'

export const employeeAPI={
  getEmployees : ()=> axiosClient.get(`${Base}/getEmployees`).then(r=> r.data),
  getEmpById : (id)=> axiosClient.get(`${Base}/getEmployee/${id}`).then(r=>r.data),
  updateEmployee : (id,employee)=> axiosClient.put(`${Base}/updateEmployee/${id}`,employee).then(r=>r.data),
  deleteEmployee : (id)=> axiosClient.delete(`${Base}/deleteEmployee/${id}`).then(r=>r.data),
  createEmployee : (employee)=> axiosClient.post(`${Base}/createEmployee`,employee).then(r=>r.data)
}
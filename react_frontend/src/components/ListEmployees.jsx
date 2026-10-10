import React, { useEffect, useState } from "react";
import { employeeAPI } from "../api/EmployeeAPI";
import { useNavigate } from "react-router-dom";

export const ListEmployees = () => {
  const [employeesList, setEmployeesList] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate=useNavigate();
  useEffect(() => {
    employeeAPI
      .getEmployees()
      .then(setEmployeesList)
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  if(loading) return <p className="mt-50 text-center">Loading...</p>
  if(error) return <p className="mt-50 text-center text-red-700 mt">Error:{error}</p>

  const handleDelete = (id) =>{
    employeeAPI.deleteEmployee(id).then(data=>{
      setEmployeesList((employeesList)=> employeesList.filter((employee)=> employee.id!==id));
      alert(data);
    });
  }

  return (
    <div className="max-w-3xl mx-auto p-6">
      <h2 className="text-2xl text-blue-800 text-center font-extrabold font-mono">
        List of Employees
      </h2>
      <div className="flex justify-end m-0.5">
        <button className="rounded bg-blue-600 px-2 py-2 text-white hover:bg-blue-700" onClick={()=>{navigate("/addEmployee")}}>Add Employee</button>
      </div>
      <div className="overflow-hidden rounded-lg shadow border border-gray-200">
        <table className="w-full text-left text-sm text-gray-700">
          <thead className="bg-gray-100 text-gray-600 uppercase text-xs">
            <tr>
              <th className="px-4 py-3">ID</th>
              <th className="px-4 py-3">First Name</th>
              <th className="px-4 py-3">Last Name</th>
              <th className="px-4 py-3">Email</th>
              <th className="px-4 py-3">Action</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-200">
            {employeesList.map((employee) => (
              <tr key={employee.id} className="hover:bg-gray-50 transition">
                <td className="px-4 py-3">{employee.id}</td>
                <td className="px-4 py-3 font-medium">{employee.firstName}</td>
                <td className="px-4 py-3">{employee.lastName}</td>
                <td className="px-4 py-3 text-blue-600">{employee.email}</td>
                <td>
                  <button className="px-4 py-3 bg-blue-500 text-green-200 rounded-sm mx-1 my-2" onClick={()=>{navigate(`/updateEmployee/${employee.id}`)}}>Update</button>
                  <button className="px-4 py-3 bg-red-500 text-white rounded-sm mx-1 my-2" onClick={()=>{handleDelete(employee.id)}}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

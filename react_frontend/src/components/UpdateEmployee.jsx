import { useEffect, useState } from "react";
import { employeeAPI } from "../api/EmployeeAPI";
import { useNavigate, useParams } from "react-router-dom";

const UpdateEmployee = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [employee, setEmployee] = useState(null);
  const navigate = useNavigate();
  const {id}=useParams();

  const handleSubmit = (event) => {
    event.preventDefault();
    setEmployee({ firstName, lastName, email });
    employeeAPI.updateEmployee(id,employee).then((data) => {
      alert(`employee of name ${data.firstName} is updated`);
      navigate("/");
    });
  };

  useEffect(()=>{
    employeeAPI.getEmpById(id).then(data=>{
      setFirstName(data.firstName);
      setLastName(data.lastName);
      setEmail(data.email);
    })
  },[id])

  return (
    <div className="flex flex-col">
      <div className="mt-3 ml-5">
        <button
          className="bg-blue-500 text-white rounded px-3"
          onClick={() => navigate("/employees")}
        >
          Back
        </button>
      </div>
      <form
        onSubmit={handleSubmit}
        className="mx-auto mt-8 max-w-md space-y-4 rounded-lg border border-gray-200 p-6 shadow"
      >
        <h2 className="text-center text-2xl font-bold text-blue-800 sticky">
          Update Employee
        </h2>
        <input
          type="text"
          placeholder="First name"
          value={firstName}
          onChange={(event) => setFirstName(event.target.value)}
          className="w-full rounded border border-gray-300 px-3 py-2"
          required
        />
        <input
          type="text"
          placeholder="Last name"
          value={lastName}
          onChange={(event) => setLastName(event.target.value)}
          className="w-full rounded border border-gray-300 px-3 py-2"
          required
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
          className="w-full rounded border border-gray-300 px-3 py-2"
          required
        />
        <button
          type="submit"
          className="w-full rounded bg-blue-600 px-4 py-2 font-medium text-white hover:bg-blue-700"
        >
          Update
        </button>
      </form>
    </div>
  );
};

export default UpdateEmployee;

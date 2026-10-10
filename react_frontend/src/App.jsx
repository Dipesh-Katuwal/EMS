import './App.css'
import AddEmployee from './components/AddEmployee'
import { Footer } from './components/Footer'
import { Header } from './components/Header'
import { ListEmployees } from './components/ListEmployees'
import { Routes,Route } from 'react-router-dom'
import UpdateEmployee from './components/UpdateEmployee'
function App() {

  return (
    <div className="flex min-h-screen flex-col">
      <Header />
      <main className="flex-1">
        <Routes>
          <Route path='/' element={<ListEmployees/>}></Route>
          <Route path='/employees' element={<ListEmployees/>}></Route>
          <Route path='/addEmployee' element={<AddEmployee/>}></Route>
          <Route path="/updateEmployee/:id" element={<UpdateEmployee/>}></Route>
        </Routes>
      </main>
      <Footer />
    </div>
  )
}

export default App
